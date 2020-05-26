/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.inject.Named;
import com.mycompany.facade.UsuarioFacade;
import com.mycompany.model.UsuarioModel;
import java.io.Serializable;
/**
 *
 * @author AZ
 */

@Named(value = "usuarioBusiness")
@Stateless
public class UsuarioBusiness implements Serializable{
    
    @EJB
   private UsuarioFacade usuarioFacade;
   public UsuarioModel guardarUsuario(UsuarioModel usuarioModel) {
       usuarioModel.setUsuario(usuarioFacade.registrarUsuario(usuarioModel.getUsuario()));
       return usuarioModel;
   }
   
   @EJB
   public UsuarioModel modificarUsuario(UsuarioModel usuarioModel) {
       usuarioModel.setUsuario(usuarioFacade.modificarUsuario(usuarioModel.getUsuario()));
       return usuarioModel;
   }
   
   @EJB
   public void eliminarUsuario(Integer id)
   {
       usuarioFacade.eliminarUsuario(id);
   }
}
