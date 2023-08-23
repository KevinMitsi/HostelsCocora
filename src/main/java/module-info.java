module com.example.hostelscocora {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.example.hostelscocora to javafx.fxml;
    exports com.example.hostelscocora;

    opens com.example.hostelscocora.Controllers to javafx.fxml;
    exports com.example.hostelscocora.Controllers;

}