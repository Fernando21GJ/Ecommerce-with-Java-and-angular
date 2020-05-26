/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.facade.ProductoPedidoFacade;
import com.mycompany.model.ProductoPedidoModel;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author AZ
 */
@Named(value = "productoPedidoBusiness")
@Stateless
public class ProductoPedidoBusiness implements Serializable{
    
    @EJB
    private ProductoPedidoFacade productoPedidoFacade;
    public ProductoPedidoModel guardarProductoPedido(ProductoPedidoModel productoPedidoModel) {
        productoPedidoModel.setProductopedido(productoPedidoFacade.registrarProductoPedido(productoPedidoModel.getProductopedido()));
        return productoPedidoModel;
    }
    @EJB
    public ProductoPedidoModel modificarProductoPedido(ProductoPedidoModel productoPedidoModel) {
        productoPedidoModel.setProductopedido(productoPedidoFacade.modificarProductoPedido(productoPedidoModel.getProductopedido()));
        return productoPedidoModel;
    }
    
    @EJB
    public void eliminarProductoPedido(Integer id)
    {
        productoPedidoFacade.eliminarProductoPedido(id);
    }
}
