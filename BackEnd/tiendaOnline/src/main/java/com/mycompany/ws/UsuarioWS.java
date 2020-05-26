/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws;

import com.mycompany.business.UsuarioBusiness;
import com.mycompany.facade.UsuarioFacade;
import com.mycompany.jpa.Usuario;
import com.mycompany.model.LoginModel;
import com.mycompany.model.SesionModel;
import com.mycompany.model.UsuarioModel;
import com.mycompany.util.Password;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Enrique
 */
@Path("UsuarioWS")
@Stateless
public class UsuarioWS {
    @EJB
    private UsuarioFacade usuarioFacade;
    
      
    @GET
    @Path("usuarios")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> buscarUsuarios() {
        return usuarioFacade.buscarUsuarios();
    }
    
    @GET
    @Path("usuario/ ")
    @Produces({MediaType.APPLICATION_JSON})
    public SesionModel buscarUsuarios( LoginModel login ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
       SesionModel sesion = new SesionModel();
       Usuario user;
       user = usuarioFacade.buscarUsuario(login.getCorreo());
       if(user.getContrasena().equals( Password.encryptPassword(login.getContrasena()))){
           sesion.setUsuario(user);
           sesion.setToken("Aqui va un token bien pro");
       }else{
           sesion = null;
       }
       return sesion;
    }
    
    @Inject
    private UsuarioBusiness usuarioBusiness;

    @POST
    @Path("guardarUsuario")
    @Produces({MediaType.APPLICATION_JSON})
//    @Secured
    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("guardarUsuario");
        usuarioModel.getUsuario().setContrasena(Password.encryptPassword(usuarioModel.getUsuario().getContrasena()));
        usuarioBusiness.guardarUsuario(usuarioModel);
        return usuarioModel;
    }
    
    
@PUT
   @Path("actualizarUsuario")
   @Consumes({MediaType.APPLICATION_JSON})
   public UsuarioModel modificarUsuario(UsuarioModel usuarioModel) {
      System.out.println("UsuarioActualizado");
      usuarioBusiness. modificarUsuario(usuarioModel);
      return usuarioModel;
   }
   
   @DELETE
   @Path("eliminar/{usuarioId}")
   public void eliminarUsuarioId(@PathParam("usuarioId")Integer id) {
       usuarioBusiness.eliminarUsuario(id);
   }
    
}
