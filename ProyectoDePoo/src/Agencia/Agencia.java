/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agencia;
import java.util.Scanner;
import Clases.Usuario;
import java.util.ArrayList;
import Clases.Chat;
import Clases.Mensaje;
import java.time.LocalDate;
import Clases.BienRaiz;
/**
 *
 * @author ricky
 */
public class Agencia {
    Scanner sc = new Scanner(System.in);
    /*private String nombre;
    private String contraseña;*/
    private ArrayList<Usuario> usuarios;
    private ArrayList<BienRaiz>listaPropiedad;
    private ArrayList<Chat>Chat;
    public Agencia() {
        ArrayList<Usuario> usuarios = new ArrayList<> ();
    }
    
    public boolean iniciarSesion(String nickUsuario, String contrasenia){
        Usuario u1 = new Usuario(nickUsuario, contrasenia);
        for (int i =0; i<=usuarios.size(); i++){
            if (u1.equals(usuarios.get(i))){
                return true;
            }
        }return false;
    }
    public void menuRegistro(){
    String a="";
        do {            
            System.out.println("\n\t---Bienvenido a bienes y raices");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            switch(a){
                case"1":
                    
            }
        } while (true);
    
    }
    
    private void opcion1(){
    
    
    }
       
    private void opcion2(){
    
    }
  
}
