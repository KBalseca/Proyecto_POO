/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ricky
 */
public class BienRaiz {
    private double precio;
    private double dimensionAncho;
    private double dimensionProfundidad;
    private Agente encargado;
    private String ciudad;
    private String sector;
    private String direccion;
    private boolean estado;
    private int codigo;
    private String descripcion;

    public BienRaiz(double precio, double dimensionAncho, double dimensionProfundidad, Agente encargado, String direccion, String ciudad, String sector, int codigo, String descripcion) {
        this.precio = precio;
        this.dimensionAncho = dimensionAncho;
        this.dimensionProfundidad = dimensionProfundidad;
        this.encargado = encargado;
        this.ciudad = ciudad;
        this.sector = sector;
        this.direccion = direccion;
        estado = false;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDimensionAncho() {
        return dimensionAncho;
    }

    public double getDimensionProfundidad() {
        return dimensionProfundidad;
    }

    public Agente getEncargado() {
        return encargado;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getSector() {
        return sector;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public double calcularArea(double ancho, double profundidad){
        return ancho*profundidad;
    }
}
