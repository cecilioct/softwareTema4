/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author cecilio
 */
public class CtrolTrapecio {
    double suma=0;
    double sumatoria=0;
    double resultado=0;

    public tblTrapecio trapacio(double a, double b, double n) {
        ArrayList<csTrapecio> lista = null;
        tblTrapecio tabla = null;

        double h = (b - a) / n;
        double hDiv2 = h / 2;

        double fa = formula(a);
        double fb=formula(b);

        int j = 1;
        double ahj = (a + j) * h;
        double fx = formula(ahj);

        lista = new ArrayList<csTrapecio>();
        while (j < n) {
            
            csTrapecio fila = new csTrapecio();
            fila.setJ(j);
            fila.setAjh(ahj);
            fila.setFx(fx);
            suma+=fx;
            j++;
            ahj=(a+j)*h;
            fx=formula(ahj);
            lista.add(fila);
        }
        sumatoria=suma*2;
        resultado=hDiv2*(fa+fb+sumatoria);
        System.out.println("Resultado "+resultado);
        csTrapecio fila = new csTrapecio();
        tabla=new tblTrapecio(lista);
        
        
        
        
        return tabla;

    }

    double formula(double x) {
        double x2 = Math.pow(x, 2);
        double res =x2*3;

        return res;
    }
    public double getSu(){
       return suma;
    }
    public double getSuma(){
        return sumatoria;
    }
    public double getResultado(){
        return resultado;
    }
}
