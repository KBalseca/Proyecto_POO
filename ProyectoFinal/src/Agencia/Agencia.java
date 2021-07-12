/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agencia;
import java.util.Scanner;
import Usuarios.*;
import Propiedad.*;
import Herramientas.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author ricky
 */
public class Agencia {
    private ArrayList<Usuario> usuarios;
    private ArrayList<BienRaiz>listaPropiedad;
    
    public Agencia() {
        usuarios = new ArrayList<Usuario> ();
        listaPropiedad = new ArrayList<BienRaiz> ();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<BienRaiz> getListaPropiedad() {
        return listaPropiedad;
    }
    
    public boolean iniciarSesion(String nickUsuario, String contrasenia){
        Usuario u1 = new Usuario(nickUsuario, contrasenia);
        for (int i =0; i<=usuarios.size(); i++){
            if (u1.equals(usuarios.get(i))){
                return true;
            }
        }return false;
    }
  
    public void mostrarPropiedades(Usuario u1, double costoMax, double costoMin, String tipo, String ciudad, String sector) {
        if (u1 instanceof Cliente){
            Cliente cliente = (Cliente) u1;
            cliente.consultarPropiedades(listaPropiedad, costoMax, costoMin, tipo, ciudad, sector, cliente);
        }
    }
    
    public void editarListaPropiedades(Usuario usuario, ArrayList<BienRaiz> listaPropiedades, ArrayList<Usuario> listaUsuarios, BienRaiz propiedad){
        if (usuario instanceof Administrador){
            Administrador administrador = (Administrador) usuario;
            administrador.registrarPropiedad(listaPropiedades, listaUsuarios, propiedad);
        }
    }
    
    public void editarListaUsuarios(Usuario usuario, ArrayList<Usuario> listaUsuarios, String nombre, String contrasenia, String cedula, String correo, int codigo){
        if (usuario instanceof Administrador){
            Administrador administrador = (Administrador) usuario;
            administrador.agregarAgente(listaUsuarios, nombre, contrasenia, cedula, correo, codigo);
        }
    }
    
    public void revisarLIstaUsuarios(Usuario usuario, ArrayList<Usuario> listaUsuarios, LocalDate fechaInicio, LocalDate fechaFin){
        if (usuario instanceof Administrador){
            Administrador administrador = (Administrador) usuario;
            administrador.reporteContactosYVentas(listaUsuarios, fechaInicio, fechaFin);
        }
    }
    
    public void registrarUsuario(String nombre, String contrasenia, String cedula, String correo, LocalDate fechaNacimiento){
        LocalDate fechaNac = fechaNacimiento;
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        int anios = periodo.getYears();
        if (anios>=18){
            usuarios.add(new Cliente(nombre,contrasenia,cedula,correo,fechaNacimiento));
        }
    }
}

