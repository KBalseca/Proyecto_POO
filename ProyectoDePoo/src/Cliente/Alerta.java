/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author EVELYN
 */
public class Alerta {
    private double precio;
    private String tipo;
    private String ubicacion;

    public Alerta(double precio, String tipo, String ubicacion) {
        this.precio = precio;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    
}
