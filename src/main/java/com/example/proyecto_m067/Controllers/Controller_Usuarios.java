package com.example.proyecto_m067.Controllers;

import com.example.proyecto_m067.Database.DatabaseUser;
import com.example.proyecto_m067.OpenApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller_Usuarios {

    static DatabaseUser databaseUser=new DatabaseUser();

    @FXML
    public TextField usernameLogin;

    @FXML
    public PasswordField passLogin;

    @FXML
    public Button loginButton;

    //-----------------------

    @FXML
    public TextField usernameCreate;

    @FXML
    public PasswordField passCreate;

    @FXML
    public Button createUserButton;


    ///----------------
    public void login(){
        String username=usernameLogin.getText();
        String password= passLogin.getText();

        if(databaseUser.checkUser(username, password)){//es correcto, logea

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("selectDatabaseScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("Select a database");

                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);

                OpenApplication.stageOriginal.setScene(scene);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}

        }
        else{
            usernameLogin.setText("ERROR");
            passLogin.setText("ERROR");
        }

    }


    public void createUser(){
        System.out.println(usernameCreate==null);//es nulo >:(

        String username=usernameCreate.getText();
        String password=passCreate.getText();

        if(databaseUser.insertUser(username, password)){//es correcto, logea

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("selectDatabaseScene.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("Select a database");

                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);

                OpenApplication.stageOriginal.setScene(scene);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}

        }
        else{
            usernameCreate.setText("ERROR");
            passCreate.setText("ERROR");
        }

    }
}
