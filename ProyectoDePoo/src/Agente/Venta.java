/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agente;
import Propiedades.BienRaiz;
import Cliente.Cliente;
import java.time.LocalDate;
/**
 *
 * @author EVELYN
 */

/* Clase Venta registra los datos del Cliente Comprador, la Fecha de realizada la venta
   y la Propiedad vendida
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

    //getters de la clase
    
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
