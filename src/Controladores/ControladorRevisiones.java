package Controladores;

import Riteve.*;
import Vista.FrmRevisiones;
import Riteve.Archivo;
import Vista.FrmAdministrarSecretaria;
import Vista.FrmUsuario;
import Vista.FrmVisualizadorCitas;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ControladorRevisiones {

    FrmUsuario frmUsuario;
    FrmVisualizadorCitas frmVisualizadorCitas;
    private Configuraciones bd;
    private Vehiculos vehiculo;
    private Tecnicos tecnico;
    private Citas cita;
    private Revisiones revision;
    private FrmRevisiones frmRevisiones;
    private String fecha;
    private String hora;
    private String placa;

    public ControladorRevisiones() {
        this.vehiculo = null;
        this.revision = null;
        this.tecnico = null;
        this.frmRevisiones= null;
    }

    public ControladorRevisiones(FrmRevisiones frmRevisiones) {
        this.frmRevisiones= frmRevisiones;
//        this.llenarInformacion();
    }
    public ControladorRevisiones(FrmRevisiones frmRevisiones, String fecha,String hora, String placa) {
        this.frmRevisiones= frmRevisiones;
        this.setFecha(fecha);
        this.setHora(hora);
        this.setPlaca(placa);
        System.out.println(this.getFecha());
//        this.llenarInformacion();
    }
    
       public void obtenerFrm(FrmUsuario frmUsuario) {
        this.frmUsuario=frmUsuario;
    }

    public void obtenerCita() {
        this.frmRevisiones.setLblFecha(new JLabel("" + this.cita.getFecha() + ""));
        this.frmRevisiones.setLblHora(new JLabel("" + this.cita.getHora() + ""));
        this.frmRevisiones.setLblPlaca(new JLabel("" + this.vehiculo.getPlaca() + ""));
        this.frmRevisiones.setLblTecnico(new JLabel("" + this.tecnico.getNombre() + ""));
    }

    public void cambiarEstado() {
        if (frmRevisiones.getRbtnAprobado().isSelected()) {
            revision.setEstado(true);
        } else {
            revision.setEstado(false);
        }
    }

    public void tipoRevision() {
        if (frmRevisiones.getRbtnInspeccion().isSelected()) {
            revision.setRevision(Revision.INSPECCION);
        } else {
            revision.setRevision(Revision.REINSPECCION);
        }
    }

    public void guadarRevision() {
        cambiarEstado();
        tipoRevision();
        revision.setTecnico(frmRevisiones.getLblTecnico().getText());
        this.revision = new Revisiones(this.cita.getFecha(), this.cita.getHora(), this.frmRevisiones.getTxtRevision().getText());
        this.bd = new Configuraciones("Insert into revisiones values(?,?,?,?,?)");
        bd.ejecutar(new Object[]{revision.getFecha(), revision.getHora(), revision.getTecnico(), revision.getObservaciones(), revision.isEstado()});
    }

    
      public boolean validarHora(String hr){
        String[] hora=hr.split(":");
        int h=(Integer.parseInt(hora[0]));
        int m=(Integer.parseInt(hora[1]));
          Calendar hor = Calendar.getInstance();
       int ho=hor.get(Calendar.HOUR_OF_DAY);
        int mi= hor.get(Calendar.MINUTE);
        int retr=mi-m;
        return (h==ho&&m==mi)&&(retr>=-5&&retr<=0); 
    }
      
//          public String obtenerFecha() {
//        Calendar fecha = Calendar.getInstance();
//        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
//        String mes = this.obtenerMes(fecha.get(Calendar.MONTH));
//        String ano = String.valueOf(fecha.get(Calendar.YEAR));
//         return (dia + "/" + mes + "/" + ano);
//    }
          
    public boolean seleccionarCita(FrmVisualizadorCitas frm) {
        this.revision=new Revisiones();
        frm.tbCitas.getModel();
        int fila = frm.tbCitas.getSelectedRow();
        frm.tbCitas.getValueAt(fila, 0);
        this.bd = new Configuraciones("Select * from citas where Fecha = ? and Hora=?");
        bd.ejecutar(new Object[]{frm.getTbCitas().getValueAt(fila, 1).toString(),frm.getTbCitas().getValueAt(fila, 2).toString()});
        Object[] vec = this.bd.getObject();
        this.fecha=(vec[1].toString());
        this.hora=(vec[2].toString());
        this.placa=(vec[3].toString());
        
        frm.setPlaca(vec[3].toString());
        frm.setHora(vec[2].toString());
        frm.setFecha(vec[1].toString());
        
        System.out.println(fecha+" "+hora);
        validarHora(this.getHora());
        if (revision.obtenerFecha().equals(fecha) && revision.validarHora(hora)){
             this.revision=new Revisiones(fecha, hora);
             return true;
        }
        return false;
    }
    
    public void llenarInformacion(){
      
        cita=new Citas(this.fecha,this.hora,this.placa);
        this.frmRevisiones.getLblPlaca().setText(cita.getPlaca());
        this.frmRevisiones.getLblFecha().setText(cita.getFecha());
        this.frmRevisiones.getLblHora().setText(cita.getHora());
        this.frmRevisiones.getLblTecnico().setText(this.frmRevisiones.getFrmUsuario().getTxtCedula().getText());
}
    
    public String verificarEstado(){
        if(this.frmRevisiones.getRbtnAprobado().isSelected()){
            return "Aprobado";
        }else{
            if(this.frmRevisiones.getRbtnReprobado().isSelected()){
                return "Reprobado";
            }
        }
        return null;
    }
    public String verfifcarInspeccion(){
     if(this.frmRevisiones.getRbtnInspeccion().isSelected()){
         return "Inspeccion";
                 } else{
         if(this.frmRevisiones.getRbtnReinspeccion().isSelected()){
             return "ReInspeccion";
         }
     }return null;
    }
    
public void insertarRevision(){
    bd=new Configuraciones("insert into revisiones values(?,?,?,?,?,?,?)");
   
    bd.ejecutar(new Object[]{this.frmRevisiones.getLblPlaca().getText(),this.frmRevisiones.getLblFecha().getText(),this.frmRevisiones.getLblHora().getText(),this.frmRevisiones.getLblTecnico().getText(),
        this.verfifcarInspeccion(), this.frmRevisiones.getTxtObservaciones().getText(),this.verificarEstado()});
    
}
//public void revisiones(){
//    bd=new Configuraciones("select * from revisiones where Vehiculo=?");
//    bd.ejecutar(
//}

    public void importarArchivo() {
        Archivo arch = new Archivo("Revisiones " + this.cita.getFecha() + " " + this.cita.getHora());
        arch.escribir("<xml>");
        arch.escribir(this.vehiculo.toString());
        arch.escribir(this.revision.toString());
        arch.escribir("</xml>");
        arch.guardar();
        arch.cerrar();
    }
    
    public void obtenerdatos() {
         this.bd = new Configuraciones("Select * from reviciones  where Vehiculos=?");
         this.bd.ejecutar(new Object[] {frmRevisiones.getLblPlaca().getText()});
         Object[] vec = this.bd.getObject();
         
    }

    public Revisiones getRevision() {
        return revision;
    }

    public void setRevision(Revisiones revision) {
        this.revision = revision;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
}

