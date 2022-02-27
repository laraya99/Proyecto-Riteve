package Riteve;

public class Tecnicos {

    private String cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private double salario;

    //////////////////////////Constrcutores////////////////////////////////
    public Tecnicos(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, String salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = Double.parseDouble(salario);
    }

    public Tecnicos(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;

    }
    
    public Tecnicos() {
        
    }
    //////////////////////////Constrcutores////////////////////////////////
    //////////////////////////metodos////////////////////////////////

    public double calcularSalario(double salario) {
        double num = 0;
        if (salario > 817000 && salario <= 1226000) {
            double resta = salario - 817000;
            resta = (10 * resta) / 100;
            resta -= resta;
            salario -= resta;
        } else {
            if (salario > 1226000) {
                double resta = salario - 1226000;
                resta = (15 * resta) / 100;
                resta -= resta;
                salario -= resta;
            }

        }
        num += (5.5 * salario) / 100;
        num += (3.84 * salario) / 100;
        num += (1 * salario) / 100;
        num += (3.3 * salario) / 100;
        return salario -= num;
    }

    public String obtenerTecnico() {
        return this.getNombre() + this.getTelefono() + this.getCorreo();
    }

    //////////////////////////metodos////////////////////////////////
    //////////////////////////Metodos de acceso////////////////////////////////
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    ///////////////////////Metodos de acceso////////////////////////////////
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCedula() {
        return cedula;
    }
    
    

}
