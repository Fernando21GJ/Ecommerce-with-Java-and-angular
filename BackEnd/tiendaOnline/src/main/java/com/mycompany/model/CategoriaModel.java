/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;
import java.io.Serializable;
import com.mycompany.jpa.Categoria;
/**
 *
 * @author fedep
 */
public class CategoriaModel implements Serializable {
    
    private Categoria categoria;
    
    public CategoriaModel() {
    }

    public CategoriaModel(Categoria categoria){
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
