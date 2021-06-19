/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.time.LocalDate;
import java.util.Locale;
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
    private int codigoPropiedad;

    public Mensaje(String contenido, String tipo, LocalDate fechaDeEnvio, int codigoPropiedad) {
        this.contenido = contenido;
        this.tipo = tipo;
        this.fechaDeEnvio = fechaDeEnvio;
        this.codigoPropiedad = codigoPropiedad;
    }
    
}
