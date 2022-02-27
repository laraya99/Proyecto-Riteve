package Controladores;

import Vista.*;
import Riteve.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuarios {
    
     private FrmUsuario frmUsuario;
    private FrmCrearUsuario frmCrearUsuario;
    private Usuarios usuario;
    private Configuraciones bd;
    private Tecnicos tecnico;
    private String cedula;
    private String nuevaContrasena;
    Tipo tipo;
    FrmModificarUsuario frmModificarUsuario;

   public ControladorUsuarios(FrmUsuario frm) {
       this.setFrmUsuario(frm);
        this.bd = new Configuraciones(); 
      
    }
   public ControladorUsuarios(){
       this.frmUsuario=this.getFrmUsuario();
       this.bd=this.getBd();
      
   }
  
    

    public String verficarUsuario() {
        usuario = new Usuarios(this.frmUsuario.getTxtCedula().getText(), this.frmUsuario.getTxtContrasena().getText());
        this.bd = new Configuraciones();
        bd.setSentencia("select * from usuarios where Cedula=? and Contrasena=?");
    
        if (bd.ejecutar(new Object[]{this.usuario.getCedula(), this.usuario.getContrasena()})) {
            Object[] vec = this.bd.getObject();
            return vec[6].toString();
        }else{
            JOptionPane.showMessageDialog(frmUsuario, "Usuario o Contraseña incorrecta");
        }
        return null;
    }
    
//      public void buscarUsuario(FrmEliminarUsuario frm) {
//    
//       this.setCedula(frm.getTxtBuscar().getText());
//       this.usuario=new Usuarios(this.getCedula());
//         
//       Configuraciones bd= new Configuraciones("Select  * from usuarios where Cedula like? ");
//       bd.ejecutar(new Object[]{"%" + this.usuario.getCedula() + "%"});
//   DefaultTableModel modelo = (DefaultTableModel) frm.getTblTabla().getModel();
//        modelo.setNumRows(0);
//        Object[] obj;
//        do {
//            obj = bd.getObject();
//            if (obj != null) {
//                usuario = new Usuarios(obj);
//                modelo.addRow(usuario.toObjects());
//            }
//        } while (obj != null);
//    }

      public void eliminarUsuario(FrmEliminarUsuario frm){
          frm.tblTabla.getModel();
             int fila= frm.tblTabla.getSelectedRow();
           frm.tblTabla.getValueAt(fila, 0);
           Configuraciones bd= new Configuraciones("Delete from usuarios where Cedula = ? ");
          int eliminar = JOptionPane.showConfirmDialog(frm,"¿Desea eliminar este usuario?");
          if (JOptionPane.OK_OPTION==eliminar){
              bd.ejecutar(new Object[]{Integer.valueOf(frm.getTblTabla().getValueAt(fila,0).toString())}); 
          }   
      }
      
      public void mostrarTablaUsuarios(FrmEliminarUsuario frm){
          Configuraciones bd= new Configuraciones("Select  * from usuarios");
          bd.ejecutar(new Object[] {});
          DefaultTableModel modelo = (DefaultTableModel) frm.getTblTabla().getModel();
        modelo.setNumRows(0);
        Object[] obj;
        do {
            obj = bd.getObject();
            if (obj != null) {
                usuario = new Usuarios(obj);
                modelo.addRow(usuario.toObjects());
            }
        } while (obj != null);
         
      }
      
      public boolean validarModificar(FrmModificarUsuario frm){
          if (frm.getTxtNueva().getText().equals(frm.getTxtConfirmar().getText())) {
              this.setNuevaContrasena(frm.getTxtConfirmar().getText());
              return true;
          }
          return false;
      }
      
      public void modificarContrasena(FrmModificarUsuario frm,FrmUsuario frm2){
          
          if (validarModificar(frm)) {
        this.usuario=new Usuarios( frm2.getTxtCedula().getText());
        bd.setSentencia("Update usuarios set Contrasena=? where Cedula=? ");
        bd.ejecutar(new Object[]{this.getNuevaContrasena(),this.usuario.getCedula()});
       JOptionPane.showMessageDialog(frmModificarUsuario, "Se actualizó correctamente");
       frm.dispose();
          }else{
              JOptionPane.showMessageDialog(frmModificarUsuario, "Datos incorrectos");
          }
          
      }
      
    public void tipoUsuario() {
        if (frmUsuario.isTipoUsuario()) {
            usuario.setTipoUsuario(Tipo.TECNICO);
        } else {
            usuario.setTipoUsuario(Tipo.SECRETARIA);
        }
    }
   

    public Configuraciones getBd() {
        return bd;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setFrmUsuario(FrmUsuario frmUsuario) {
        this.frmUsuario = frmUsuario;
    }
    

    public FrmUsuario getFrmUsuario() {
        return frmUsuario;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }
    
    
    
    public String obtenerTipo(){
        if (this.getTipo()==this.getTipo().SECRETARIA) {
            return "SECRETARIA";
        }else{
            if (this.getTipo()==this.getTipo().TECNICO) {
                return "TECNICO";
            }
        }
        return null;
    }
    
}
