module com.example.proyecto_m067 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires mongo.java.driver;
    requires java.sql;

    opens com.example.proyecto_m067 to javafx.fxml;
    exports com.example.proyecto_m067;
    exports com.example.proyecto_m067.Controllers;
    opens com.example.proyecto_m067.Controllers to javafx.fxml;
}