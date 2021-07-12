/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import java.util.ArrayList;
import Usuarios.*;
import Propiedad.*;

/**
 *
 * @author ricky
 */
public class Chat {
    private Usuario cliente;
    private Usuario agente;
    private String remitente;
    private String destinatario;
    private BienRaiz propiedad;
    private int codigoPropiedad;
    private ArrayList<Mensaje> listaMsj;
    
    public Chat(int codigoPropiedad){
        this.codigoPropiedad = codigoPropiedad;
    }

    public Chat(BienRaiz propiedad, Usuario cliente) {
        this.propiedad = propiedad;
        this.cliente = cliente;
        agente = propiedad.getEncargado();
        remitente = cliente.getNombre();
        destinatario = agente.getNombre();
        codigoPropiedad = propiedad.getCodigo();
        listaMsj = new ArrayList<Mensaje> ();
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public int getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public ArrayList<Mensaje> getListaMsjs() {
        return listaMsj;
    }

    public BienRaiz getPropiedad() {
        return propiedad;
    }
    
    @Override
    public String toString(){
        return "Remitente: "+remitente+"\n"+"Destinatario: "+destinatario+"\n"+"Codigo: "+codigoPropiedad+"\n"+"Conversacion: "+listaMsj; 
    }
    
    public void agregarMsj(Mensaje msj){
        if (msj!=null){
            listaMsj.add(msj);
        }
        
    }

    public ArrayList<Mensaje> getListaMsj() {
        return listaMsj;
    }
    
    public Usuario getCliente() {
        return cliente;
    }

    public Usuario getAgente() {
        return agente;
    }
        
    @Override
    public boolean equals(Object obj){
        Chat ch = (Chat) obj;
        if (this.codigoPropiedad == ch.codigoPropiedad){
            return true;
        }else{
            return false;
        }
    }
    
}

