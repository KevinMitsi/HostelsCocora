package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Cama;
import com.example.hostelscocora.Model.Cliente;
import com.example.hostelscocora.Model.Empleado;
import com.example.hostelscocora.Model.Reserva;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;

public class ReservaDeClienteController {
    private ObservableList<Reserva> listReservasData = FXCollections.observableArrayList();
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    Empleado empleadoLogeado;
    Cliente clienteSeleccionado;

    @FXML
    private Button btnAtras;


    @FXML
    private TableColumn<Reserva, LocalDate> colEntradaReservas;

    @FXML
    private TableColumn<Reserva, String> colHabitacionReservas;

    @FXML
    private TableColumn<Reserva, String> colIdReservas;

    @FXML
    private TableColumn<Reserva, LocalDate> colSalidaReservas;

    @FXML
    private TableView<Reserva> tableReservas;

    @FXML
    void onAtrasButtonClick(ActionEvent event) throws IOException {
        main.abrirPanelEmpleado(empleadoLogeado);
    }


    public void setMain(HelloApplication helloApplication) {
        this.main= helloApplication;
    }

    public void setEmpleadoLogeado(Empleado empleadoLogeado) {
        this.empleadoLogeado=empleadoLogeado;
    }

    public void setClienteLogeado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado=clienteSeleccionado;
    }

    private ObservableList<Reserva> obtenerListaReservass() {
        listReservasData.addAll(clienteSeleccionado.getListaReservas());
        return listReservasData;
    }
    @FXML
    void initialize(){
        colIdReservas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colHabitacionReservas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdHabitacion()));
        colEntradaReservas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaInicio()));
        colSalidaReservas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaSalida()));
        tableReservas.refresh();
    }
}
