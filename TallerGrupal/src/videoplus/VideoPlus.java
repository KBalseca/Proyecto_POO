/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoplus;

import java.util.ArrayList;

/**
 *
 * @author rocio
 */
public class VideoPlus {
    
    public static void main(String[] args){
        /*ArrayList<Video> videos = new ArrayList<Video>();
        videos.add(new Video("Cruela"));
        videos.add(new Video("Lazo While"));
        videos.add(new Video("El rey Leon"));
        videos.add(new Video("Chapie"));
        videos.add(new Video("Blanca Nieves"));
        videos.add(new Video("Buscando a neno"));
        
        Cliente c = new Cliente("jose");
        //agregue cinco peluclas a la lista de reproduccion
        
        //reproduzca las peliculas*/
    }
    
public class Video {
    private String nombre;
    private  int numeroReproducciones;
    
    public Video(String nombre, int numeroReproducciones) {
        this.nombre = nombre;
        this.numeroReproducciones = numeroReproducciones;
        
    }
    public Video(String nombre) {
        this (nombre,0);
    }
    public void mostrarInfomacion() {
        System.out.println("nombres="+nombre+", "
                +"numeroReproducciones="+numeroReproducciones+"}");
    }
    public boolean equals(Object obj) {
        Video other = (Video) obj;
        if (this.nombre.equals(other.nombre) &&
                this.numeroReproducciones == other.numeroReproducciones) {
            return true;
        }
        return false;
    }
}
}
