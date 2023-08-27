package com.example.hostelscocora;

import com.example.hostelscocora.Controllers.HelloController;
import com.example.hostelscocora.Controllers.InicioAdministratorViewController;
import com.example.hostelscocora.Controllers.InicioSesionViewController;
import com.example.hostelscocora.Controllers.RegistrarCuentaViewController;
import com.example.hostelscocora.Model.Cliente;
import com.example.hostelscocora.Model.Empleado;
import com.example.hostelscocora.Model.Hostal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    Hostal hostal = new Hostal("Hostels Cocora", "Enalgun lugar");
        private Stage stage;

   @Override
    public void start(Stage stage) throws IOException {
       this.stage=stage;
       inicializarLogin();
    }

    public void inicializarLogin() throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicioSesionView.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
       InicioSesionViewController controller = fxmlLoader.getController();
       controller.setMain(this);
       scene.getStylesheets().clear();
       scene.setFill(Color.TRANSPARENT);
       stage.setScene(scene);
       stage.setTitle("Inicio Sesión Hostels Cocora");
       stage.setResizable(false);
       stage.show();
    }
    public void abrirPanelEmpleado(Empleado empleadoLogeado) {

    }

    public void abrirPanelCliente(Cliente clienteLogeado) {

    }
    public void abrirPanelAdministrador() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicioAdministradorView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        InicioAdministratorViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Pagina administrador");
        stage.setResizable(false);
        stage.show();
    }
    public void abrirRegistro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registrarCuentaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        RegistrarCuentaViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Registrate");
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }



}