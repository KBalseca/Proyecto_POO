/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoMain;

import Agencia.Agencia;
import Herramientas.*;
import SimuladorPrestamos.*;
import Usuarios.*;
import Propiedad.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author EVELYN
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc  = new Scanner(System.in);
        Agencia agencia = new Agencia();
        
        Usuario cliente1 = new Cliente("jose", "soyjose","09","romdmarc@espol.edu.ec",LocalDate.now());
        Usuario cliente2 = new Cliente("maria", "soymaria","09","romdmarc@espol.edu.ec",LocalDate.now());
        Usuario admin = new Administrador ("luis", "soyadmin","09","romdmarc@espol.edu.ec");
        Usuario agente1 = new Agente("ana", "meencantamitrabajo","09","romdmarc@espol.edu.ec",14);
        Usuario agente2 = new Agente("fernando", "meencantamitrabajo","09","romdmarc@espol.edu.ec",22);
        agencia.getUsuarios().add(cliente1);
        agencia.getUsuarios().add(cliente2);
        agencia.getUsuarios().add(admin);
        agencia.getUsuarios().add(agente1);
        
        BienRaiz vivienda1 = new Vivienda(2000,100,100,agente2,"h y la 45","Guayas", "Guayaquil","Floresta",12,".........",4,3);
        BienRaiz vivienda2 = new Vivienda(2500,100,200,agente1,"9 de octubre y esmeraldas","Guayas","Guayaquil","Suburbio",13,".........",1,2);
        BienRaiz terreno1 = new Terreno("comercial",3000,400,1000,agente1,"Guayasamin y Eloy Alfaro","Pichincha","Quito","Centro",11,".........");
        BienRaiz terreno2 = new Terreno("comercial",5000,1000,500,agente2,"Guayasamin y Eloy Alfaro","Pichincha","Quito","Centro",10,".........");
        agencia.getListaPropiedad().add(vivienda1);
        agencia.getListaPropiedad().add(vivienda2);
        agencia.getListaPropiedad().add(terreno1);
        
        agencia.mostrarPropiedades(cliente1,0,0,"","","");
        Cliente c1 = (Cliente) cliente1;
        Agente a1 = (Agente) agente1;
        Agente a2 = (Agente) agente2;
        Administrador administrador = (Administrador)admin;
        c1.buzonConsultas(c1);
        c1.crearAlerta(3000, 1500, "vivienda", "Guayaquil");
        agencia.editarListaPropiedades(administrador, agencia.getListaPropiedad(), agencia.getUsuarios(), administrador.crearPropiedad(2200, 5000, 300, agente1, "9 de octubre y Esmeralda", "Guayas", "Guayaquil", "centro", 21, "..........", 12, 4));
        
        System.out.println("\n----------------------------------------------\n");
        a1.revisarBuzon();
        
        System.out.println("\n----------------------------------------------\n");
                
        System.out.println(c1.getBuzon());
        System.out.println("\n----------------------------------------------\n");
        System.out.println(a1.getBuzon());
        System.out.println("\n----------------------------------------------\n");
        System.out.println(a2.getBuzon());
	System.out.println("");
                
    }
    
}
