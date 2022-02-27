package Controladores;

import Riteve.Citas;
import Riteve.Configuraciones;
import Riteve.Revisiones;
import Riteve.Vehiculos;
import Vista.FrmCitas;
import Vista.FrmUsuario;
import Vista.FrmVisualizadorCitas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorCitas {

    private FrmCitas frmCitas;
    FrmVisualizadorCitas frmListaCitas;
    private Citas cita;
    private Configuraciones bd;
    FrmUsuario frmusuario;
    private String fecha;
    private Vehiculos vehiculo;
    Revisiones revision;
    FrmVisualizadorCitas frmVisualizadorCitas;
    
    public ControladorCitas(FrmCitas frm) {
        this.frmCitas = frm;
      
        this.bd=new Configuraciones();
    }
    public ControladorCitas(FrmVisualizadorCitas frm) {
        this.frmVisualizadorCitas = frm;
        frmusuario=null;
     
    }

   public void agregarCita(FrmCitas frm) {
     this.setFecha(frm.getBoxDia().getSelectedItem()+"/"+frm.getBoxMes().getSelectedItem()+"/"+frm.getBoxAno().getSelectedItem());
     
        this.cita = new Citas(0,this.getFecha(),(frm.getCbHora().getSelectedItem() + ":" + frm.getCbMin().getSelectedItem()),frm.getTxtPlaca().getText());
        System.out.println(this.getFecha());
        if (!validarCitas()) {
             JOptionPane.showMessageDialog(frmCitas, "Se agregó la cita");
            this.bd = new Configuraciones("Insert into citas values(null,?,?,?)");
      
            bd.ejecutar(new Object[]{this.cita.getFecha(), this.cita.getHora(),this.cita.getPlaca()});
        }else{
            JOptionPane.showMessageDialog(frmCitas, "Esta hora no está disponible");
        }
    }

    public boolean validarCitas() {
         this.cita = new Citas(0,this.getFecha(),(frmCitas.getCbHora().getSelectedItem() + ":" + frmCitas.getCbMin().getSelectedItem()),frmCitas.getTxtPlaca().getText());
         this.bd = new Configuraciones("Select  Fecha ,Hora from citas where Fecha = ? and Hora = ?");
          this.bd.ejecutar(new Object[]{ this.cita.getFecha() ,(frmCitas.getCbHora().getSelectedItem() + ":" + frmCitas.getCbMin().getSelectedItem()) });
          Object[] vec = bd.getObject();
          if (vec == null) {    
              return false;
        }
          return true;
    }
    
    public boolean validarPlaca(){
          this.vehiculo=new Vehiculos(frmCitas.getTxtPlaca().getText());
          this.bd = new Configuraciones("Select  Placa from vehiculos where Placa=?");
            this.bd.ejecutar(new Object[]{frmCitas.getTxtPlaca().getText() });
            Object[] vec = bd.getObject();
            if (vec!=null) {
            return true;
        }
          return false;  
    }
    
    public void buscarCita() {
       
       this.cita = new Citas((frmVisualizadorCitas.getBoxDia().getSelectedItem() + "/" + frmVisualizadorCitas.getBoxMes().getSelectedItem() + "/" +
                frmVisualizadorCitas.getBoxAno().getSelectedItem()));
         System.out.println(cita.getFecha());
        this.bd = new Configuraciones("Select  * from citas where Fecha = ? ");
        this.bd.ejecutar(new Object[] {this.cita.getFecha()});  
        this.filtrar();
    }
    
    public void filtrar() {
        DefaultTableModel modelo = (DefaultTableModel) frmusuario.getFrmVCitas().getTbCitas().getModel();
        modelo.setNumRows(0);
        Object[] obj;
        do {
            obj = bd.getObject();
            if (obj != null) {
                this.cita = new Citas(obj);
                modelo.addRow(this.cita.toObjects());
                System.out.println("111111111111");
            }
        } while (obj != null);
    }
    
    public void fecha(){
       this.setFecha( this.frmCitas.getBoxDia().getSelectedItem()+"/"+this.frmCitas.getBoxMes().getSelectedItem()+"/"+this.frmCitas.getBoxAno().getSelectedItem());
    }
    public void fechaCita(){
        this.setFecha(this.frmVisualizadorCitas.getBoxDia().getSelectedItem()+"/"+this.frmVisualizadorCitas.getBoxMes().getSelectedItem()+"/"+this.frmVisualizadorCitas.getBoxAno().getSelectedItem());
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}