/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author ricky
 */
public class Mensaje {
    private String contenido;
    private String tipo;
    private LocalDate fechaDeEnvio;

    public Mensaje(String contenido, String tipo, LocalDate fechaDeEnvio) {
        this.contenido = contenido;
        this.tipo = tipo;
        this.fechaDeEnvio = fechaDeEnvio;
    }

    public String getContenido() {
        return contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getFechaDeEnvio() {
        return fechaDeEnvio;
    }
    
}
