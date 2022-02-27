package Controladores;

import Riteve.Configuraciones;
import Riteve.Vehiculos;
import Vista.FrmAgregarVehiculo;
import Vista.FrmInformacionVehiculo;
import Vista.FrmRevisiones;
import Vista.FrmUsuario;

public class ControladorVehiculo {
    Vista.FrmInformacionVehiculo frmInformacionVehiculo;
    FrmUsuario frnUsuario;
    FrmAgregarVehiculo frmAgregarVehiculo;
    Vehiculos vehiculo;
      FrmUsuario frmUsuario;
    Configuraciones bd;
    FrmRevisiones frmRevisiones;
    
    
    public ControladorVehiculo( FrmAgregarVehiculo frm){
        this.frmAgregarVehiculo = frm;
          bd = new Configuraciones();
          
    }

    public ControladorVehiculo(FrmInformacionVehiculo frmInformacionVehiculo,FrmRevisiones frmRevisiones) {
        this.frmInformacionVehiculo = frmInformacionVehiculo;
        this.frmRevisiones=frmRevisiones;
         bd = new Configuraciones();
    }
    
    
    
    public void agregarVehiculo(){
        this.vehiculo=new Vehiculos(this.frmAgregarVehiculo.getTxtPlaca().getText(),this.frmAgregarVehiculo.getTxtMarca().getText(),this.frmAgregarVehiculo.getTxtModelo().getText(),this.frmAgregarVehiculo.getBoxAnoCarro().getSelectedItem().toString(),
        this.obtenerInscripcion(),this.frmAgregarVehiculo.getTxtpropetario().getText(), this.frmAgregarVehiculo.getTxtCedula().getText());
        this.bd=new Configuraciones("insert into vehiculos values(?,?,?,?,?,?,?)");
         this.bd.ejecutar(new Object[]{this.vehiculo.getPlaca(),this.vehiculo.getMarca(),this.vehiculo.getModelo(),this.vehiculo.getAno(),this.vehiculo.getFechaInscripcion(),this.vehiculo.getNombreP(),this.vehiculo.getCedulaP()});
         Object[] vec = bd.getObject();
    }
    public String obtenerInscripcion(){
        return this.frmAgregarVehiculo.getBoxDiaInscrip().getSelectedItem()+"/"+ this.frmAgregarVehiculo.getBoxMesInscrip().getSelectedItem()+"/"+ this.frmAgregarVehiculo.getBoxAnoInscrip().getSelectedItem();
    }
  
    
    public void informacionVehiculo(){

         this.bd = new Configuraciones("Select * from vehiculos where Placa=?");
         bd.ejecutar(new Object[]{frmRevisiones.getPlaca()});
          Object[] vec = this.bd.getObject();
         frmInformacionVehiculo.getLblPlaca().setText(vec[0].toString());
         frmInformacionVehiculo.getLblMarca().setText(vec[1].toString());
         frmInformacionVehiculo.getLblModelo().setText(vec[2].toString());
         frmInformacionVehiculo.getLblAno().setText(vec[3].toString());
         frmInformacionVehiculo.getLblInscripcion().setText(vec[4].toString());
         frmInformacionVehiculo.getLblNomPropietario().setText(vec[5].toString());
         frmInformacionVehiculo.getLblCedPropietario().setText(vec[6].toString());
        
         vehiculo=new Vehiculos();
         this.frmInformacionVehiculo.getLblAntiguedad().setText(String.valueOf(this.vehiculo.Antiguedad(Integer.parseInt(vec[3].toString()))));
    }
}
