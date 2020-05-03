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
public class CtrolSimpson {

    int N;
    double resultado = 0;

    public tblSimpson Simpson(double a, double b, int n) {
        ArrayList<csSimpson> lista = null;
        tblSimpson tabla = null;
        N = n;
        double h = (b-a) / n;
        double fa = formulaP(a);
        double fb = formulaP(b);

        int i = 1;
        double x = b;
        double y = formulaP(x);

        double s1[] = new double[n];
        double s2[] = new double[n];
        double vy[] = new double[n];

        lista = new ArrayList<csSimpson>();
        while (i <= n) {

            csSimpson fila = new csSimpson();

            fila.setI(i);
            fila.setX(x);
            fila.setY(y);

            vy[i - 1] = y;
            i++;
            x = (x) + h;
            y = formulaP(x);

            lista.add(fila);
        }
        tabla = new tblSimpson(lista);
        int u = 1;
        int v = 2;
        for (int t = 0; t <= 8; t++) {

            if (t < 8) {
                s1[t] = vy[u];
                s2[t] = vy[v];
            } else if (t == 8) {
                s1[t] = vy[u];
            }

            u += 2;
            v += 2;

            
        }

        double sumaUno = 0;
        double sumaDos = 0;
        for (int z = 0; z < s1.length; z++) {
            sumaUno += s1[z];
            sumaDos += s2[z];

        }

       
       resultado = (h / 3) * (fa + fb) + (((2 * h) / 3) * sumaDos) + (((4 * h) / 3) * sumaUno);

        return tabla;
    }

    public double formulaP(double x) {
        double value = Math.pow(x, 2);

        double res = 1 - value;
        res = Math.pow(res, 2);

        return res;
    }

    public double getIntegral() {
        return resultado;
    }
}
