package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.*;
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

public class PanelEmpleadoController {
    public Button btnAmpliarCama;
    public Button btnRegresar;
    public Button btnAmpliarHabitacion;
    private ObservableList<Cama> listCamasData = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listHabitacionesData = FXCollections.observableArrayList();
    private ObservableList<Cliente> listClientesData = FXCollections.observableArrayList();
    Empleado empleadoLogeado;
    private Cama camaSeleccionada = null;
    private Habitacion habitacionSeleccionada = null;
    private Cliente clienteSeleccionado = null;
    HelloApplication main;
    ModelFactoryController singleton = new ModelFactoryController();

    @FXML
    private Button btnCrearCliente;

    @FXML
    private Button btnReservasCliente;

    @FXML
    private TableView<Cama> TableCamas;

    @FXML
    private TableColumn<Cama, EstadoProducto> colEstadoCamas;

    @FXML
    private TableColumn<Cama, String> colIdCama;

    @FXML
    private TableColumn<Cama, String> colIdHabitacion;
    @FXML
    private TableColumn<Cama, TipoProducto> colTipo;


    @FXML
    private TableView<Habitacion> tableHbabitacion;

    @FXML
    private TableColumn<Habitacion, EstadoProducto> colEsatdoHabitaciones;
    @FXML
    private TableColumn<Habitacion, String> colIdHabitaciones;

    @FXML
    private TableColumn<Habitacion, TipoProducto> colTipoHabitaciones;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, String> colIdCliente;


    @FXML
    private TableColumn<Cliente, String> colNombreCliente;


    @FXML
    void onCrearClienteButtonClick(ActionEvent event) {

    }

    @FXML
    void onEstadoCamaButtonClick(ActionEvent event) {

    }

    @FXML
    void onIdCamaButtonClick(ActionEvent event) throws IOException {
        main.abrirAmpliarCama(camaSeleccionada, empleadoLogeado);
    }

    @FXML
    void onIdHabitacionCamaButtonClick(ActionEvent event) {

    }

    @FXML
    void onReservasClienteButtonClick(ActionEvent event) {

    }

    @FXML
    void onTipoCamaButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize(){
        colNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colIdCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tableCliente.refresh();
        colEstadoCamas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        colIdCama.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colIdHabitacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdHabitacionContiene()));
        colTipo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipo()));
        TableCamas.refresh();
        colIdHabitaciones.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colEsatdoHabitaciones.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        colTipoHabitaciones.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipo()));
        tableHbabitacion.refresh();

        tableHbabitacion.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            habitacionSeleccionada = newSelection;
        });
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
        });
        TableCamas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            camaSeleccionada = newSelection;
        });
    }


    private ObservableList<Cama> obtenerListaCamas() {
        listCamasData.addAll(singleton.getListaCamas());
        return listCamasData;
    }

    private ObservableList<Habitacion> obtenerListaHabitacioness() {
        listHabitacionesData.addAll(singleton.getListaHabitaciones());
        return listHabitacionesData;
    }

    private ObservableList<Cliente> obtenerListaClientes() {
        listClientesData.addAll(singleton.getListaClientes());
        return listClientesData;
    }


    public void setMain(HelloApplication helloApplication) {
        this.main = helloApplication;
        tableHbabitacion.getItems().clear();
        tableHbabitacion.setItems(obtenerListaHabitacioness());
        TableCamas.getItems().clear();
        TableCamas.setItems(obtenerListaCamas());
        tableCliente.getItems().clear();
        tableCliente.setItems(obtenerListaClientes());
    }

    public void setEmpleado(Empleado empleadoLogeado) {
        this.empleadoLogeado=empleadoLogeado;
    }

    public void onAmpliarButtonClick(ActionEvent actionEvent) {
    }

    public void onActionButtonClick(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
    }

    public void onAmpliarHabitacionButtonClick(ActionEvent actionEvent) {
    }
}
