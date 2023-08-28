package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Cama;
import com.example.hostelscocora.Model.Empleado;
import com.example.hostelscocora.Model.EstadoProducto;
import com.example.hostelscocora.Model.TipoProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AmpliacionCamaViewController {
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Cama camaSeleccionada;
    Empleado empleadoLoggeado;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEnviar;

    @FXML
    private ComboBox<EstadoProducto> cbxEstado;

    @FXML
    private TextField tfIdHabitacion;

    @FXML
    void onAtrasButtonClick(ActionEvent event) throws IOException {
        main.abrirPanelEmpleado(empleadoLoggeado);
    }

    @FXML
    void onEnviarButtonClick(ActionEvent event) throws IOException {
        String id = tfIdHabitacion.getText();
        EstadoProducto estadoProducto = cbxEstado.getValue();
        if (verificarCampos(id, estadoProducto)){
            singleton.cambiarCama(camaSeleccionada,id,estadoProducto);
            singleton.guardarResourceXML();
            singleton.guardarResourceBinario();
        }
        else {
            Alerta.saltarAlertaError("Verifique los campos");
        }
    }

    @FXML
    void initialize(){
         cbxEstado.getItems().add(EstadoProducto.DISPONIBLE);
        cbxEstado.getItems().add(EstadoProducto.MANTENIMIENTO);
        cbxEstado.getItems().add(EstadoProducto.OPERACION);
    }

    public void setMain(HelloApplication helloApplication) {
        this.main=helloApplication;
        tfIdHabitacion.setPromptText(camaSeleccionada.getIdHabitacionContiene());
    }

    public void setCamaSeleccionada(Cama camaSeleccionada) {
        this.camaSeleccionada=camaSeleccionada;
    }

    public void setEmpleadoLoggeado(Empleado empleadoLogeado) {
        this.empleadoLoggeado=empleadoLogeado;
    }
    private boolean verificarCampos(String a, EstadoProducto id) {
        if(a.isBlank()){
            return false;
        }
        if(id==null){
            return false;
        }
        return true;
    }

}
