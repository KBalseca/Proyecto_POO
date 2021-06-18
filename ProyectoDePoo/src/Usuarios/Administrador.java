/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;

/**
 *
 * @author EVELYN
 */
public class Administrador extends Usuario{
    private ArrayList<Usuario>Usuarios;
    public Administrador(String nombre, String contraseña, String cedula, String correo) {
        super(nombre, contraseña);
    }
    public boolean verificarUsuario(String nombre){
        for(Usuario u:Usuarios){
            if(u.getNombre().equals(nombre))
                return true;
        }
        return false;
    }
}

