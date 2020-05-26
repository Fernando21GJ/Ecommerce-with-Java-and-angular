/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.jpa.Categoria;
import com.mycompany.jpa.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedep
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "com.mycompany_tiendaOnline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    public Pedido registrarPedido(Pedido pedido) {
        create(pedido);
        em.flush();
        return pedido;
    }
    
     public Pedido modificarPedido(Pedido pedido) {
       em.merge(pedido);
       em.flush();
       return pedido;
    }
     
    public void eliminarPedido(Integer id) {
       em.remove(find(id));
       em.flush();
   } 
}
