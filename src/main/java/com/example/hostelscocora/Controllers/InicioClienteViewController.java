package com.example.hostelscocora.Controllers;


import com.example.hostelscocora.Model.Cama;
import com.example.hostelscocora.Model.Cliente;
import com.example.hostelscocora.Model.Reserva;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import com.example.hostelscocora.HelloApplication;

import java.io.IOException;
import java.time.LocalDate;

public class InicioClienteViewController {
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    private ObservableList<Reserva> listReservasData = FXCollections.observableArrayList();
    Cliente clienteLogeado;

    Reserva reservaSeleccionada;



    @FXML
    private Button bntEliminarReserva;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnReservar;

    @FXML
    private TableColumn<Reserva, LocalDate> colCamaExtraReservarCliente;

    @FXML
    private TableColumn<Reserva, String> colIDReservaReservarCliente;

    @FXML
    private TableColumn<Reserva, String> colUsuarioReservarCliente;

    @FXML
    private TableView<Reserva> tableReservarCliente;

    @FXML
    private Label tfReservas;

    @FXML
    void onEliminarReservaButtonClick(ActionEvent event) {
        if(reservaSeleccionada==null){
            Alerta.saltarAlertaError("No ha seleccionado ninguna Reserva");
        }
        else {
            clienteLogeado.getListaReservas().remove(reservaSeleccionada);
            Alerta.saltarAlertaInformacion("Reserva eliminada");
        }

    }

    @FXML
    void onRegresarButtonClick(ActionEvent event) throws IOException {
        main.inicializarLogin();
    }

    @FXML
    void onReservarButtonClick(ActionEvent event) throws IOException {
        main.abrirNuevaReserva(clienteLogeado);
    }


    public void setMain(HelloApplication helloApplication) {
        this.main = helloApplication;
        tableReservarCliente.getItems().clear();
        tableReservarCliente.setItems(obtenerListaReservass());
    }
    private ObservableList<Reserva> obtenerListaReservass() {
        listReservasData.addAll(clienteLogeado.getListaReservas());
        return listReservasData;
    }
    @FXML
    void initialize(){
        colIDReservaReservarCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colUsuarioReservarCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdHabitacion()));
        colCamaExtraReservarCliente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaInicio()));
        tableReservarCliente.refresh();

        tableReservarCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaSeleccionada = newSelection;
        });
    }

    public void setCliente(Cliente clienteLogeado) {
        this.clienteLogeado=clienteLogeado;
    }
}
