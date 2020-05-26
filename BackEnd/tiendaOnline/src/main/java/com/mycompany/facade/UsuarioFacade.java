/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;


import com.mycompany.jpa.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedep
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.mycompany_tiendaOnline_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public List<Usuario> buscarUsuarios(){
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }
    public Usuario buscarUsuario(String correo){
        return em.createQuery("SELECT u FROM Usuario u where u.correo = :correo", Usuario.class).setParameter(correo,"correo")
                .getSingleResult();
    }
    public Usuario registrarUsuario(Usuario usuario) {
        create(usuario);
        em.flush();
        return usuario;
    }

    public Usuario modificarUsuario(Usuario usuario) {
        em.merge(usuario);
        em.flush();
        return usuario;
   }
    
    public void eliminarUsuario(Integer id) {
       em.remove(find(id));
       em.flush();
   }
         
}
