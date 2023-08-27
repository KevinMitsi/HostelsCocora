package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.HelloApplication;

public class IncioEmpleadoViewController {
    HelloApplication main;
    ModelFactoryController singleton = ModelFactoryController.getInstance();






    public void setMain(HelloApplication helloApplication) {
        this.main=helloApplication;
    }
}
