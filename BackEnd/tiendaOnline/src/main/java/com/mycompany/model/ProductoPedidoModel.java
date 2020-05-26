/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;
import java.io.Serializable;
import com.mycompany.jpa.ProductoPedido;
/**
 *
 * @author AZ
 */
public class ProductoPedidoModel implements Serializable {
    
    private ProductoPedido productopedido;
    
    public ProductoPedidoModel() {
    }
    
    public ProductoPedidoModel(ProductoPedido productopedido){
         this.productopedido=productopedido;
    }

    public ProductoPedido getProductopedido() {
        return productopedido;
    }

    public void setProductopedido(ProductoPedido productopedido) {
        this.productopedido = productopedido;
    }
    
    
}
