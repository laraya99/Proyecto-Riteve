package Controladores;

import Riteve.Configuraciones;
import Riteve.Tecnicos;
import Riteve.Usuarios;
import Vista.FrmAdministrarTecnico;
import Vista.FrmInformacionVehiculo;

import Vista.FrmUsuario;
import javax.swing.JOptionPane;

public class ControladorTecnico {
    Riteve.Usuarios usuario;
    FrmAdministrarTecnico frmAdministrarTecnico;
    Configuraciones bd;
    Riteve.Tecnicos tecnico;
    FrmUsuario frmUsuario;
    
//    public ControladorTecnico(FrmUsuario frm) {
//       
//    }

    public ControladorTecnico(FrmUsuario frm) {
        bd = new Configuraciones();
        this.frmUsuario=frm;
        this.obtenerDatos(); 
    }
    public ControladorTecnico(FrmAdministrarTecnico frm) {
        
    }
    
    
    public void obtenerDatos(){
        this.usuario=new Usuarios(frmUsuario.getTxtCedula().getText());
        bd.setSentencia("select * from usuarios where Cedula=?");
        bd.ejecutar(new Object[]{usuario.getCedula()});
        Object[] vec = this.bd.getObject();
 frmUsuario.getFrmTecnico().getLblCedula().setText(vec[0].toString());
        frmUsuario.getFrmTecnico().getLblCorreo().setText(vec[3].toString());
        frmUsuario.getFrmTecnico().getLblNombre().setText(vec[1].toString());

    }
    
   


 public void obtenerSalario(){
        this.tecnico=new Tecnicos();
        bd.setSentencia("select * from tecnicos where Cedula=?");
        
        if(bd.ejecutar(new Object[]{this.frmAdministrarTecnico.getLblCedula().getText()})){
             Object[] vec = this.bd.getObject();
             double salario=Double.parseDouble(vec[5].toString());
             this.tecnico.calcularSalario(salario);
             JOptionPane.showMessageDialog(this.frmAdministrarTecnico,salario );
        }
       
        
    }
}
