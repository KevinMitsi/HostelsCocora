package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import com.example.hostelscocora.Model.Cliente;
import com.example.hostelscocora.Model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class InicioSesionViewController {
    public ComboBox cbOpciones;
    ModelFactoryController singleton = ModelFactoryController.getInstance();
    public ImageView imgCocora;
    public TextField tfName;
    public PasswordField tfPassword;
    public Button btnLogin;
    public Button btnSignup;
    HelloApplication main;

    public void setMain(HelloApplication helloApplication) {
        this.main=helloApplication;
    }


    public void onLoginButtonClick(ActionEvent actionEvent) throws Exception {
        String nombre = tfName.getText();
        String password = tfPassword.getText();
        if(verificarCampos(nombre, password, cbOpciones.getValue())){
            if(cbOpciones.getValue().equals("Empleado")){
              try{
                  Empleado empleadoLogeado = singleton.iniciarSesionEmpleado(nombre,password);
                  main.abrirPanelEmpleado(empleadoLogeado);
              } catch (Exception e) {
                  Alerta.saltarAlertaError(e.getMessage());
              }
            }
            if(cbOpciones.getValue().equals("Cliente")){
                try{
                    Cliente clienteLogeado = singleton.iniciarSesionCliente(nombre,password);
                    main.abrirPanelCliente(clienteLogeado);
                } catch (Exception e) {
                    Alerta.saltarAlertaError(e.getMessage());
                }
            }
            if(nombre.equals("admin")&&password.equals("admin123")&&cbOpciones.getValue().equals("Empleado")){
                main.abrirPanelAdministrador();
            }
        }
        else {
            Alerta.saltarAlertaError("VERIFIQUE LOS CAMPOS");
        }
    }



    public void onSgnupButtonClick(ActionEvent actionEvent) throws IOException {
        main.abrirRegistro();
    }

    private boolean verificarCampos(String nombre, String password, Object value) {
        if (nombre.isBlank()){
            return false;
        }
        if (password.isBlank()){
            return false;
        }
        if(value==null){
            return false;
        }
        return true;
    }
    @FXML
    void initialize() {
        cbOpciones.getItems().add("Empleado");
        cbOpciones.getItems().add("Cliente");
    }

}
