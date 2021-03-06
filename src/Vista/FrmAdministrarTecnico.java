/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controladores.ControladorTecnico;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class FrmAdministrarTecnico extends javax.swing.JInternalFrame {
    FrmUsuario frmUsuario;
    FrmEliminarUsuario frmEliminarUsuario;
    FrmVisualizadorCitas frmVisualizacionCitas;
    FrmModificarUsuario frmModificarUsuario;
  ControladorTecnico controladorTecnico;
    /**
     * Creates new form FrmAdministrarTecnico
     */
    public FrmAdministrarTecnico() {
        initComponents();  
    }
     public void obtenerFrm(FrmUsuario frm) {
        this.frmUsuario = frm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblCambiarContrasena = new javax.swing.JLabel();
        btnSalario = new javax.swing.JButton();
        btnRevicion = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Información");

        lblNombre.setText("Nombre");

        lblCambiarContrasena.setText("Cambiar Contraseña");
        lblCambiarContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCambiarContrasenaMouseClicked(evt);
            }
        });

        btnSalario.setText("Calcular Salario");
        btnSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalarioActionPerformed(evt);
            }
        });

        btnRevicion.setText("Revisiones");
        btnRevicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevicionActionPerformed(evt);
            }
        });

        lblCedula.setText("Cédula");

        lblCorreo.setText("Correo");

        lblSalario.setText("Salario");

        lblEliminar.setText("Eliminar Usuario");
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(lblCambiarContrasena)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalario)
                            .addComponent(lblCorreo))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblEliminar)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSalario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRevicion)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblCambiarContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEliminar)
                            .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(lblCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(lblSalario)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalario)
                    .addComponent(btnRevicion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalarioActionPerformed
       this.controladorTecnico=new ControladorTecnico(this);
    }//GEN-LAST:event_btnSalarioActionPerformed

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
         int clickCount = evt.getClickCount();
        lblEliminar.setForeground(Color.BLUE);
        if (clickCount == 2) {
            lblEliminar.setForeground(Color.BLACK);
            frmEliminarUsuario= new FrmEliminarUsuario();
            frmEliminarUsuario.obtenerfrm(this);
            frmUsuario.jDesktopPane1.add(frmEliminarUsuario);
            frmEliminarUsuario.show();
           
        }
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void btnRevicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevicionActionPerformed
        // TODO add your handling code here:
        this.frmVisualizacionCitas=new FrmVisualizadorCitas();
        frmVisualizacionCitas.obtenerfrm(this);
        frmVisualizacionCitas.obtenerfrm(frmUsuario);
        frmUsuario.getjDesktopPane1().add(frmVisualizacionCitas);
        frmVisualizacionCitas.show();
    }//GEN-LAST:event_btnRevicionActionPerformed

    private void lblCambiarContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarContrasenaMouseClicked
         int clickCount = evt.getClickCount();
        lblCambiarContrasena.setForeground(Color.BLUE);
        if (clickCount == 2) {
            lblCambiarContrasena.setForeground(Color.BLACK);
            frmModificarUsuario= new FrmModificarUsuario();
            frmModificarUsuario.obtenerfrm(this);
            frmModificarUsuario.obtenerfrm(frmUsuario);
            frmUsuario.jDesktopPane1.add(frmModificarUsuario);
            frmModificarUsuario.show();
           
        }
    }//GEN-LAST:event_lblCambiarContrasenaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRevicion;
    private javax.swing.JButton btnSalario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCambiarContrasena;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalario;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblCedula() {
        return lblCedula;
    }

    public JLabel getLblCorreo() {
        return lblCorreo;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public JLabel getLblSalario() {
        return lblSalario;
    }
    


}
