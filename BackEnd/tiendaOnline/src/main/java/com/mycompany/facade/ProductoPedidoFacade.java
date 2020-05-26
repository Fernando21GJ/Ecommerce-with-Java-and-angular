/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;


import com.mycompany.jpa.ProductoPedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedep
 */
@Stateless
public class ProductoPedidoFacade extends AbstractFacade<ProductoPedido> {

    @PersistenceContext(unitName = "com.mycompany_tiendaOnline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoPedidoFacade() {
        super(ProductoPedido.class);
    }
    
    public ProductoPedido registrarProductoPedido(ProductoPedido productoPedido) {
        create(productoPedido);
        em.flush();
        return productoPedido;
    }

    public ProductoPedido modificarProductoPedido(ProductoPedido productoPedido) {
        em.merge(productoPedido);
        em.flush();
        return productoPedido;
   }
    
    public void eliminarProductoPedido(Integer id) {
       em.remove(find(id));
       em.flush();
   }
}
