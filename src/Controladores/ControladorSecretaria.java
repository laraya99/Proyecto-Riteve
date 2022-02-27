/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Riteve.Configuraciones;
import Riteve.Usuarios;
import Vista.FrmAdministrarSecretaria;
import Vista.FrmAdministrarTecnico;
import Vista.FrmUsuario;

/**
 *
 * @author Wilberth Ariel
 */
public class ControladorSecretaria {
     
    Riteve.Usuarios usuario;
    FrmAdministrarSecretaria frmSecretaria;
    Configuraciones bd;
    FrmUsuario frmUsuario;
    
    public ControladorSecretaria(FrmUsuario frm) {
        bd = new Configuraciones();
        this.frmUsuario=frm;
        this.obtenerDatos();
    }
 public void obtenerDatos(){
        this.usuario=new Usuarios(frmUsuario.getTxtCedula().getText());
        bd.setSentencia("select * from usuarios where Cedula=?");
        bd.ejecutar(new Object[]{usuario.getCedula()});
        Object[] vec = this.bd.getObject();
        frmUsuario.getFrmSecre().getLblCedula().setText(vec[0].toString());
        frmUsuario.getFrmSecre().getLblCorreo().setText(vec[3].toString());
        frmUsuario.getFrmSecre().getLblNombre().setText(vec[1].toString());
        frmUsuario.getFrmSecre().getLblTel().setText(vec[4].toString());
        
    }

}
