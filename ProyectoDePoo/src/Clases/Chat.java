/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author ricky
 */
public class Chat {
    private String remitente;
    private String destinatario;
    private ArrayList<Mensaje>listaMsjs;

    public Chat(String remitente, String destinatario, ArrayList<Mensaje> listaMsjs) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.listaMsjs = listaMsjs;
    }
    
}


