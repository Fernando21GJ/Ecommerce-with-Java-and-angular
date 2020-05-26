/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws;

import com.mycompany.business.CategoriaBusiness;
import com.mycompany.facade.CategoriaFacade;
import com.mycompany.jpa.Categoria;
import com.mycompany.model.CategoriaModel;
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
 * @author fedep
 */
@Path("CategoriaWS")
@Stateless
public class CategoriaWS {
    
    @EJB
    private CategoriaFacade categoriaFacade;
    
    
    @GET
    @Path("categorias")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Categoria> buscarCategorias() {
        return categoriaFacade.buscarCategorias();
    }
    
    
    @Inject
    private CategoriaBusiness categoriaBusiness;

    @POST
    @Path("guardarCategoria")
    @Produces({MediaType.APPLICATION_JSON})
//    @Secured
    public CategoriaModel guardarNoticia(CategoriaModel categoriaModel) {
        System.out.println("guardarCategoria");
        categoriaBusiness.guardarCategoria(categoriaModel);
        return categoriaModel;
    }
    
    
@PUT
   @Path("actualizarCategoria")
   @Consumes({MediaType.APPLICATION_JSON})
   public CategoriaModel modificarNoticia(CategoriaModel categoriaModel) {
       System.out.println("CategoriaActualizada");
      categoriaBusiness. modificarCategoria(categoriaModel);
      return categoriaModel;
   }
   
   @DELETE
   @Path("eliminar/{categoria}")
   public void eliminarNoticiaId(@PathParam("categoria")Integer id) {
       categoriaBusiness.eliminarCategoria(id);
   }
    
}
