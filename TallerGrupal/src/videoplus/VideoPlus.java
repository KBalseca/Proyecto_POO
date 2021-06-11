/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoplus;

import java.util.ArrayList;
import java.util.Scanner;

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

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getNumeroReproducciones() {
            return numeroReproducciones;
        }

        public void setNumeroReproducciones(int numeroReproducciones) {
            this.numeroReproducciones = numeroReproducciones;
        }
    
    public Video(String nombre) {
        this (nombre,0 );
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
    public class Cliente {
        private ArrayList<Video> ListaReproduccion;
        private String nombre;
        
        /**
         * Constructor que fija el nombre del cliente e inicializa ListaReproduccion
         *  @param nombre
         */      
        public Cliente(String nombre){
            this.nombre= nombre;
            //inicializamos el objeto lista
            ListaReproduccion = new ArrayList<>();
        }

        public ArrayList<Video> getListaReproduccion() {
            return ListaReproduccion;
        }

        public void setListaReproduccion(ArrayList<Video> ListaReproduccion) {
            this.ListaReproduccion = ListaReproduccion;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        /**
         * Agrega un video al final de la lista de reproduccion. El cliente no puede tener
         * más de 5 videos en la lista. Retorna verdadero sis e pudo agregar el video
         * @param p
         */
         public boolean agregarLista(Video v){
             //metodo size retorn el numero de elementos en el arreglo
             if (ListaReproduccion.size()<5){
                 //el metodo add agrega un objeto al final de la salida
                 ListaReproduccion.add(v);
                 return true;
                 }
             return false;
         }
    }
    
    public void reproducirVideo(Cliente c1) {
        String continuar = "no";
        Scanner sc = new Scanner(System.in);
        do{
           for (Video element:c1.ListaReproduccion) {
               System.out.println(element.getNombre());
               System.out.println("¿Desea continuar?: ");
               continuar = sc.nextLine();
               if (continuar=="si") {
                   element.numeroReproducciones+=1;
                   
               }
           }
        }while(continuar.equalsIgnoreCase("si"));
    }
}
