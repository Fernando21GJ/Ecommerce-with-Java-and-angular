/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import javax.ejb.Stateless;
import javax.inject.Named;
import com.mycompany.model.ProductosModel;
import com.mycompany.facade.ProductosFacade;
import java.io.Serializable;
import javax.ejb.EJB;
/**
 *
 * @author AZ
 */

@Named(value = "productosBussines")
@Stateless
public class ProductosBusiness implements Serializable{
    
    @EJB
    private ProductosFacade productosFacade;
    public ProductosModel guardarProductos(ProductosModel productosModel) {
        productosModel.setProductos(productosFacade.registrarProductos(productosModel.getProductos()));
        return productosModel;
    }
    @EJB
    public ProductosModel modificarProductos(ProductosModel productosModel) {
        productosModel.setProductos(productosFacade.modificarProductos(productosModel.getProductos()));
        return productosModel;
    }
    
    @EJB
    public void eliminarProductos(Integer id)
    {
        productosFacade.eliminarProductos(id);
    }
}
