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
public class Vivienda extends BienRaiz{
    private int nHabitaciones;
    private int npisos;

    public Vivienda(double precio, double dimensionAncho, double dimensionProfundidad, Usuario encargado, String direccion, String provincia,  String ciudad, String sector, int codigo, String descripcion, int nHabitaciones, int nPisos) {
        super(precio, dimensionAncho, dimensionProfundidad, encargado, direccion, provincia, ciudad, sector, codigo, descripcion);
        this.nHabitaciones = nHabitaciones;
        this.npisos = nPisos;
    }

    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public int getNpisos() {
        return npisos;
    }
    
}
