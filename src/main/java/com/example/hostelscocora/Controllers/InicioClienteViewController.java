package com.example.hostelscocora.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import com.example.hostelscocora.HelloApplication;

public class InicioClienteViewController {

    @FXML
    private Button bntEliminarReserva;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnReservar;

    @FXML
    private TableColumn<?, ?> colCamaExtraReservarCliente;

    @FXML
    private TableColumn<?, ?> colIDReservaReservarCliente;

    @FXML
    private TableColumn<?, ?> colUsuarioReservarCliente;

    @FXML
    private TableView<?> tableReservarCliente;

    @FXML
    private Label tfReservas;

    @FXML
    void onEliminarReservaButtonClick(ActionEvent event) {

    }

    @FXML
    void onRegresarButtonClick(ActionEvent event) {

    }

    @FXML
    void onReservarButtonClick(ActionEvent event) {

    }
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();


    public void setMain(HelloApplication helloApplication) {
        this.main = helloApplication;
    }
}
