/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedad;

import Usuarios.*;

/**
 *
 * @author ricky
 */
public class BienRaiz {
    private double precio;
    private double dimensionAncho;
    private double dimensionProfundidad;
    private Usuario encargado;
    private String provincia;
    private String ciudad;
    private String sector;
    private String direccion;
    private boolean estado;
    private int codigo;
    private String descripcion;

    public BienRaiz(double precio, double dimensionAncho, double dimensionProfundidad, Usuario encargado, String provincia, String direccion, String ciudad, String sector, int codigo, String descripcion) {
        this.precio = precio;
        this.dimensionAncho = dimensionAncho;
        this.dimensionProfundidad = dimensionProfundidad;
        this.encargado = encargado;
        this.provincia = provincia;
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

    public Usuario getEncargado() {
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

    public String getProvincia() {
        return provincia;
    }
    
    @Override
    public boolean equals(Object obj){
        BienRaiz b1 = (BienRaiz) obj;
        if (this.codigo == b1.codigo){
            return true;
        }else{
            return false;
        }
    }    
    
    public double calcularArea(double ancho, double profundidad){
        return ancho*profundidad;
    }

    @Override
    public String toString() {
        return "BienRaiz{" + "precio=" + precio + ", dimensionAncho=" + dimensionAncho + ", dimensionProfundidad=" + dimensionProfundidad + ", encargado=" + encargado + ", provincia=" + provincia + ", ciudad=" + ciudad + ", sector=" + sector + ", direccion=" + direccion + ", estado=" + estado + ", codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }
    
}
