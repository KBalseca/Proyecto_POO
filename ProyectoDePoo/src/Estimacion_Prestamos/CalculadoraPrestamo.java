/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estimacion_Prestamos;

/**
 *
 * @author EVELYN
 */

/* Clase abstracta que provee al cliente una simulación del costeo de una propiedad
   basado en el sistema de amortización de su preferencia (Alemán o Frances)
*/
public abstract class CalculadoraPrestamo {
    private double monto;
    private double interes;
    private int periodo;

    public CalculadoraPrestamo(double monto, double interes, int periodo) {
        this.monto = monto;
        this.interes = interes;
        this.periodo = periodo;
    }

    
    //getters y setters de la clase 
    public double getMonto() {
        return monto;
    }

    public double getInteres() {
        return interes;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    
    //metodo abstracto pues necesitamos el sistema de amortización elegido por el Cliente
    //para realizar los cálculos respectivos.
    public abstract void calcularPrestamo();
    
}
