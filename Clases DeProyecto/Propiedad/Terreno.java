/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedad;

import Usuarios.*;
/**
 *
 * @author EVELYN
 */
public class Terreno extends BienRaiz{
    private String tipo;

    public Terreno(String tipo, double precio, double dimensionAncho, double dimensionProfundidad, Usuario encargado, String provincia, String direccion, String ciudad, String sector, int codigo, String descripcion) {
        super(precio, dimensionAncho, dimensionProfundidad, encargado, direccion, provincia, ciudad, sector, codigo, descripcion);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
}
