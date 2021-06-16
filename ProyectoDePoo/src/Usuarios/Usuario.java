/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author ricky
 */
public class Usuario {
    private String nombre;
    private String contraseña;
    private String cedula;
    private String correo;

    public Usuario(String nombre, String contraseña, String cedula, String correo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.cedula = cedula;
        this.correo = correo;
    }

    
}

