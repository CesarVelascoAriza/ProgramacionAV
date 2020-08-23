/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.util.Date;

/**
 *
 * @author fredy Gamer
 */
public class Cliente extends Usuario {

    private int IdCliente;
    private int documentoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private Date fechaNacimento;
    private String direccionCliente;

    public Cliente() {
    }

    public Cliente(int IdCliente, int documentoCliente, String nombreCliente, String apellidoCliente, Date fechaNacimento, String direccionCliente) {
        this.IdCliente = IdCliente;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.fechaNacimento = fechaNacimento;
        this.direccionCliente = direccionCliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public Date getFechaNacimento() {
        return fechaNacimento;
    }

    public void setFechaNacimento(Date fechaNacimento) {
        this.fechaNacimento = fechaNacimento;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

}
