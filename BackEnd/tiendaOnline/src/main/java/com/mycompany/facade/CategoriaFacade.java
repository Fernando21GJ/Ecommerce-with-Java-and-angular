/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.jpa.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedep
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "com.mycompany_tiendaOnline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    public List<Categoria> buscarCategorias() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class)
                .getResultList();
    }
    public Categoria registrarCategoria(Categoria categoria) {
        create(categoria);
        em.flush();
        return categoria;
    }

    public Categoria modificarCategoria(Categoria categoria) {
       em.merge(categoria);
       em.flush();
       return categoria;
   }
    
    public void eliminarCategoria(Integer id) {
       em.remove(find(id));
       em.flush();
   }
    
}
