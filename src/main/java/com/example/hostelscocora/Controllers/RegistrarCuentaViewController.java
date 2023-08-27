package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Cliente;
import com.example.hostelscocora.Model.TipoUsuario;
import com.example.hostelscocora.Model.Usuario;
import com.example.hostelscocora.Persistencia.Persistencia;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrarCuentaViewController {
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    HelloApplication main;
    public Button btnBack;
    public Button btnSignup;
     public TextField tfPassword;
    public TextField tfUsername;
    public TextField tfId;
    public TextField tfName;

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        main.inicializarLogin();
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
                main.inicializarLogin();
            } catch (Exception e) {
                Alerta.saltarAlertaError(e.getMessage());
            }
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
}
