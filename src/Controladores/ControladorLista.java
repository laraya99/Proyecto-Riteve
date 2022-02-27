/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Riteve.Citas;
import Riteve.Configuraciones;
import Vista.FrmCitas;
import Vista.FrmVisualizadorCitas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
   



/**
 * 
 * @author 
 */
public class ControladorLista {
    private FrmCitas frmCitas;
    private Citas cita;
 FrmVisualizadorCitas frmVisualizadorCitas;
  
    private Configuraciones bd;
 private String fecha;
 public ControladorLista(FrmVisualizadorCitas frm) {
        this.frmVisualizadorCitas = frm;
       this.cita=null;
    }
    
      public ControladorLista() {
        this.frmVisualizadorCitas = null;
        this.cita=null;
    }
      
      public void buscarCita(FrmVisualizadorCitas frm) {
    
       this.setFecha(frm.getBoxDia().getSelectedItem() + "/" + frm.getBoxMes().getSelectedItem() + "/" +frm.getBoxAno().getSelectedItem());
       this.cita=new Citas(this.getFecha());
         System.out.println(cita.getFecha());
       Configuraciones bd= new Configuraciones("Select  * from citas where Fecha =? ");
       bd.ejecutar(new Object[]{this.cita.getFecha()});
   DefaultTableModel modelo = (DefaultTableModel) frm.getTbCitas().getModel();
        modelo.setNumRows(0);
        Object[] obj;
        do {
            obj = bd.getObject();
            if (obj != null) {
                cita = new Citas(obj);
                modelo.addRow(cita.toObjects());
            }
        } while (obj != null);
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
      
      
}
