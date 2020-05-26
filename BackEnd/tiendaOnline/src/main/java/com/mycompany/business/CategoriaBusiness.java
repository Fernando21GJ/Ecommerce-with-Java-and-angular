/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Named;
import com.mycompany.model.CategoriaModel;
import com.mycompany.facade.CategoriaFacade;
import javax.ejb.EJB;


/**
 *
 * @author fedep
 */
@Named(value = "categoriaBusiness")
@Stateless
public class CategoriaBusiness implements Serializable {
    
     @EJB
    private CategoriaFacade categoriaFacade;
    public CategoriaModel guardarCategoria(CategoriaModel categoriaModel) {
        categoriaModel.setCategoria(categoriaFacade.registrarCategoria(categoriaModel.getCategoria()));
        return categoriaModel;

    }
    @EJB
    public CategoriaModel modificarCategoria(CategoriaModel categoriaModel) {
       categoriaModel.setCategoria(categoriaFacade.modificarCategoria(categoriaModel.getCategoria()));
         return categoriaModel;
   }
    
    @EJB
    public void eliminarCategoria(Integer id)
    {
       categoriaFacade.eliminarCategoria(id);
    }

}
