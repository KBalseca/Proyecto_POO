/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;
import java.time.LocalDate;
import Usuarios.*;
import Propiedad.*;
/**
 *
 * @author EVELYN
 */
public class Venta {
    private Cliente comprador;
    private LocalDate fechaVenta;
    private BienRaiz propiedad;

    public Venta(Cliente comprador, LocalDate fechaVenta, BienRaiz propiedad) {
        this.comprador = comprador;
        this.fechaVenta = fechaVenta;
        this.propiedad = propiedad;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public BienRaiz getPropiedad() {
        return propiedad;
    }
    
}