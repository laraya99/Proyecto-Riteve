package Riteve;

import Errores.ErrorDato;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import sun.applet.Main;

public class Usuarios {

    private String nombre;
    private String fecha;
    private String telefono;
    private String correo;
    private String nombreUsuario;
    private String contrasena;
    private Tipo tipoUsuario;
    private String tipoUser;
    private int dia;
    private int mes;
    private int ano;
    private String cedula;
    
///////////////////////////Constructores/////////////////////////////////

//    public Usuarios(String nombre, String dia, String mes, String anio, String telefono, String correo, String nombreUsuario, String contrasena, Tipo tipoUsuario, String cedula) throws ErrorDato {
//        this.corregirNombre(nombre);
//        this.fecha = this.evaluarFecha(Integer.valueOf(dia), Integer.valueOf(mes), Integer.valueOf(anio));
//        this.telefono = telefono;
//        this.correo = correo;
//        this.nombreUsuario = nombreUsuario;
//        this.contrasena = contrasena;
//        this.tipoUsuario = this.tipoUsuario.TECNICO;
//        this.verificarCedula(cedula);
//    }
    public Usuarios(String nombre, String dia, String mes, String ano, String telefono, String correo, String nombreUsuario, String contrasena, String tipoUsuario, String cedula) throws ErrorDato {
        this.corregirNombre(nombre);
//        this.fecha = this.evaluarFecha(Integer.valueOf(dia), Integer.valueOf(mes), Integer.valueOf(ano));
        this.setFecha(dia+"/"+mes+"/"+ano);
        this.telefono = telefono;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipoUsuario =this.getTipodeUsuario(tipoUsuario) ;
        this.verificarCedula(cedula);
    }

    public Usuarios(String nombre, String fecha, String cedula) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.cedula = cedula;
        this.telefono = "_";
        this.correo = "_";
        this.contrasena = "_";
        this.tipoUsuario = tipoUsuario.TECNICO;
        this.nombreUsuario = "_";
    }

    public Usuarios(String cedula, String contraseña) {
        this.verificarCedula(cedula);
        this.contrasena = contraseña;
    }
    public Usuarios(String cedula) {
        this.verificarCedula(cedula);
        
    }
    
     public Usuarios(Object[] vec) {
        this.cedula = (String) vec[0];
        this.nombre = (String) vec[1];
        this.fecha = (String) vec[2];
        this.correo = (String) vec[3];
        this.telefono = (String) vec[4];
        this.contrasena = (String) vec[5];
        this.tipoUser = (String) vec[6];
        this.nombreUsuario = (String) vec[7];
    }
   

    ////////////////////////////Constructores////////////////////////////////////////////
    //////////////////////////////////metodos///////////////////////////////////////////
    public String evaluarFecha(int dia, int mes, int ano) throws Errores.ErrorDato {

        if (mes == 2 && ano % 4 != 0) {
            if (dia <= 28 && dia > 0) {
                this.setDia(dia);
            } else {
                if (mes == 2 && ano % 4 == 0) {
                    if (dia <= 29 && dia > 0) {
                        this.setDia(dia);
                    }
                } else {
                    if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        if (dia > 0 && dia <= 30) {
                            this.setDia(dia);
                        }
                    } else {
                        if (dia > 0 && dia <= 31) {
                            this.setDia(dia);
                        }
                    }

                }
            }
        }
        return (String.valueOf(this.getDia()) + "/" + String.valueOf(this.getMes()) + "/" + String.valueOf(this.getAno()));
    }

//    public String evaluarCorreo(String correo) {
//        String email = ("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2.})$)");
//        Pattern pattern=Pattern.compile(email);
//        Matcher mat = pattern.matcher(correo);
//        if (mat.matches()) {
//            this.setCorreo(correo);
//            return correo;
//        } else {
//            JOptionPane.showMessageDialog(null, "correo incorrecto");
//        }
//        return null;
//    }

    public void corregirNombre(String nombre) {
        try {
            nombre.toLowerCase();
            String datos[] = nombre.split(" ");
            String nom = "";
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[i].length(); j++) {
                    datos[i] = datos[i].replace(String.valueOf(datos[i].charAt(j)), String.valueOf(datos[i].toLowerCase().charAt(j)));
                }
                nom += datos[i].replaceFirst(String.valueOf(datos[i].charAt(0)), String.valueOf(datos[i].toUpperCase().charAt(0))) + " ";
            }
            this.setNombre(nom);
        } catch (ErrorDato ex) {
        }
    }

    public Tipo getTipodeUsuario(String tipo) {
    if(tipo.equals("TECNICO")){
        return Tipo.TECNICO;
    }else{
        if(tipo.equals("SECRETARIA")){
            return Tipo.SECRETARIA;
        }
    }
    return null;
    }

    public void verificarCedula(String cedula) {
        String patron = ("[0-9-]{9}");
        Pattern patern = Pattern.compile(patron);
        Matcher mat = patern.matcher(cedula);
        if (mat.matches()) {
            this.setCedula(cedula);
        } else {
            JOptionPane.showMessageDialog(null, "cedula incorrecta");
        }
    }
    
    
  
    //////////////////////////////////metodos///////////////////////////////////////////
    ///////////////////////metodos de acceso/////////////////////////////////////////

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Errores.ErrorDato {
        if (nombre instanceof String) {
            this.nombre = nombre;
        }
        throw new Errores.ErrorDato();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {

        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Tipo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    public Object[] toObjects() {
        return new Object[] {this.cedula, this.nombre,this.fecha, this.correo, this.telefono,this.contrasena,this.tipoUser,this.nombreUsuario};
   }
  
}