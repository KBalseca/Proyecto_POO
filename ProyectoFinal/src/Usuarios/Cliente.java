/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author EVELYN
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Herramientas.*;
import Propiedad.*;
import SimuladorPrestamos.*;

/**
 *
 * @author EVELYN
 */
public class Cliente extends Usuario {

    private LocalDate feachaNacimiento;
    private ArrayList<Alerta> alertas;
    private ArrayList<Chat> buzon;

    public Cliente(String nombre, String contrasenia, String cedula, String correo, LocalDate feachaNacimiento) {
        super(nombre, contrasenia, cedula, correo);
        this.feachaNacimiento = feachaNacimiento;
        buzon = new ArrayList<Chat>();
        alertas = new ArrayList<Alerta>();
    }

    public LocalDate getFeachaNacimiento() {
        return feachaNacimiento;
    }

    public ArrayList<Alerta> getAlertas() {
        return alertas;
    }

    public ArrayList<Chat> getBuzon() {
        return buzon;
    }
    
    

    public void crearAlerta(double precioMax, double precioMin, String tipo, String ubicacion) {
        alertas.add(new Alerta(precioMax, precioMin, tipo, ubicacion));
    }

    public void simularPrestamo(double monto, double interes, int periodo, String tipo) {
        if ("aleman".equals(tipo)) {
            CalculadoraPrestamo pa1 = new pAleman(monto, interes, periodo);
            pa1.calcularPrestamo();
        } else if ("frances".equals(tipo)) {
            CalculadoraPrestamo pf1 = new pFrances(monto, interes, periodo);
            pf1.calcularPrestamo();
        }

    }

    public void realizarConsulta(BienRaiz propiedad, Usuario remitente, String contenido, String tipo, LocalDate fechaDeEnvio) {
        Agente destinatario1 = (Agente) propiedad.getEncargado();
        Chat chatPrueba = new Chat(propiedad.getCodigo());
        Mensaje msj = new Mensaje(contenido, tipo, LocalDate.now());
        if (buzon.contains(chatPrueba)) {
            int indice = buzon.indexOf(chatPrueba);
            buzon.get(indice).agregarMsj(msj);
            Chat ch = buzon.get(indice);
            if (destinatario1.getBuzon().contains(chatPrueba)) {
                destinatario1.getBuzon().remove(chatPrueba);
                destinatario1.getBuzon().add(ch);
            } else {
                destinatario1.getBuzon().add(ch);
            }
        } else {
            Chat nuevoChat = new Chat(propiedad,remitente);
            nuevoChat.agregarMsj(msj);
            buzon.add(nuevoChat);
            destinatario1.getBuzon().add(nuevoChat);
        }
    }

    public boolean valorVerdad(String getDeObjeto, String parametro) {
        if (parametro == "") {
            return true;
        } else if (parametro == getDeObjeto) {
            return true;
        } else {
            return false;
        }
    }

    public boolean valorVerdad(double getDeObjeto, double parametroMin, double parametroMax) {
        boolean valor = false;
        if (parametroMin == 0 && parametroMax == 0) {
            valor = true;
        } else if (parametroMin == 0) {
            if (getDeObjeto <= parametroMax) {
                valor = true;
            }
        } else if (parametroMax == 0) {
            if (parametroMin <= getDeObjeto) {
                valor = true;
            }
        } else if (parametroMax != 0 && parametroMin != 0) {
            if (parametroMin <= getDeObjeto && getDeObjeto <= parametroMax) {
                valor = true;
            }
        }
        return valor;
    }

    public BienRaiz tipoBienRaiz(BienRaiz b1, String parametro) {
        if (parametro.equals("terreno") && b1 instanceof Terreno) {
            Terreno t1 = (Terreno) b1;
            return t1;
        } else if (parametro.equals("vivienda") && b1 instanceof Vivienda) {
            Vivienda v1 = (Vivienda) b1;
            return v1;
        } else if (parametro.equals("")){
            return b1;
        }else{
            return null;
        }
    }

    public void consultarPropiedades(ArrayList<BienRaiz> lista, double costoMax, double costoMin, String tipo, String ciudad, String sector, Cliente c1) {
        System.out.println("Tipo: " + tipo);
        System.out.println("Rango de precio: " + costoMin + "-" + costoMax);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Sector: " + sector);
        for (BienRaiz propiedad:lista) {
            if (!propiedad.getEstado()) {
                if (tipoBienRaiz(propiedad, tipo)!=null){
                    BienRaiz bienr = tipoBienRaiz(propiedad, tipo);
                    if ((valorVerdad(bienr.getPrecio(), costoMin, costoMax)) && (valorVerdad(bienr.getSector(), sector)) && (valorVerdad(bienr.getCiudad(), ciudad))) {
                        String consulta = "no";
                        System.out.println("Codigio: " + bienr.getCodigo());
                        System.out.println("Descripcion: " + bienr.getDescripcion());
                        System.out.println("Precio: " + bienr.getPrecio());
                        System.out.println("Tamaño: " + bienr.calcularArea(bienr.getDimensionAncho(), bienr.getDimensionProfundidad()) + "m2");
                        System.out.println("Ubicacion: " + bienr.getCiudad() + " " + bienr.getSector() + " " + bienr.getDireccion());
                        for (Chat chat : buzon) {
                            if (chat.getCodigoPropiedad() == bienr.getCodigo()) {
                                consulta = "si";
                            } else {
                                consulta = "no";
                            }
                        }
                        System.out.println("Consultada: " + consulta);
                    }
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese código de propiedad (o vacío para regresar): ");
        String valor = sc.nextLine();
        if (valor.isEmpty()) {
            System.exit(0);
        } else {
            int codigoComprobar = Integer.valueOf(valor);
            for (BienRaiz propiedad1 : lista) {
                if (propiedad1.getCodigo() == codigoComprobar) {
                    System.out.println(propiedad1);
                    System.out.println("Desea hacer una consulta (si/no): ");
                    String condicion = sc.nextLine();
                    if (condicion.equals("si")) {
                        System.out.println("Ingrese su consulta: ");
                        String consulta = sc.nextLine();
                        realizarConsulta(propiedad1, c1, consulta, "pregunta", LocalDate.now());
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }

    public void buzonConsultas(Cliente c1) {
        for (Chat chat : buzon) {
            System.out.println("Fecha de Inicio: " + chat.getListaMsjs().get(0).getFechaDeEnvio());
            System.out.println("Codigo de propiedad: " + chat.getCodigoPropiedad());
            System.out.println("Nombre Agente: " + chat.getCodigoPropiedad());
            if (chat.getListaMsjs().get(chat.getListaMsjs().size() - 1).getTipo() == "respuesta") {
                System.out.println(chat.getListaMsjs().get(chat.getListaMsjs().size() - 2));
                System.out.println("Estado: Respondido");
            } else {
                System.out.println("Pregunta: " + chat.getListaMsjs().get(chat.getListaMsjs().size() - 1));
                System.out.println("Estado: Esperando");
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese código de propiedad: ");
        int valor = sc.nextInt();
        Chat ch = new Chat(valor);
        for (Chat chat : buzon) {
            if (chat.equals(ch)) {
                System.out.println(chat);
                sc.nextLine();
                System.out.println("Desea hacer una consulta (si/no):");
                String continuar = sc.nextLine();
                if (continuar.equals("si")){
                   System.out.println("Ingrese su consulta: ");
                   String consulta = sc.nextLine();
                   realizarConsulta(chat.getPropiedad(), c1, consulta, "pregunta", LocalDate.now());
                }else{
                    System.exit(0);
                }
            }
        }

    }
}
