/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

import Agente.Agente;

/**
 *
 * @author EVELYN
 */

/*  Un Terreno con valor de tipo fijado en Vivienda
    se necesita saber número de pisos y de habitaciones
*/
public class Vivienda extends BienRaiz{
    private int nHabitaciones;
    private int npisos;

    //constructor de la clase
    public Vivienda(double precio, double dimensionAncho, double dimensionProfundidad, Agente encargado,
                   String direccion,  String ciudad, String sector, int codigo, String descripcion,
                   int nHabitaciones, int npisos) {
        
        super(precio, dimensionAncho, dimensionProfundidad, encargado, direccion, ciudad, sector, codigo, descripcion);
        this.nHabitaciones = nHabitaciones;
        this.npisos = npisos;
    }

    //getters de la clase
    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public int getNpisos() {
        return npisos;
    }
    
}
