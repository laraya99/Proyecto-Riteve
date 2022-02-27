package Riteve;

import java.util.Calendar;

public class Citas {

    private int id;
    private String fecha;
    private String hora;
    private String placa;

    public Citas(int id, String fecha, String hora, String placa) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.placa = placa;
    }

    public Citas(String fecha, String hora, String placa) {
        this.fecha = fecha;
        this.hora = hora;
        this.placa = placa;
    }
    


//    public void obtenerFecha() {
//        Calendar fecha = Calendar.getInstance();
//        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
//        String mes = String.valueOf(fecha.get(Calendar.MONTH));
//        String ano = String.valueOf(fecha.get(Calendar.YEAR));
//
//        this.setFecha(dia + "/" + mes + "/" + ano);
//    }
    public Citas(Object[] vec) {
        this.id = (Integer) vec[0];
        this.fecha = (String) vec[1];
        this.hora = (String) vec[2];
        this.placa = (String) vec[3];
    }

    public Citas(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object[] toObjects() {
        return new Object[] {this.id, this.fecha, this.hora, this.placa};
   }
  
}
