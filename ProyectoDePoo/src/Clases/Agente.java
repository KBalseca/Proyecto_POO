/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ricky
 */
public class Agente {
    private int numRespuestas;
    private int numVentas;
    private int codigo;
    private Chat buzon;

    public Agente(int numVentas, int codigo) {
        this.numVentas = numVentas;
        this.codigo = codigo;
    }

    public int getNumRespuestas() {
        return numRespuestas;
    }

    public void setNumRespuestas(int numRespuestas) {
        this.numRespuestas = numRespuestas;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Chat getBuzon() {
        return buzon;
    }

    public void setBuzon(Chat buzon) {
        this.buzon = buzon;
    }

    
    
    
}
