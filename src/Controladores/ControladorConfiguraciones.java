package Controladores;

import Riteve.Configuraciones;
import Vista.FrmUsuario;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ControladorConfiguraciones {

    private FrmUsuario frm;
    private Configuraciones conf;
    
    public ControladorConfiguraciones(Configuraciones conf) {
        this.conf = conf;
//      this.conectar();
    } 
    
//    public void conectar() {JOptionPane.showMessageDialog(null, "No sirve");
//        if (this.conf.conectar()) {
//         frm.setLblConexion((JLabel) (Icon) new JLabel (new javax.swing.ImageIcon(getClass().getResource("/Imagenes/conexionVerde_1.png"))));
//            
//        }else{
//            frm.setLblConexion((JLabel) (Icon) new JLabel (new javax.swing.ImageIcon(getClass().getResource("/Imagenes/conexionRoja_1.png"))));
//        }
//    }
}
