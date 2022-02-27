/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Riteve;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author Estudiante
 */
public class Archivo {

    private String ruta;
    private String nombre;
    private String tipo;

    File archivo;
    BufferedReader lector;
    BufferedWriter escritor;



    public Archivo() {
        this.nombre = "ConfiguraciónBD";
        //ruta: carpeta del proyecto y el tipo= .utn
        this.ruta = System.getProperty("user.dir");
        tipo = ".ini";
        abrir();
    }

    public Archivo(String nombre) {
        this.nombre =nombre;
        this.ruta = System.getProperty("user.dir");
        this.tipo = ".xml";
        abrir();
    }
    
    public void abrir() {
        try {
            this.archivo = new File(this.ruta + "\\" + this.nombre + this.tipo);
            if (!this.existe()) {
                this.crear();
                System.out.println("Se creo");
            }
            System.out.println("No se creo");
            lector = new BufferedReader(new FileReader(this.archivo));
            escritor = new BufferedWriter(new FileWriter(this.archivo,true));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void cerrar() {
        try {
            this.lector.close();
            this.escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crear() {
        try {
            this.archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean existe(){
        return this.archivo.exists();
    }
    
    public void guardar(){
        try {
            this.escritor.flush();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leer(){
        try {
            return lector.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void escribir(String lector){
        try {
            escritor.write(lector);
            escritor.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(){
        archivo.delete();
    }
    
    public void limpiar(){
        try {
            escritor=new BufferedWriter(new FileWriter(archivo,false));
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
