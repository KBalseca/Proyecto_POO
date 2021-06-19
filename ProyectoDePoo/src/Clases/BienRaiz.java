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
    private String[] ubicacion;
    private boolean estado;
    private int codigo;
    private String descripcion;

    public BienRaiz(double precio, double dimensionAncho, double dimensionProfundidad, Agente encargado, String[] ubicacion, boolean estado, int codigo, String descripcion) {
        this.precio = precio;
        this.dimensionAncho = dimensionAncho;
        this.dimensionProfundidad = dimensionProfundidad;
        this.encargado = encargado;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
}
