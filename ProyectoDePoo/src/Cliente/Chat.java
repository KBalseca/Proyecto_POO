/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.ArrayList;

/**
 *
 * @author ricky
 */
public class Chat {
    private String remitente;
    private String destinatario;
    private int codigoPropiedad;
    private ArrayList<Mensaje>listaMsjs;

    public Chat(String remitente, String destinatario, int codigoPropiedad) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.codigoPropiedad = codigoPropiedad;
        ArrayList<Mensaje> listaMsj = new ArrayList();
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
        return listaMsjs;
    }
    
}


