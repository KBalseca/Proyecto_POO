/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

import Agente.Agente;

/**
 *
 * @author EVELYN
 */

/* Terreno hereda los atributos de BienRaiz pues es también una propiedad
   Especificamente a un Terreno se designan sus inmediaciones para ser de tipo Comercial, Vivienda o Empresarial  

*/
public class Terreno extends BienRaiz{
    private String tipo;

    //Constructor de la clase 
    
    public Terreno(String tipo, double precio, double dimensionAncho, double dimensionProfundidad, Agente encargado, String direccion, String ciudad, String sector, int codigo, String descripcion) {
        super(precio, dimensionAncho, dimensionProfundidad, encargado, direccion, ciudad, sector, codigo, descripcion);
        this.tipo = tipo;
    }
    
    //getters de la clase
    public String getTipo() {
        return tipo;
    }
    
}
