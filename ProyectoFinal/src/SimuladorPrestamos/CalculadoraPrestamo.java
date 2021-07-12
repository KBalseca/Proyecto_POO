/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorPrestamos;

/**
 *
 * @author EVELYN
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
    
    
    
    public abstract void calcularPrestamo();
    
}
