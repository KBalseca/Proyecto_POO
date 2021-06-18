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
public class Menu {
    Scanner sc = new Scanner(System.in);
    private String nombre;
    private String contraseña;
    private ArrayList<Usuario>Usuarios;
    public void menuInicial(){
        System.out.println("Bienvenido a la compañia");
        System.out.print("Usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();
        Usuario user1 = new Usuario(nombre,contraseña);
        while(user1.getNombre()==null){
        
        }
    }
    
  
}
