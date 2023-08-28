package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Cliente;
import com.example.hostelscocora.Model.Habitacion;
import com.example.hostelscocora.Model.Reserva;
import com.example.hostelscocora.Model.TipoProducto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.security.auth.callback.LanguageCallback;
import java.io.IOException;
import java.time.LocalDate;

public class NuevaReservaViewController {
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    private ObservableList<Habitacion> listHabitacionesData = FXCollections.observableArrayList();
    Cliente clienteLogeado;
    Habitacion habitacionSeleccionada;


    @FXML
    private Button btnAtras;

    @FXML
    private Button btnReservar;

    @FXML
    private CheckBox cbCamaExtra;

    @FXML
    private TableColumn<Habitacion, String> colIdHabitacion;

    @FXML
    private TableColumn<Habitacion, TipoProducto> colTipoHabitacionHabitacion;

    @FXML
    private DatePicker dpEntrada;

    @FXML
    private DatePicker dpSalida;

    @FXML
    private TableView<Habitacion> tableHabitacion;

    @FXML
    void onAtrasButtonClick(ActionEvent event) throws IOException {
        main.abrirPanelCliente(clienteLogeado);
    }

    @FXML
    void onCamaExtraCheck(ActionEvent event) {

    }

    @FXML
    void onReservarButtonClick(ActionEvent event) {
        LocalDate inicio=dpEntrada.getValue();
        LocalDate salida=dpSalida.getValue();
        if(verificarCampos(habitacionSeleccionada,inicio,salida)){
            if(cbCamaExtra.isSelected()){
                habitacionSeleccionada.setCamaExtra(true);
                Reserva reserva = new Reserva(String.valueOf((int) (Math.random() * 40)), inicio, salida, clienteLogeado.getNombre(),habitacionSeleccionada.getId());
                try{
                    clienteLogeado.crearReserva(reserva);
                    habitacionSeleccionada.setReservada(true);
                    singleton.guardarResourceXML();
                    singleton.guardarResourceBinario();
                    main.abrirPanelCliente(clienteLogeado);
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                }
            }
            else {
                Reserva reserva = new Reserva(String.valueOf((int) (Math.random() * 40)), inicio, salida, clienteLogeado.getNombre(),habitacionSeleccionada.getId());
                try{
                    clienteLogeado.crearReserva(reserva);
                    habitacionSeleccionada.setReservada(true);
                    singleton.guardarResourceXML();
                    singleton.guardarResourceBinario();
                    main.abrirPanelCliente(clienteLogeado);
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                }
            }
        }
        else {
            Alerta.saltarAlertaError("Verifique los campos");
        }

    }

    public void setMain(HelloApplication helloApplication) {
        this.main=helloApplication;
        tableHabitacion.getItems().clear();
        tableHabitacion.setItems(obtenerListaHabitacioness());
    }

    public void setClienteLogeado(Cliente clienteLogeado) {
        this.clienteLogeado=clienteLogeado;
    }
    private ObservableList<Habitacion> obtenerListaHabitacioness() {
        listHabitacionesData.addAll(singleton.getListaHabitacionesDisponibles());
        return listHabitacionesData;
    }
    @FXML
    void initialize(){
        colIdHabitacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colTipoHabitacionHabitacion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipo()));
        tableHabitacion.refresh();

        tableHabitacion.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            habitacionSeleccionada = newSelection;
        });
    }

    public boolean verificarCampos(Habitacion habitacion, LocalDate i, LocalDate s){
        if(habitacion==null){
            return false;
        }
        if (i==null){
            return false;
        }
        if (s==null){
            return false;
        }
        return true;
    }
}
