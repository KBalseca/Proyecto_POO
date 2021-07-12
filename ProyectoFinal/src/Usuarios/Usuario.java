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
    private String contrasenia;
    private String cedula;
    private String correo;
    
 

    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
        
    public Usuario(String nombre, String contrasenia, String cedula, String correo) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contraseña) {
        this.contrasenia = contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public boolean equals(Object obj){
      Usuario user = (Usuario) obj;
      if (this.nombre.equals(user.nombre) && this.contrasenia.equals(user.contrasenia)){
          return true;
      }else{
        return false;
      }
    }
    
    
}