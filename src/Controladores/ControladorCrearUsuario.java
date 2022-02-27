/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Errores.ErrorDato;
import Riteve.Configuraciones;
import Riteve.Tecnicos;
import Riteve.Tipo;
import Riteve.Usuarios;
import Vista.FrmCrearUsuario;
import Vista.FrmUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilberth Ariel
 */
public class ControladorCrearUsuario {

    FrmUsuario frmUsuario;
    FrmCrearUsuario frmCrearUsuario;
    Riteve.Usuarios usuario;
    Riteve.Tecnicos tecnico;
    Riteve.Configuraciones bd;

    public ControladorCrearUsuario(FrmUsuario frm) {
        this.bd = new Configuraciones();
        this.frmUsuario = frm;
    }

    public void agregarUsuario() throws ErrorDato {
        String tipo = this.convertirButtongroup();

        this.usuario = new Usuarios(this.frmUsuario.getCrear().getTxtNombreCompleto().getText(), String.valueOf(this.frmUsuario.getCrear().getBoxDia().getSelectedItem()), String.valueOf(this.frmUsuario.getCrear().getBoxMes().getSelectedItem()), String.valueOf(this.frmUsuario.getCrear().getBoxAno().getSelectedItem()), this.frmUsuario.getCrear().getTxtTelefono().getText(),
                this.frmUsuario.getCrear().getTxtCorreo().getText(), this.frmUsuario.getCrear().getTxtNombreUsuario().getText(), this.frmUsuario.getCrear().getTxtContrasena().getText(), tipo, this.frmUsuario.getCrear().getTxtCedula().getText());
        System.out.println(usuario.getCedula() + "_" + usuario.getNombre() + "_" + usuario.getFecha() + "_" + usuario.getCorreo() + "_" + usuario.getTelefono() + "_" + usuario.getContrasena() + "_"
                + usuario.getTipoUsuario() + "_" + usuario.getNombreUsuario());

        bd.setSentencia("insert into usuarios values(?,?,?,?,?,?,?,?)");
        bd.ejecutar(new Object[]{usuario.getCedula(), usuario.getNombre(), usuario.getFecha(), usuario.getCorreo(), usuario.getTelefono(), usuario.getContrasena(),
            String.valueOf(usuario.getTipoUsuario()), usuario.getNombreUsuario()});

        if (this.frmUsuario.getCrear().getRbtnTecnico().isSelected()) {
            String salario = JOptionPane.showInputDialog(this.frmCrearUsuario, "Ingrese el salario");
            this.agregarTecnico(salario);
            JOptionPane.showConfirmDialog(this.frmCrearUsuario, "Ingresado exitosamente");
        }
    }

    public void agregarTecnico(String salario) {
        this.tecnico = new Tecnicos(this.frmUsuario.getCrear().getTxtCedula().getText(), this.frmUsuario.getCrear().getTxtNombreCompleto().getText(), String.valueOf(this.frmUsuario.getCrear().getBoxDia().getSelectedItem() + "/" + this.frmUsuario.getCrear().getBoxMes().getSelectedItem() + "/" + this.frmUsuario.getCrear().getBoxAno().getSelectedItem()), this.frmUsuario.getCrear().getTxtTelefono().getText(),
                this.frmUsuario.getCrear().getTxtCorreo().getText(), salario);
//         System.out.println(usuario.getCedula()+"_"+ usuario.getNombre()+"_"+ usuario.getFecha()+"_"+ usuario.getCorreo()+"_"+ usuario.getTelefono()+"_"+ usuario.getContrasena()+"_"+ 
//            usuario.getTipoUsuario()+"_"+ usuario.getNombreUsuario());
        bd.setSentencia("insert into tecnicos values(?,?,?,?,?,?)");
        System.out.println(tecnico.getCedula()+"_"+tecnico.getNombre()+"_"+tecnico.getFechaNacimiento()+"_"+tecnico.getCorreo()+"_"+ tecnico.getTelefono()+"_"+ tecnico.getSalario());
        bd.ejecutar(new Object[]{tecnico.getCedula(), tecnico.getNombre(), tecnico.getFechaNacimiento(), tecnico.getCorreo(), tecnico.getTelefono(), String.valueOf(tecnico.getSalario())});
    }

    public String convertirButtongroup() {

        switch (this.frmUsuario.getCrear().getButtonGroup1()) {
            case "TECNICO":
                return "TECNICO";
            case "SECRETARIA":
                return "SECRETARIA";
        }
        return null;
    }

    public FrmUsuario getFrmUsuario() {
        return frmUsuario;
    }

}
