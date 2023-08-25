package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    HelloApplication main;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void setMain(HelloApplication helloApplication) {
        this.main = helloApplication;
    }
}