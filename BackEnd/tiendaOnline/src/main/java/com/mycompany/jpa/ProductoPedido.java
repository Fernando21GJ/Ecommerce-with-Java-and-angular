/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedep
 */
@Entity
@Table(name = "producto_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPedido.findAll", query = "SELECT p FROM ProductoPedido p")
    , @NamedQuery(name = "ProductoPedido.findByIdproductoPedido", query = "SELECT p FROM ProductoPedido p WHERE p.idproductoPedido = :idproductoPedido")
    , @NamedQuery(name = "ProductoPedido.findByIdProducto", query = "SELECT p FROM ProductoPedido p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "ProductoPedido.findByIdPedido", query = "SELECT p FROM ProductoPedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "ProductoPedido.findByIdUsuario", query = "SELECT p FROM ProductoPedido p WHERE p.idUsuario = :idUsuario")})
public class ProductoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproducto_pedido")
    private Integer idproductoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public ProductoPedido() {
    }

    public ProductoPedido(Integer idproductoPedido) {
        this.idproductoPedido = idproductoPedido;
    }

    public ProductoPedido(Integer idproductoPedido, int idProducto, int idPedido, int idUsuario) {
        this.idproductoPedido = idproductoPedido;
        this.idProducto = idProducto;
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
    }

    public Integer getIdproductoPedido() {
        return idproductoPedido;
    }

    public void setIdproductoPedido(Integer idproductoPedido) {
        this.idproductoPedido = idproductoPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductoPedido != null ? idproductoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPedido)) {
            return false;
        }
        ProductoPedido other = (ProductoPedido) object;
        if ((this.idproductoPedido == null && other.idproductoPedido != null) || (this.idproductoPedido != null && !this.idproductoPedido.equals(other.idproductoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tiendaonline.ProductoPedido[ idproductoPedido=" + idproductoPedido + " ]";
    }
    
}
