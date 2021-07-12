/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import Herramientas.*;
import Propiedad.*;

/**
 *
 * @author ricky
 */
public class Agente extends Usuario{
    private int codigo;
    private ArrayList<Venta> ventas;
    private ArrayList<Chat> buzon;

    public Agente(String nombre, String contrasenia, String cedula, String correo, int codigo) {
        super(nombre, contrasenia, cedula, correo);
        this.codigo = codigo;
        ventas = new ArrayList<Venta>();
        buzon = new ArrayList<Chat>();
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
    
    public void responderConsulta(BienRaiz propiedad, Usuario destinatario, String contenido, String tipo, LocalDate fechaDeEnvio) {
        Cliente destinatario1 = (Cliente) destinatario;
        Chat chatPrueba = new Chat(propiedad.getCodigo());
        Mensaje msj = new Mensaje(contenido, tipo, LocalDate.now());
        if (buzon.contains(chatPrueba)) {
            int indice = buzon.indexOf(chatPrueba);
            buzon.get(indice).agregarMsj(msj);
            Chat ch = buzon.get(indice);
            destinatario1.getBuzon().remove(chatPrueba);
            destinatario1.getBuzon().add(ch);            
        }
    }
    
    public void revisarBuzon(){
        for (Chat chat : buzon) {
            System.out.println("Fecha de Inicio: " + chat.getListaMsjs().get(0).getFechaDeEnvio());
            System.out.println("Codigo de propiedad: " + chat.getCodigoPropiedad());
            System.out.println("Nombre Cliente: " + chat.getCliente().getNombre());
            for (Mensaje msj:chat.getListaMsj()){
                if (msj.getTipo().equals("pregunta")){
                    System.out.println(msj);
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese código de propiedad: ");
        int valor = sc.nextInt();
        Chat ch = new Chat(valor);
        for (Chat chat : buzon) {
            if (chat.equals(ch)) {
                System.out.println(chat);
                sc.nextLine();
                System.out.println("Desea responder (si/no):");
                String continuar = sc.nextLine();
                if (continuar.equals("si")){
                   System.out.println("Ingrese su consulta: ");
                   String consulta = sc.nextLine();
                   responderConsulta(chat.getPropiedad(), chat.getCliente(), consulta, "respuesta", LocalDate.now());
                }else{
                    System.exit(0);
                }
            }
        }
    }
    
    @Override
    public boolean equals(Object obj){
        Agente a1 = (Agente) obj;
        if (this.codigo == a1.codigo){
            return true;
        }else{
            return false;
        }
    }  
}
