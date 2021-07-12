/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agencia;

import Cliente.Usuario;
import java.util.ArrayList;
import Propiedades.BienRaiz;
import Agente.Agente;
import Agente.Venta;
import Cliente.Cliente;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author EVELYN
 */

/* Administrador tiene control sobre los procesos de la Agencia
   posee registros de: Propiedades en Venta y Agentes
   Tambien puede vizualizar un reporte general de los clientes y las ventas realizadas
   por los agentes
*/

public class Administrador {
    
    private ArrayList<BienRaiz> propiedad;
    private ArrayList<Agente> agentes;
    private ArrayList<Venta> ventas;
    
    public Administrador(ArrayList<BienRaiz> propiedad, ArrayList<Agente> agentes){
        this.propiedad= propiedad;
        this.agentes= agentes;
    }
    
    Scanner sc= new Scanner(System.in);
    
    //metodo registrar propiedades
    public void RegistroPropiedades(){
        //saber si la propiedad ya se encuentra registrada
        System.out.println("Desea agregar Propiedad?");
        String respuesta= sc.nextLine().toLowerCase();
        while(respuesta.equals("si")){
            
            //aqui poner alguna validacion por si la propiedad ya está registrada
            
            System.out.println("Ingrese datos de la propiedad");
            String datosPropiedad= sc.nextLine();
            String[] datosPropiedadSeparados= datosPropiedad.split(",");
            
            /*Tener en cuenta que cada Propiedad tiene los siguientes datos:
            precio,dimensionAncho,dimensionProfundidad,encargado,ciudad,sector,
            direccion,codigo,descripcion.
            Y dependiendiendo si es una vivienda cuenta demás con 
            numero de habitaciones y numero de pisos
            */
            double precio=Double.parseDouble(datosPropiedadSeparados[0]);
            double ancho=Double.parseDouble(datosPropiedadSeparados[1]);
            double profundidad=Double.parseDouble(datosPropiedadSeparados[2]);
            
            int encargado= Integer.parseInt(datosPropiedadSeparados[3]);
            Agente Encargado;
            for(Agente a:agentes){
               if(a.getCodigo()== encargado){
                   Encargado= a; 
               }
            }   
            
            
            String ciudad= datosPropiedadSeparados[4];
            String sector= datosPropiedadSeparados[5];
            String direccion= datosPropiedadSeparados[6];
            //String estado= datosPropiedadSeparados[7];
            int codigo= Integer.parseInt(datosPropiedadSeparados[7]);
            String descripcion= datosPropiedadSeparados[8];
            
            BienRaiz Propiedad= new BienRaiz(precio,ancho,profundidad,Encargado,ciudad,sector,direccion,codigo,descripcion);
            
            propiedad.add(Propiedad);
            System.out.println("Se ha registra propiedad con exito");
        }
        
        //preguntar si admin quiere visualizar el registro
        System.out.println("Desea ver nomina?");
        if(respuesta.equals("si")){
            System.out.println("BienRaiz | Precio | Encargado | Ciudad | Sector | Direccion | Codigo | Descripcion");
            for(BienRaiz p:propiedad){
                System.out.printf("Bien Raiz | %f | %s | %s | %s | %s | %d | %s ",
                p.getPrecio(),p.getEncargado(),p.getCiudad(),p.getSector(),p.getDireccion(),p.getCodigo(),p.getDescripcion());
            }
        }
    }
    
    //metodo registrar Agente
    public void RegistroAgentes(){
        
        //validacion si el agente ya existe
        
        //registro nuevo agente
        System.out.println("Agregar nuevo agente a la agencia");
        String respuesta= sc.nextLine().toLowerCase();
        while(respuesta.equals("si")){
        System.out.println("Ingrese datos del agente:");
        //del agente se conoce su nombre, cedula y correo electrónico
        String datosAgente= sc.nextLine();
        String[] datosAgenteSeparados= datosAgente.split(",");
        
        String nombreAgente= datosAgenteSeparados[0];
        String cedulaAgente= datosAgenteSeparados[1];
        String correoAgente= datosAgenteSeparados[2];
        String contraseniaAgente;
        int codigoAgente;
        for(Agente a:agentes){
            if(a.getCedula().equals(cedulaAgente)){
            contraseniaAgente = a.getContraseña();
            codigoAgente = agentes.size()+1;
            }
        }
        Agente AgenteVendedor= new Agente(nombreAgente,contraseniaAgente,cedulaAgente,correoAgente,codigoAgente);
        agentes.add(AgenteVendedor);
        }
        }
    
    
    /*  metodo Reporte General
        reporte general de los contactos de los clientes
        y ventas realizadas por agentes
        se debe poder filtrar por fecha
    */    
    public void ReporteGeneral(){
        //recordar ya tenemos un arreglo de agentes y otro de ventas dentro de agente
        //filtro
        System.out.print("Ingrese Rango Fechas: ");
        LocalDate fechaInicio= LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy") );
        LocalDate fechaFin = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy") );
        
        //desgloce de Agente    Numereo Ventas     Numero Respuestas
        for(Venta v:ventas){
            //aplicacion del filtro
            //necesito que la fecha venta este entre el rango de fechas del filtro
            if(v.getFechaVenta()){
                
            }
            
        }
        
        
        
        
    }
    
}
