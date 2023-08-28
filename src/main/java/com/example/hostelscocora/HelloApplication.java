package com.example.hostelscocora;

import com.example.hostelscocora.Controllers.*;
import com.example.hostelscocora.Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

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
    public void abrirPanelEmpleado(Empleado empleadoLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("panelEmpleadoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PanelEmpleadoController controller = fxmlLoader.getController();
        controller.setEmpleado(empleadoLogeado);
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Tu inicio empleado");
        stage.setResizable(false);
        stage.show();
    }

    public void abrirPanelCliente(Cliente clienteLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicioClienteView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        InicioClienteViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Tu inicio cliente");
        stage.setResizable(false);
        stage.show();

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
    public void abrirCrearEmpleado() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crearEmpleadoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        CrearEmpleadoViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Crea un empleado");
        stage.setResizable(false);
        stage.show();

    }
    public void abrirCrearProducto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("agregarProductoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AgregarProductoController controller = fxmlLoader.getController();
        controller.setMain(this);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Crea un empleado");
        stage.setResizable(false);
        stage.show();
    }
    public void abrirAmpliarCama(Cama camaSeleccionada, Empleado empleadoLogeado) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ampliacionCamaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AmpliacionCamaViewController controller = fxmlLoader.getController();
        controller.setMain(this);
        controller.setCamaSeleccionada(camaSeleccionada);
        controller.setEmpleadoLoggeado(empleadoLogeado);
        scene.getStylesheets().clear();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Ampliar cama");
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}