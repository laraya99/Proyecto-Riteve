package Riteve;

import Riteve.Revision;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Revisiones {

    private String fecha;
    private String hora;
    private boolean estado;
    private Revision revision;
    private String observaciones;
    private Tecnicos tecnico;
    private int h;
    private int m;

    public Revisiones(String fecha, String hora, String observaciones) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.revision = revision;
        this.observaciones = observaciones;
    }

    public Revisiones(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public Revisiones(){
        this.obtenerFecha();
    }
 
    public int Antiguedad(int inscripcion) {
        Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(Calendar.YEAR);
        int antiguedad = (anoActual - inscripcion);
        return antiguedad;
    }

    public String obtenerFecha() {
        Calendar fecha = Calendar.getInstance();
        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
        String mes = this.obtenerMes(fecha.get(Calendar.MONTH));
        String ano = String.valueOf(fecha.get(Calendar.YEAR));
         return (dia + "/" + mes + "/" + ano);
    }
    
    public String obtenerMes(int mes){
        switch(mes){
            case 0:return "Enero"; case 1: return "Febrero";  case 2:return "Marzo";    case 3: return "Abril";case 4:  return "Mayo";case 5: return "Junio";
            case 6: return "Julio"; case 7:return "Agosto"; case 8:return "Setiembre"; case 9:return "Octubre"; case 10:return "Noviembre"; case 11:return "Diciembre";
          }
        return null;
    }

    public boolean validarHora(String hr){
        String[] hora=hr.split(":");
        this.setH(Integer.parseInt(hora[0]));
        this.setM(Integer.parseInt(hora[1]));
          Calendar hor = Calendar.getInstance();
       int ho=hor.get(Calendar.HOUR_OF_DAY);
        int mi= hor.get(Calendar.MINUTE);
        int retr=m-mi;
        return (h==ho)&&(retr>=-15&&retr<=0); 
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public Object getTecnico() {
        return tecnico;
    }

    public void setTecnico( Object tecnico) {
        this.tecnico = (Tecnicos) tecnico;
    }

    @Override
    public String toString() {
        return "<Revisiones>\n" + "<fecha>" + fecha  + "</fecha>\n"   + "<hora>" + hora  + "</hora>\n" + "<estado>" + estado + "</estado>\n" + "<revision>" + revision + "</revision>\n" + 
                "<observaciones>" + observaciones + "</observaciones>\n" + "<tecnico>" + tecnico + "</tecnico>\n" + "</Revisiones>";
    }
    
}