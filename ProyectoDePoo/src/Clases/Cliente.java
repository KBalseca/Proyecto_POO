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
 * @author Kennyn Balseca
 */
public class Cliente extends Usuario{
   
   private LocalDate fecha_nacimiento;
   private ArrayList<BienRaiz> alerta;
   private Chat buzon;
   
   //Constructor

    public Cliente(LocalDate fecha_nacimiento, ArrayList<BienRaiz> alerta, Chat buzon, String nombre, String contraseña) {
        super(nombre, contraseña);
        this.fecha_nacimiento = fecha_nacimiento;
        this.alerta = alerta;
        this.buzon = buzon;
    }
   
   
   //getters y settes respectivos
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public ArrayList<BienRaiz> getAlerta() {
        return alerta;
    }

    public void setAlerta(ArrayList<BienRaiz> alerta) {
        this.alerta = alerta;
    }

    public Chat getBuzon() {
        return buzon;
    }

    public void setBuzon(Chat buzon) {
        this.buzon = buzon;
    }
   
   //métodos del cliente
   //Crear Alerta: en base a las preferencias del cliente se le notifica si existe una Propiedad de dichas preferencias.
    
    
    //Simular Préstamo: Simula el pago de cuotas dependiendo del sistema de préstamo escogido (fraces o aleman)
    
    
    //BuzonConsultas: muestra todas las consultas que haya realizado el cliente
    
    
   
    
}
