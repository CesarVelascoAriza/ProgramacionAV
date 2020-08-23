/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

/**
 *
 * @author fredy Gamer
 */
public class DetalleFactura {

    private int idDetalle;
    private Producto producto;
    private int cantidaProducto;
    private double precioCantidad;
    private double total;

    public DetalleFactura() {
    }

    public DetalleFactura(int idDetalle,Producto idProducto, int cantidaProducto, double precioCantidad, double total) {
        this.idDetalle = idDetalle;
        this.producto = idProducto;
        this.cantidaProducto = cantidaProducto;
        this.precioCantidad = precioCantidad;
        this.total = total;
    }

    
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getIdProducto() {
        return producto;
    }

    public void setIdProducto(Producto idProducto) {
        this.producto = idProducto;
    }

    public int getCantidaProducto() {
        return cantidaProducto;
    }

    public void setCantidaProducto(int cantidaProducto) {
        this.cantidaProducto = cantidaProducto;
    }

    public double getPrecioCantidad() {
        return precioCantidad;
    }

    public void setPrecioCantidad(double precioCantidad) {
        this.precioCantidad = precioCantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
