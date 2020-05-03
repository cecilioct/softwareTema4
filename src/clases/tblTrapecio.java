/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bryan
 */
public class tblTrapecio extends AbstractTableModel {
    private String columnas[]={"i","(a+j)*h","fx"};
     private ArrayList<csTrapecio> lista=null;

    public tblTrapecio(ArrayList<csTrapecio> resultado) {
        this.lista=resultado;
    }
     
    
    @Override
    public int getRowCount() {
                return this.lista.size();

    }

    
    @Override
    public int getColumnCount() {
                return this.columnas.length;

    }
    
    @Override
    public Object getValueAt(int i, int columna) {
        csTrapecio fila = this.lista.get(i);
        switch(columna){
            case 0: return fila.getj();
            case 1: return fila.getAjh();
            case 2: return fila.getFx();
           
        }
        return null;
    }
    @Override
     public boolean isCellEditable(int i, int i1) {
        return true;
    }

    
    @Override
    public String getColumnName(int i) {
        return this.columnas[i];
    }
     
    
}
