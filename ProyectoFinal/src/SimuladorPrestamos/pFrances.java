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
public class pFrances extends CalculadoraPrestamo{
    
    public pFrances(double monto,double interes,int periodo) {
        super(monto, interes, periodo);
    }
    
    @Override
    public void calcularPrestamo() {
        double cuota = 0;
        double interesPorPeriodo = 0;
        double capitalAmortizado = 0;
        double capitalPendiente = getMonto();
        int exponente = getPeriodo();
        
        System.out.printf("|%8s|%10s|%8s|%18s|%18s|\n","Periodo","Cuota","Interes","Capital Amortizado","Capital Pendiente");
        
        for( int i = 1; i<=getPeriodo(); i++){
            
            cuota = (capitalPendiente*getInteres())/(1-(Math.pow((1+getInteres()),-exponente)));
            interesPorPeriodo = capitalPendiente*getInteres();
            capitalAmortizado = cuota-interesPorPeriodo;
            capitalPendiente = capitalPendiente-capitalAmortizado;
            
            System.out.printf("|%8d|%10.2f|%8.2f|%18.2f|%18.2f|\n",i,cuota,interesPorPeriodo,capitalAmortizado,capitalPendiente);
            exponente-=1;
        }
    }
    
}
