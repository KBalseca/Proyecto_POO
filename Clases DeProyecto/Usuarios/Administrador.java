/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import EnviarCorreo.Correo;
import java.util.ArrayList;
import Propiedad.*;
import Herramientas.*;
import java.time.LocalDate;
import java.util.Scanner;


/**
 *
 * @author EVELYN
 */
public class Administrador extends Usuario{
    
    public Administrador(String nombre, String contraseña, String cedula, String correo) {
        super(nombre, contraseña, cedula, correo);
    }
    
    public Vivienda crearPropiedad(double precio, double dimensionAncho, double dimensionProfundidad, Usuario encargado, String direccion, String provincia,  String ciudad, String sector, int codigo, String descripcion, int nHabitaciones, int nPisos){
        Vivienda vivienda = new Vivienda(precio, dimensionAncho, dimensionProfundidad, encargado, direccion, provincia, ciudad, sector, codigo, descripcion,nHabitaciones, nPisos);
        return vivienda;
    }
    
     public Terreno crearPropiedad(String tipo, double precio, double dimensionAncho, double dimensionProfundidad, Usuario encargado, String provincia, String direccion, String ciudad, String sector, int codigo, String descripcion){
        Terreno terreno = new Terreno(tipo, precio, dimensionAncho, dimensionProfundidad, encargado, direccion, provincia, ciudad, sector, codigo, descripcion);
        return terreno;
    }
     
    public boolean filtroFechas(LocalDate inicio, LocalDate fin, LocalDate buscar){
        return buscar.isAfter(inicio) && buscar.isBefore(fin);
    }
    
    public void activarAlertas(ArrayList<Usuario> listaUsuarios, BienRaiz propiedad){
        for (Usuario usuario:listaUsuarios){
            if (usuario instanceof Cliente){
                Cliente c1 = (Cliente)usuario;
                for(Alerta alerta:c1.getAlertas()){
                    if (alerta.getTipo().equals("vivienda") && propiedad instanceof Vivienda && c1.valorVerdad(propiedad.getPrecio(), alerta.getPrecioMin(), alerta.getPrecioMax()) && c1.valorVerdad(propiedad.getCiudad(), alerta.getUbicacion())){
                       Vivienda v1 = (Vivienda) propiedad;
                       String destinatario = c1.getCorreo();
                       String texto = v1.toString();
                       Correo.enviarConGMail(destinatario, "Se ha agregado una propiedad que coinicde con una de sus preferencias", texto);
                    }else if (alerta.getTipo().equals("terreno") && propiedad instanceof Terreno && c1.valorVerdad(propiedad.getPrecio(), alerta.getPrecioMin(), alerta.getPrecioMax()) && c1.valorVerdad(propiedad.getCiudad(), alerta.getUbicacion())){
                       Terreno t1 = (Terreno) propiedad;
                       String destinatario = c1.getCorreo();
                       String texto = t1.toString();
                       Correo.enviarConGMail(destinatario, "Se ha agregado una propiedad que coinicde con una de sus preferencias", texto);
                    }
                }
            }
        }
    }    
     
    public void registrarPropiedad(ArrayList<BienRaiz> listaPropiedades, ArrayList<Usuario> listaUsuarios, BienRaiz propiedad){
        if (!listaPropiedades.contains(propiedad)){
            listaPropiedades.add(propiedad);
            activarAlertas(listaUsuarios,propiedad);
        }
    }
    
    public void reporteContactosYVentas(ArrayList<Usuario> listaUsuarios, LocalDate fechaInicio, LocalDate fechaFin){
        System.out.printf("%s %20s\n","Rango de fechas: ", fechaInicio+"-"+fechaFin);
        System.out.printf("%s %20s %30s\n","Agente","Numero de ventas","Numero de Respuestas");
        for (Usuario usuario:listaUsuarios){
            if(usuario instanceof Agente){
                Agente a1 = (Agente) usuario;
                int numVentas = 0;
                int numRespuestas = 0;
                for (Venta venta: a1.getVentas()){
                    if (filtroFechas(fechaInicio,fechaFin,venta.getFechaVenta())){
                            numVentas+=1;
                        }
                }
                for(Chat chat:a1.getBuzon()){
                    for (Mensaje msj:chat.getListaMsjs()){
                        if (msj.getTipo().equals("Respuesta") && filtroFechas(fechaInicio,fechaFin,msj.getFechaDeEnvio())){
                            numRespuestas+=1;
                        }
                    }
                }
                System.out.printf("%6d %20d %30d\n",a1.getCodigo(),numVentas,numRespuestas);
                numVentas = 0;
                numRespuestas = 0;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese codigo del agente para la informacion amayor detalle o vacio para regresar: ");
        String indice = sc.nextLine();
        if (!indice.isEmpty()) {
            int codigo = Integer.valueOf(indice);
            System.out.println("Ventas:");
            Agente agente = (Agente) listaUsuarios.get(codigo);
            for (Venta venta: agente.getVentas()){
                    if (filtroFechas(fechaInicio,fechaFin,venta.getFechaVenta())){
                        System.out.println(venta);
                    }
                }
            System.out.println("Consultas:");
            for(Chat chat:agente.getBuzon()){
                    for (Mensaje msj:chat.getListaMsjs()){
                        if (filtroFechas(fechaInicio,fechaFin,msj.getFechaDeEnvio())){
                            System.out.println(msj);
                        }
                    }
                }
        } else {
            System.exit(0);
        }
    }
    public void agregarAgente(ArrayList<Usuario> listaUsuarios, String nombre, String contrasenia, String cedula, String correo, int codigo){
        Agente agente = new Agente(nombre, contrasenia, cedula, correo, codigo);
        if (!listaUsuarios.contains(agente)){
            listaUsuarios.add(agente);
        }
    }
    
}
