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
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Date;

public class InicioAdministratorViewController {
    private ObservableList<Producto> listProductosData = FXCollections.observableArrayList();
        private ObservableList<Empleado> listEmpleadosData = FXCollections.observableArrayList();
        private ObservableList<Cliente> listClientesData = FXCollections.observableArrayList();
        private ObservableList<Reserva> listReservasData = FXCollections.observableArrayList();

        private Producto productoSeleccionado = null;
        private Empleado empleadoSeleccionado = null;
        private Cliente clienteSeleccionado = null;
        private Reserva reservaSeleccionada = null;
        private HelloApplication main;
        private ModelFactoryController singleton = ModelFactoryController.getInstance();

        @FXML
        private TableView<Cliente> tableCliente;
        @FXML
        private TableColumn<Cliente, String> colClienteNombre;
        @FXML
        private TableColumn<Cliente, String> colClienteCedula;

        @FXML
        private TableView<Empleado> tableEmpleado;
        @FXML
        private TableColumn<Empleado, String> colEmpleadoCedula;
        @FXML
        private TableColumn<Empleado, String> colEmpleadoNombre;

        @FXML
        private TableView<Reserva> tableReserva;
        @FXML
        private TableColumn<Reserva, String> colHabitacionReserva;
        @FXML
        private TableColumn<Reserva, Date> colEntradaReserva;
        @FXML
        private TableColumn<Reserva, Date> colSalidaReserva;

        @FXML
        private TableView<Producto> tableProducto;
        @FXML
        private TableColumn<Producto, String> colIdProducto;
        @FXML
        private TableColumn<Producto, String> colCamaHabitacion;
        @FXML
        private TableColumn<Producto, TipoProducto> colTipo;
        @FXML
        private TableColumn<Producto, EstadoProducto> colEstado;

        @FXML
        private Button btnCrearEmpleado;
        @FXML
        private Button btnNuevoProducto;
        @FXML
        private Button btnEliminarEmpleado;
        @FXML
        private Button btnEliminarProducto;

        public void onEliminarProductoButtonClick(ActionEvent actionEvent) {
            if(productoSeleccionado==null){
                Alerta.saltarAlertaError("SELECCIONE UN EMPLEADO");
            }
            else{
                try{
                    singleton.eliminarProducto(productoSeleccionado);
                    Alerta.saltarAlertaConfirmacion("Se ha eliminado el empleado correctamente");
                    singleton.guardarResourceXML();
                    tableEmpleado.refresh();
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                }
            }
        }

        public void onEliminarEmpleadoButtonClick(ActionEvent actionEvent) throws Exception {
            if(empleadoSeleccionado==null){
                Alerta.saltarAlertaError("SELECCIONE UN EMPLEADO");
            }
            else{
                try{
                    singleton.eliminarEmpleado(empleadoSeleccionado);
                    Alerta.saltarAlertaConfirmacion("Se ha eliminado el empleado correctamente");
                    singleton.guardarResourceXML();
                    tableEmpleado.refresh();
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                }
            }
        }

        public void onCrearEmpleadoButtonClick(ActionEvent actionEvent) throws IOException {
            main.abrirCrearEmpleado();
        }

        public void onNuevoProductoButtonClick(ActionEvent actionEvent) throws IOException {
            main.abrirCrearProducto();
        }

        public void setMain(HelloApplication helloApplication) {
            this.main = helloApplication;
            tableProducto.getItems().clear();
            tableProducto.setItems(obtenerListaProductos());
            tableEmpleado.getItems().clear();
            tableEmpleado.setItems(obtenerListaEmpleados());
            tableCliente.getItems().clear();
            tableCliente.setItems(obtenerListaClientes());
            tableReserva.getItems().clear();
            tableReserva.setItems(obtenerListaReservas());
        }

        @FXML
        void initialize() {
            colClienteNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            colClienteCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
            tableCliente.refresh();
            colEmpleadoNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            colEmpleadoCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
            tableEmpleado.refresh();
            colHabitacionReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
            colEntradaReserva.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaInicio()));
            colSalidaReserva.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaSalida()));
            tableReserva.refresh();
            colIdProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
            colCamaHabitacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificador()));
            colTipo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipo()));
            colEstado.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
            tableProducto.refresh();


            tableProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                productoSeleccionado = newSelection;
            });
            tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                clienteSeleccionado = newSelection;
            });
            tableEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                empleadoSeleccionado = newSelection;
            });
            tableReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                reservaSeleccionada = newSelection;
            });
        }

        private ObservableList<Producto> obtenerListaProductos() {
            listProductosData.addAll(singleton.getListaProdcutos());
            return listProductosData;
        }

        private ObservableList<Empleado> obtenerListaEmpleados() {
            listEmpleadosData.addAll(singleton.getListaEmpleados());
            return listEmpleadosData;
        }

        private ObservableList<Cliente> obtenerListaClientes() {
            listClientesData.addAll(singleton.getListaClientes());
            return listClientesData;
        }

        private ObservableList<Reserva> obtenerListaReservas() {
            listReservasData.addAll(singleton.getListaReservas());
            return listReservasData;
        }
    }
