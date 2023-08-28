package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Empleado;
import com.example.hostelscocora.Model.EstadoProducto;
import com.example.hostelscocora.Model.Habitacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class AmpliacionHabitacionViewController {
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public ComboBox<Boolean> cbxReservada;
    Habitacion habitacionSeleccionando;
    Empleado empleadoLoggeado;
    HelloApplication main;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEnviar;

    @FXML
    private ComboBox<EstadoProducto> cbxEstado;

    @FXML
    void onAtrasButtonClick(ActionEvent event) throws IOException {
        main.abrirPanelEmpleado(empleadoLoggeado);
    }

    @FXML
    void onEnviarButtonClick(ActionEvent event) throws IOException {
        if(cbxEstado==null||cbxReservada==null){
            Alerta.saltarAlertaError("Seleccione un estado de la Habitacion");
        }
        else {
            singleton.cambiarHabitacion(habitacionSeleccionando,cbxEstado.getValue(),cbxReservada.getValue());
            }
    }

    public void setMain(HelloApplication helloApplication) {
        this.main=helloApplication;

    }
    public void setHabitacionSeleccionada(Habitacion habitacionSeleccionada){
        this.habitacionSeleccionando=habitacionSeleccionada;

    }

    public void setEmpleadoLoggeado(Empleado empleadoLogeado) {
        this.empleadoLoggeado=empleadoLogeado;
    }
    @FXML
    void initialize(){
        cbxEstado.getItems().add(EstadoProducto.DISPONIBLE);
        cbxEstado.getItems().add(EstadoProducto.OPERACION);
        cbxEstado.getItems().add(EstadoProducto.MANTENIMIENTO);
        cbxReservada.getItems().add(true);
        cbxReservada.getItems().add(false);
    }
}
