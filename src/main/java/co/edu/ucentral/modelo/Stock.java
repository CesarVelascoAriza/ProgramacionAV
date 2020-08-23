/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

public class Stock {

    private int idStock;
    private Producto producto;
    private int catidad;

    public Stock() {
    }

    public Stock(int idStock, Producto producto, int catidad) {
        this.idStock = idStock;
        this.producto = producto;
        this.catidad = catidad;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }
    
    
}
