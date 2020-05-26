/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;
import java.io.Serializable;
import com.mycompany.jpa.Productos;
/**
 *
 * @author AZ
 */
public class ProductosModel implements Serializable {
    
    private Productos productos;
    
    public ProductosModel() {
    }
    
    public ProductosModel(Productos productos){
        this.productos = productos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    
    
    
}
