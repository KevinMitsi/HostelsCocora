package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.TipoProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;

public class AgregarProductoController {
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public ComboBox cbxCategoriaProducto;
    public ComboBox cbxTipoProducto;
    public TextField tfIdentificacion;
    public Button btnEnviar;
    public Button btnRegresar;

    public void onEnviarButtonClick(ActionEvent actionEvent) {
        String id = tfIdentificacion.getText();
        Object categoriaValue = cbxCategoriaProducto.getValue();
        Object tipoValue = cbxTipoProducto.getValue();
        if(verificarCampos(id,categoriaValue,tipoValue)){
           if(categoriaValue.equals("Cama")){
               if(tipoValue.equals("Sencilla")){
                   try{
                       singleton.crearCama(id, TipoProducto.SENCILLO);
                       singleton.guardarResourceXML();
                       main.abrirPanelAdministrador();
                   } catch (Exception e) {
                       Alerta.saltarAlertaError(e.getMessage());
                   }
               }
               if(tipoValue.equals("Doble")){
                   try{
                       singleton.crearCama(id, TipoProducto.DOBLE);
                       singleton.guardarResourceXML();
                       main.abrirPanelAdministrador();
                   } catch (Exception e) {
                       Alerta.saltarAlertaError(e.getMessage());
                   }
               }
           }
           if (categoriaValue.equals("Habitacion")){
               if(tipoValue.equals("Sencilla")){
                   try {
                       singleton.crearHabitacionSencilla(id,TipoProducto.SENCILLO,false,false,240000);
                       singleton.guardarResourceXML();
                       main.abrirPanelAdministrador();
                   } catch (Exception e) {
                       Alerta.saltarAlertaError(e.getMessage());
                   }

               }
               if(tipoValue.equals("Doble")){
                   int camas=preguntarNumeroCamas();
                   if(camas==0){
                       try{
                           singleton.crearHabitacionDoble(id,TipoProducto.DOBLE,false,false,1,0,360000);
                           singleton.guardarResourceXML();
                           main.abrirPanelAdministrador();
                       } catch (Exception e) {
                           throw new RuntimeException(e);
                       }
                   }
                   if(camas==2){
                       try{
                           singleton.crearHabitacionDoble(id,TipoProducto.DOBLE,false,false,0,2,340000);
                           singleton.guardarResourceXML();
                           main.abrirPanelAdministrador();
                       } catch (Exception e) {
                           throw new RuntimeException(e);
                       }
                   }
                   else{ try{
                       singleton.crearHabitacionDoble(id,TipoProducto.DOBLE,false,false,1,0,360000);
                       singleton.guardarResourceXML();
                       main.abrirPanelAdministrador();
                   } catch (Exception e) {
                       throw new RuntimeException(e);
                   }

                   }
               }
           }
        }
        else{
            Alerta.saltarAlertaError("Verifique los campos");
        }
    }

    private int preguntarNumeroCamas() {
        String camasSencillas = JOptionPane.showInputDialog("Ingrese el número de camas sencillas '0 o 2'", JOptionPane.INFORMATION_MESSAGE);
        int nCamasSencillas = 0;
        try {
            nCamasSencillas = Integer.parseInt(camasSencillas);
            if (nCamasSencillas < 0 || nCamasSencillas > 2) {
                Alerta.saltarAlertaError("No puede haber menos de 0 camas o más de 2 camas Sencillas");
            }
            else {
                return nCamasSencillas;
            }

        } catch (NumberFormatException e) {
            Alerta.saltarAlertaError("Ingrese un número válido");
        }
        return nCamasSencillas;
    }

    public void onRegresarButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelAdministrador();
    }

    public void setMain(HelloApplication helloApplication) {
        this.main = helloApplication;
    }

    private boolean verificarCampos(String id, Object value1, Object value2){
        if(id.isBlank()){
            return false;
        }
        if(value1==null||value2==null){
            return false;
        }
        return true;
    }

    @FXML
    void initialize() {
        cbxCategoriaProducto.getItems().add("Cama");
        cbxCategoriaProducto.getItems().add("Habitacion");
        cbxTipoProducto.getItems().add("Sencilla");
        cbxTipoProducto.getItems().add("Doble");
    }
}
