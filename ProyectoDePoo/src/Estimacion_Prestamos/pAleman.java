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

/*en el método alemán los intereses se calculan por anticipado, 
  sobre el capital vivo a principios de año. 
*/

public class pAleman extends CalculadoraPrestamo{    

    public pAleman(double monto,double interes,int periodo) {
        super(monto, interes, periodo);
    }
    
    @Override
    /*  para el cálculo necesitamos un cuota inicial de la cual 
        se irán cargando los intereses en periodos definidos por el Cliente y así
        ir obteniendo el Capital amortizado sobre el que iterar.
    */  
    public void calcularPrestamo() {
        double cuota = 0;
        double interesPorPeriodo = 0;
        double capitalAmortizado = 0;
        double capitalPendiente = getMonto();
        int exponente = getPeriodo();
        
        System.out.printf("|%8s|%10s|%8s|%18s|%18s|\n","Periodo","Cuota","Interes","Capital Amortizado","Capital Pendiente");
        
        for( int i = 1; i<=getPeriodo(); i++){
            
            cuota = (capitalPendiente*getInteres())/(1-Math.pow((1-getInteres()),exponente));
            interesPorPeriodo = (capitalPendiente-cuota)*getInteres();
            capitalAmortizado = cuota-interesPorPeriodo;
            capitalPendiente = capitalPendiente-capitalAmortizado;
            
            /* Se espera que el cálculo refleje:
            #de cuota | Monto Inicial | Monto Final | Capital | Interes | Cuota | Total 
            
            #de cuota:numero de iteración o Periodo,
            Monto Inicial: el Valor del Prestamo.
            Monto Final: Monto Inicial menos el valor del Capital.
            Capital: Monto fijo a pagar en cada iteracion.
            Interes: Tasa de interés por periodo.
            Cuota: Monto total a cancelar de Capital+Interes.
            Total: Suma de las Cuotas.
            */
            
            System.out.printf("|%8d|%10.2f|%8.2f|%18.2f|%18.2f|\n",i,cuota,interesPorPeriodo,capitalAmortizado,capitalPendiente);
            exponente-=1;
        }
    }
    
}
