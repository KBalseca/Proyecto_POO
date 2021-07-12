/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agente;

import Propiedades.BienRaiz;
import Cliente.Usuario;
import Cliente.Chat;
import Cliente.Cliente;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author ricky
 */

/*  Agente desiganado por la Agencia para orientar clientes y 
    cerrar ventas, posee un registro de las propiedades a su cargo
    y de los clientes atendidos.
*/
public class Agente extends Usuario{
    private int numRespuestas;
    private int codigo;
    private ArrayList<Venta> ventas;
    private ArrayList<Chat> buzon;

    //constructor del Agente
    
    public Agente(String nombre, String contrasenia, String cedula, String correo, int codigo) {
        super(nombre, contrasenia, cedula, correo);
        this.codigo = codigo;
        numRespuestas = 0;
        ArrayList<Venta> ventas = new ArrayList();
        ArrayList<Chat> buzon = new ArrayList();
    }

    //getters
    
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    /*  metodo que registra las ventas realizadas por el agente
        recibe como parametro un Cliente que compra la propiedad,
        fecha realizada la venta,
        Propiedad vendida.
    */
    public void registrarVenta(Cliente comprador, LocalDate fechaVenta, BienRaiz propiedad){
        ventas.add(new Venta(comprador, fechaVenta, propiedad));
    }
}
