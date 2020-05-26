/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;
import java.io.Serializable;
import com.mycompany.jpa.Pedido;
/**
 *
 * @author AZ
 */
public class PedidoModel implements Serializable{
    
    private Pedido pedido;
    
    public PedidoModel() {
    }
    
    public PedidoModel(Pedido pedido){
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
