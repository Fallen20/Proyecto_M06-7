package com.example.proyecto_m067.Controllers;

import com.example.proyecto_m067.Database.DatabaseMethodsMongo;
import com.example.proyecto_m067.Database.DatabaseMethods_SQL;
import com.example.proyecto_m067.DatabaseSelectedConstant;
import com.example.proyecto_m067.OpenApplication;
import com.example.proyecto_m067.Variables;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SelectDBController {
    @FXML
    public Pane paneIzq;

    @FXML
    public Pane paneDer;
    
    public static String insertSceneCode;



    public void selectedSQL(){

        Variables.databasePadre=new DatabaseMethods_SQL();
        Variables.databaseSelected= DatabaseSelectedConstant.SQL;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Movies_Insert_SQL.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 840, 530);
            OpenApplication.stageOriginal.setTitle("SQL database");

            OpenApplication.stageOriginal.setMaxHeight(530);
            OpenApplication.stageOriginal.setMaxWidth(840);

            //scene.getStylesheets().add(getClass().getResource("CSS/databaseBase.css").toExternalForm());

            insertSceneCode =scene.toString();
            OpenApplication.stageOriginal.setScene(scene);
            OpenApplication.stageOriginal.show();
        } catch (IOException e) {e.printStackTrace();}


    }

    public void selectedMango(){
        Variables.databasePadre=new DatabaseMethodsMongo();
        Variables.databaseSelected= DatabaseSelectedConstant.MONGO;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Movies_Insert_SQL.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 840, 530);
            OpenApplication.stageOriginal.setTitle("Mongo database");

            OpenApplication.stageOriginal.setMaxHeight(530);
            OpenApplication.stageOriginal.setMaxWidth(840);

            OpenApplication.stageOriginal.setScene(scene);
            OpenApplication.stageOriginal.show();
        } catch (IOException e) {e.printStackTrace();}
    }
}