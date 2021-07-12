/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

/**
 *
 * @author EVELYN
 */
public class Alerta {
    private double precioMax;
    private double precioMin;
    private String tipo;
    private String ubicacion;

    public Alerta(double precioMax, double precioMin, String tipo, String ubicacion) {
        this.precioMax = precioMax;
        this.precioMin = precioMin;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public double getPrecioMax() {
        return precioMax;
    }
    
    public double getPrecioMin() {
        return precioMin;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
}
