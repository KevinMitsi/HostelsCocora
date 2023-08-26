package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InicioSesionViewController {
    public ImageView imgCocora;
    public TextField tfName;
    public PasswordField tfPassword;
    public Button btnLogin;
    public Button btnSignup;
    HelloApplication main;

    public void setMain(HelloApplication helloApplication) {
        this.main=helloApplication;
    }


    public void onLoginButtonClick(ActionEvent actionEvent) {
    }

    public void onSgnupButtonClick(ActionEvent actionEvent) {
    }
}
