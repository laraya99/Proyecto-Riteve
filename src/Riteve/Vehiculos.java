package Riteve;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Vehiculos {

    private String placa;
    private String modelo;
    private String ano;
    private String fechaInscripcion;
    private String nombreP;
    private String cedulaP;
private String marca;

    public Vehiculos(String placa){
        this.evaluarPlaca(placa);
    }

    public Vehiculos() {
      
    }

    public Vehiculos(String placa,String marca, String modelo, String ano, String fechaInscripcion, String nombreP, String cedulaP) {
        this.evaluarPlaca(placa);
        this.modelo = modelo;
        this.ano = ano;
        this.fechaInscripcion = fechaInscripcion;
        this.nombreP = nombreP;
        this.cedulaP = cedulaP;
        this.marca=marca;
    }
    
    /////////////////////metodos///////////////////////
    public int Antiguedad(int inscripcion) {
        Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(Calendar.YEAR);
        int antiguedad = (anoActual - inscripcion);
        return antiguedad;
    }

    public void evaluarPlaca(String placa) {
        String formato = ("^[A-Za-z0-9-_]{3}+[0-9-_]{3}");
        Pattern patern = Pattern.compile(formato);
        Matcher mat = patern.matcher(placa);
        if (mat.matches()) {
            this.setPlaca(placa);
        } else {
            JOptionPane.showMessageDialog(null, "placa incorrecto");
        }
    }

    /////////////////////metodos///////////////////////
    /////////////////////metodos de acceso///////////////////////
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getCedulaP() {
        return cedulaP;
    }

    public void setCedulaP(String cedulaP) {
        this.cedulaP = cedulaP;
    }
    
    /////////////////////metodos de acceso///////////////////////

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "<Vehiculos>" + "<placa>" + placa  + "</placa>" + "< modelo>" + modelo + "< /modelo>" + "<año>" + ano+ "</año>" + "<fecha de Inscripcion>" + fechaInscripcion + "</fecha de Inscripcion>"
                + "< nombre del propietario>" + nombreP + "</nombre del propietario>"+ "<cedula del propietario>" + cedulaP+ "</cedula del propietario>"  + "<marca>" + marca + "<marca>" + "</Vehiculos>";
    }
    
}