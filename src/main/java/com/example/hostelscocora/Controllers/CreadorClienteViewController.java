package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Empleado;
import com.example.hostelscocora.Model.TipoUsuario;
import com.example.hostelscocora.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreadorClienteViewController {
    public Button btnSignup;
    public TextField tfPassword;
    public TextField tfUsername;
    public TextField tfId;
    public TextField tfName;
    HelloApplication main;
    ModelFactoryController singleton= ModelFactoryController.getInstance();
    Empleado empleadoLogeado;

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirPanelEmpleado(empleadoLogeado);
    }

    public void onSignupButtonClick(ActionEvent actionEvent) {
        String nombre = tfName.getText();
        String id = tfId.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        if (verificarCampos(nombre,password,username,id)){
            try{
                Usuario usuario=singleton.crearUsuario(username,password, TipoUsuario.CLIENTE);
                singleton.crearCliente(nombre,id,usuario);
                singleton.guardarResourceXML();
                singleton.guardarResourceBinario();
                Alerta.saltarAlertaConfirmacion("Empleado creado correctamente");
                main.inicializarLogin();
            } catch (Exception e) {
                Alerta.saltarAlertaError(e.getMessage());
            }
        }
        else {
            Alerta.saltarAlertaError("VERIFIQUE LOS CAMPOS");
        }
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
        this.main=helloApplication;
    }

    public void setEmpleadoLogeado(Empleado empleadoLogeado) {
        this.empleadoLogeado=empleadoLogeado;
    }
}
