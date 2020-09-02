/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adolfo
 */
@Entity
@Table(name = "detalleFactura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetalle", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleFactura.findByCantidaProducto", query = "SELECT d FROM DetalleFactura d WHERE d.cantidaProducto = :cantidaProducto"),
    @NamedQuery(name = "DetalleFactura.findByPrecioCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.precioCantidad = :precioCantidad"),
    @NamedQuery(name = "DetalleFactura.findByTotal", query = "SELECT d FROM DetalleFactura d WHERE d.total = :total")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle")
    private Integer idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidaProducto")
    private int cantidaProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioCantidad")
    private BigDecimal precioCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Factura idFactura;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto idProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleFactura(Integer idDetalle, int cantidaProducto, BigDecimal precioCantidad, BigDecimal total, Producto IdProducto) {
        this.idDetalle = idDetalle;
        this.cantidaProducto = cantidaProducto;
        this.precioCantidad = precioCantidad;
        this.total = total;
        this.idProducto = IdProducto;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidaProducto() {
        return cantidaProducto;
    }

    public void setCantidaProducto(int cantidaProducto) {
        this.cantidaProducto = cantidaProducto;
    }

    public BigDecimal getPrecioCantidad() {
        return precioCantidad;
    }

    public void setPrecioCantidad(BigDecimal precioCantidad) {
        this.precioCantidad = precioCantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.DetalleFactura[ idDetalle=" + idDetalle + " ]";
    }
    
}
