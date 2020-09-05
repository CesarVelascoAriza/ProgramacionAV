/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adolfo
 */
@Entity
@Table(name = "Producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByRutaImagen", query = "SELECT p FROM Producto p WHERE p.rutaImagen = :rutaImagen"),
    @NamedQuery(name = "Producto.findByPrecioUnidad", query = "SELECT p FROM Producto p WHERE p.precioUnidad = :precioUnidad"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto like :nombreProducto"),
    @NamedQuery(name = "Producto.findByCatidadProducto", query = "SELECT p FROM Producto p WHERE p.catidadProducto = :catidadProducto")
})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "rutaImagen")
    private String rutaImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnidad")
    private int precioUnidad;
    @Size(max = 50)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Column(name = "catidadProducto")
    private Integer catidadProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<DetalleFactura> detalleFacturaList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, String descripcion, String rutaImagen, int precioUnidad, int cantidadProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.precioUnidad = precioUnidad;
        this.catidadProducto = cantidadProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCatidadProducto() {
        return catidadProducto;
    }

    public void setCatidadProducto(Integer catidadProducto) {
        this.catidadProducto = catidadProducto;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Producto[ idProducto=" + idProducto + " ]";
    }

}
