/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fredy Gamer
 */
public class Factura {

    private int idFactura;
    private Cliente cliente;
    private Date fechaFactura;
    private double total;

    public Factura() {
    }

    public Factura(int idFactura, Cliente cliente, Date fechaFactura, double total) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Cliente getIdCliente() {
        return this.cliente;
    }

    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
