/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author ricky
 */
public class Agente extends Usuario{
    private int numRespuestas;
    private int codigo;
    private ArrayList<Venta> ventas;
    private ArrayList<Chat> buzon;

    public Agente(String nombre, String contrasenia, String cedula, String correo, int codigo) {
        super(nombre, contrasenia, cedula, correo);
        this.codigo = codigo;
        numRespuestas = 0;
        ArrayList<Venta> ventas = new ArrayList();
        ArrayList<Chat> buzon = new ArrayList();
    }

    public int getNumRespuestas() {
        return numRespuestas;
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public ArrayList<Chat> getBuzon() {
        return buzon;
    }
    
    public void registrarVenta(Cliente comprador, LocalDate fechaVenta, BienRaiz propiedad){
        ventas.add(new Venta(comprador, fechaVenta, propiedad));
    }
}
