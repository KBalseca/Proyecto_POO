/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agencia;
import java.util.Scanner;
import Clases.*;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author ricky
 */
public class Agencia {
    private ArrayList<Usuario> usuarios;
    private ArrayList<BienRaiz>listaPropiedad;
    private ArrayList<Chat> Chat;
    
    public Agencia() {
        ArrayList<Usuario> usuarios = new ArrayList<> ();
        ArrayList<BienRaiz> listaPropiedad = new ArrayList<> ();
        ArrayList<Chat> Chat = new ArrayList<> ();
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
            Cliente c1 = (Cliente) u1;
            c1.consultarPropiedades(listaPropiedad, costoMax, costoMin, tipo, ciudad, sector);
        }
    }
}
