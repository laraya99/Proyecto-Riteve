package Riteve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Configuraciones {

    private static Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet dato;
    private ArrayList<Object> oj;
    private boolean estado;
    private Archivo archivo;
    private String IP;
    private String usuario;
    private String nombreBD;
    private String contrasena;
   

    public Configuraciones(String sent) {
        
        this.conectar();
        this.setSentencia(sent);
        
    }

    public Configuraciones() {
        this.conectar();
        
    }
    

    public boolean conectar() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("driver cargado correctamente");
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/riteve?userServerPrepStmts=true","riteve","123");
                System.out.println("servidor conectado");
                this.setEstado(true);
                return true;
            } catch (ClassNotFoundException ex) {
                System.out.println("driver no cargado");
                Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                System.out.println("servidor no conectado");
                Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("---------------------");
            } finally {
                this.setEstado(false);
                return false;
            }
        }
        this.setEstado(false);
        return false;
    }

    

    public void setSentencia(String sent) {
        try {
            this.sentencia = conexion.prepareStatement(sent);
        } catch (SQLException ex) {
            Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametros(Object[] param) {
        System.out.println(param.length);
        for (int i = 0; i < param.length; i++) {
            
            if (param[i] instanceof String) {
                try {
                    this.sentencia.setString(i + 1, param[i].toString());
                } catch (SQLException ex) {
                    Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (param[i] instanceof Integer) {
                try {
                    this.sentencia.setInt(i + 1, (int) param[i]);
                } catch (SQLException ex) {
                    Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean ejecutar() {
        try {
            if (this.sentencia.execute()) {
                this.dato = this.sentencia.getResultSet();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean ejecutar(Object[] param) {
        this.setParametros(param);
        return this.ejecutar();
    }
    
    public Object[] getObject() {
        try {
            if (this.dato.next()) {
                ArrayList<Object> obj = new ArrayList();
                for (int i = 1; i <= this.dato.getMetaData().getColumnCount(); i++) {
                    obj.add(this.dato.getObject(i));
                }
                return obj.toArray();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Object> getOj() {
        return oj;
    }

    public void setOj(ArrayList<Object> oj) {
        this.oj = oj;
    }

    public ResultSet getDato() {
        return dato;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}