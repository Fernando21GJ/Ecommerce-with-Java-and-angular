/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;


import com.mycompany.jpa.Productos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedep
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "com.mycompany_tiendaOnline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
     public Productos registrarProductos(Productos productos) {
        create(productos);
        em.flush();
        return productos;
    }

    public Productos modificarProductos(Productos productos) {
        em.merge(productos);
        em.flush();
        return productos;
   }
    
    public void eliminarProductos(Integer id) {
       em.remove(find(id));
       em.flush();
   }
        
}
