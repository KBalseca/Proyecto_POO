/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;


import Propiedades.BienRaiz;
import Estimacion_Prestamos.CalculadoraPrestamo;
import Propiedades.Terreno;
import Propiedades.Vivienda;
import Estimacion_Prestamos.pAleman;
import Estimacion_Prestamos.pFrances;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EVELYN
 */
public class Cliente extends Usuario{
    private LocalDate feachaNacimiento;
    private ArrayList<Alerta> alertas;
    private ArrayList<Chat> buzon;

    public Cliente(String nombre, String contrasenia, String cedula, String correo, LocalDate feachaNacimiento) {
        super(nombre, contrasenia, cedula, correo);
        this.feachaNacimiento = feachaNacimiento;
        ArrayList<Chat> buzon = new ArrayList();
        ArrayList<Alerta> alertas = new ArrayList();
    }
    
    public void crearAlerta(double precio,String tipo,String ubicacion){
        alertas.add(new Alerta(precio, tipo, ubicacion));
    }
    
    public void simularPrestamo(double monto, double interes, int periodo, String tipo){
        if("aleman".equals(tipo)){
            CalculadoraPrestamo pa1 = new pAleman(monto, interes, periodo);
            pa1.calcularPrestamo();
        }else if("frances".equals(tipo)){
            CalculadoraPrestamo pf1 = new pFrances(monto, interes, periodo);
            pf1.calcularPrestamo();
        }
        
    }
    
    public void realizarConsulta(int codigo, String nombreCliente, String nombreAgente, String contenido, String tipo, LocalDate fechaDeEnvio){
        boolean existe = false;
        for (int i = 0; i<=buzon.size(); i++){
            if (buzon.get(i).getCodigoPropiedad() == codigo){
                Mensaje m1 = new Mensaje(contenido, tipo, fechaDeEnvio);
                existe = true;
                buzon.get(i).getListaMsjs().add(m1);
            }
        }
        if (existe==false){
            Chat c1 = new Chat(nombreCliente, nombreAgente, codigo);
            Mensaje m1 = new Mensaje(contenido, tipo, fechaDeEnvio);
            c1.getListaMsjs().add(m1);
            buzon.add(c1);   
        }
    }
    
    public boolean valorVerdad(String getDeObjeto, String parametro){
       if(parametro==""){
           return true;
       }else if(parametro==getDeObjeto){
           return true;
       }else{
           return false;
       }
    }
    
    public boolean valorVerdad(double getDeObjeto,double parametroMin,double parametroMax){
        boolean valor = false;
        if(parametroMin==0 && parametroMax==0){
           valor = true;
       }else if(parametroMin==0){
           if (getDeObjeto<=parametroMax){
            valor = true;   
           } 
       }else if(parametroMax==0){
           if (parametroMin<=getDeObjeto){
            valor = true;   
           }
       }else if(parametroMax!=0 && parametroMin!=0){
           if (parametroMin<=getDeObjeto && getDeObjeto<=parametroMax){
            valor = true;   
           }
       }return valor;
    }
    
    public BienRaiz tipoBienRaiz(BienRaiz b1, String parametro){
        if(parametro=="terreno"){
           Terreno t1 = (Terreno) b1;
           return t1;
       }else if(parametro=="vivienda"){
           Vivienda v1 = (Vivienda) b1;
           return v1;
       }else {
            return b1;
       }
    }
        
    public void consultarPropiedades(ArrayList<BienRaiz> lista, double costoMax, double costoMin, String tipo, String ciudad, String sector){
        System.out.println("Tipo: "+tipo);
        System.out.println("Rango de precio: "+costoMin+"-"+costoMax);
        System.out.println("Ciudad: "+ciudad);
        System.out.println("Sector: "+sector);
        for (int i = 0; i<=lista.size(); i++){
            if (!lista.get(i).getEstado()){
                BienRaiz bienr = tipoBienRaiz(lista.get(i),tipo);
                if ( (valorVerdad(bienr.getPrecio(),costoMin,costoMax)) && (valorVerdad(bienr.getSector(),sector)) && (valorVerdad(bienr.getCiudad(),ciudad))){
                    String consulta = "No";
                    System.out.println("Codigio: "+bienr.getCodigo());
                    System.out.println("Descripcion: "+bienr.getDescripcion());
                    System.out.println("Precio: "+bienr.getPrecio());
                    System.out.println("Tamaño: "+bienr.calcularArea(bienr.getDimensionAncho(), bienr.getDimensionProfundidad())+"m2");
                    System.out.println("Ubicacion: "+bienr.getCiudad()+" "+bienr.getSector()+" "+bienr.getDireccion());
                    for (int x = 0; x<=buzon.size(); x++){
                        if (buzon.get(x).getCodigoPropiedad() == bienr.getCodigo()){
                            consulta = "si";
                        }
                    }
                    System.out.println("Consultada: "+consulta);
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese código de propiedad (o vacío para regresar): ");
        String valor = sc.nextLine();
        if (valor.isEmpty()){
            System.exit(0);
        }else{
            int codigoComprobar = Integer.valueOf(valor);
            for (BienRaiz propiedad:lista){
                 if(propiedad.getCodigo()==codigoComprobar){
                    System.out.println(propiedad);
                    System.out.println("Desea hacer una consulta (si/no): ");
                    String condicion = sc.nextLine();
                    /*if (condicion == "si"){
                        System.out.println("Ingrese su consulta: ");
                        String consulta = sc.nextLine();
                        realizarConsulta(propiedad.getCodigo(),getNombre(),propiedad.getEncargado().getNombre(),consulta,"pregunta",LocalDate.now());
                    }else{
                        System.exit(0);
                    }*/
                 }
            }
        }
    }
    
    public void buzonConsultas(){
        for (Chat chat:buzon){
            System.out.println("Fecha de Inicio: "+chat.getListaMsjs().get(0).getFechaDeEnvio());
            System.out.println("Codigo de propiedad: "+chat.getCodigoPropiedad());
            System.out.println("Nombre Agente: "+chat.getCodigoPropiedad());
                if (chat.getListaMsjs().get(chat.getListaMsjs().size()-1).getTipo()=="respuesta"){
                    System.out.println("Pregunta: "+chat.getListaMsjs().get(chat.getListaMsjs().size()-2));
                    System.out.println("Estado: Respondido");
            }else{
                    System.out.println("Pregunta: "+chat.getListaMsjs().get(chat.getListaMsjs().size()-1));
                    System.out.println("Estado: Esperando");
                }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese código de propiedad (si/no): ");
        int valor = sc.nextInt();
        for (Chat chat:buzon){
            if (chat.getCodigoPropiedad()==valor){
                System.out.println(chat);
            }
        }
    }
    
}
