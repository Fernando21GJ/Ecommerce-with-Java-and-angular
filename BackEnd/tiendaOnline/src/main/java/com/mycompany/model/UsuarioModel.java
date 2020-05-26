/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;
import java.io.Serializable;
import com.mycompany.jpa.Usuario;
/**
 *
 * @author AZ
 */
public class UsuarioModel implements Serializable {
    
    private Usuario usuario;
    
    public UsuarioModel() {
    }
    
    public UsuarioModel(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
