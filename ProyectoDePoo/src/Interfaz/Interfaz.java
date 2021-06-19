/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.util.Scanner;
import Usuarios.Usuario;
import java.util.ArrayList;
/**
 *
 * @author ricky
 */
public class Interfaz {
    Scanner sc = new Scanner(System.in);
    /*private String nombre;
    private String contraseña;*/
    private ArrayList<Usuario> usuarios;

    public Interfaz() {
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
    
    /*public void menuInicial(){
        System.out.println("Bienvenido a la compañia");
        System.out.print("Usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();
        Usuario user1 = new Usuario(nombre,contraseña);
        while(user1.getNombre()==null){
        
        }
    }*/
    
  
}
