package com.example.proyecto_m067;

import com.example.proyecto_m067.Database.DatabasePadre;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenApplication extends Application {
    public static Stage stageOriginal;

    @Override
    public void start(Stage stage) throws IOException {
        stageOriginal=stage;

        FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),450,280);
        stageOriginal.setTitle("Enter your credentials");

        stageOriginal.setMaxHeight(530);
        stageOriginal.setMaxWidth(840);


        scene.getStylesheets().add(getClass().getResource("CSS/inicioStyle.css").toExternalForm());

        stageOriginal.setScene(scene);
        stageOriginal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}