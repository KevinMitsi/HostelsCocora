package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.TipoUsuario;
import com.example.hostelscocora.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CrearEmpleadoViewController {

    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField pwdContrasena;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfUsername;

    @FXML
    void onRegistrarButton(ActionEvent event) {
        String nombre = tfName.getText();
        String id = tfId.getText();
        String username = tfUsername.getText();
        String password= pwdContrasena.getText();
        if(verificarCampos(nombre,password,username,id)){
            try{
               Usuario usuario = singleton.crearUsuario(username,password, TipoUsuario.EMPLEADO);
                singleton.crearEmpleado(nombre,id, usuario);
                singleton.guardarResourceXML();
                singleton.guardarResourceBinario();
                Alerta.saltarAlertaConfirmacion("Empleado creado correctamente");
                singleton.guardarResourceXML();
                main.abrirPanelAdministrador();
            } catch (Exception e) {
                Alerta.saltarAlertaError(e.getMessage());;
            }
        }
        else {
            Alerta.saltarAlertaError("VERIFIQUE LOS CAMPOS");
        }
    }

    @FXML
    void onVolverButtonClick(ActionEvent event) throws IOException {
        main.abrirPanelAdministrador();
    }

    private boolean verificarCampos(String nombre, String password, String username, String id) {
        if (nombre.isBlank()){
            return false;
        }
        if (password.isBlank()){
            return false;
        }
        if(username.isBlank()){
            return false;
        }
        if(id.isBlank()){
            return false;
        }
        return true;
    }

    public void setMain(HelloApplication helloApplication) {
        this.main= helloApplication;
    }
}
