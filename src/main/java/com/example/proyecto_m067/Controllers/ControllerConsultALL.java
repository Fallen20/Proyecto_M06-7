package com.example.proyecto_m067.Controllers;

import com.example.proyecto_m067.DatabaseSelectedConstant;
import com.example.proyecto_m067.TableConstants;
import com.example.proyecto_m067.Variables;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.proyecto_m067.Variables.databaseMongo;
import static com.example.proyecto_m067.Variables.databaseSQL;

public class ControllerConsultALL implements Initializable{

    @FXML
    public ListView listaConsultALL=new ListView();

    @FXML
    public Text cantidadResult;

    @FXML
    public Button closeResultButton;

    public int cantidad=0;

    public void recuperarDatosConsult() {

        if(Variables.tablaSeleccionada == TableConstants.MOVIE){
            listaConsultALL.getItems().add("ID\t\tTitle\t\tSynopsis");
            databaseSQL.generalConsultPelicula().forEach(result -> {
                //ponerlos
                listaConsultALL.getItems().add(result.getIdSQL() + "\t\t" + result.getTitle() + "\t" + result.getSynopsis());
                cantidad++;
            });
        }
        else if(Variables.tablaSeleccionada == TableConstants.ACTOR) {
            listaConsultALL.getItems().add("ID\t\tName\t\tAge");
            databaseSQL.generalConsultActor().forEach(result -> {
                //ponerlos
                listaConsultALL.getItems().add(result.getIdSQL() + "\t\t" + result.getName_actor() + "\t\t\t" + result.getAge());
                cantidad++;
            });
        }
        cantidadResult.setText(String.valueOf(cantidad));


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void closeStage(){
        Controller_CambiosScene.stageVentana2.close();
    }
}
