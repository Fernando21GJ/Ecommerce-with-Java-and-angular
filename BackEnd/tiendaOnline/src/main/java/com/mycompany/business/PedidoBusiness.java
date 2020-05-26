/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;


import javax.ejb.Stateless;
import javax.inject.Named;
import com.mycompany.facade.PedidoFacade;
import com.mycompany.model.PedidoModel;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author AZ
 */
@Named(value = "pedidoBusiness")
@Stateless
public class PedidoBusiness implements Serializable {
    
     @EJB
    private PedidoFacade pedidoFacade;
    public PedidoModel guardarPedido(PedidoModel pedidoModel) {
        pedidoModel.setPedido(pedidoFacade.registrarPedido(pedidoModel.getPedido()));
        return pedidoModel;
    }
    
    @EJB
    public PedidoModel modificarPedido(PedidoModel pedidoModel){
        pedidoModel.setPedido(pedidoFacade.modificarPedido(pedidoModel.getPedido()));
        return pedidoModel;
    }
    
    @EJB
    public void eliminarPedido(Integer id)
    {
        pedidoFacade.eliminarPedido(id);
    }   
}