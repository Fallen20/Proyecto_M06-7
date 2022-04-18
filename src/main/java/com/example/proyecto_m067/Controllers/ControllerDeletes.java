package com.example.proyecto_m067.Controllers;

import com.example.proyecto_m067.Constants;
import com.example.proyecto_m067.DatabaseSelectedConstant;
import com.example.proyecto_m067.TableConstants;
import com.example.proyecto_m067.Variables;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.proyecto_m067.Variables.databaseMongo;
import static com.example.proyecto_m067.Variables.databaseSQL;

public class ControllerDeletes implements Initializable{

    public String recup;

    @FXML
    public Text resultadosDelete=new Text();


    public void recuperarDatos(String nombre){
        boolean succesful=false;

        if(Variables.databaseSelected== DatabaseSelectedConstant.SQL){
            if(Variables.aHacer== Constants.DELETE_ALL){
                if(Variables.tablaSeleccionada == TableConstants.MOVIE){succesful=databaseSQL.deleteTableDataPelicula();}
                if(Variables.tablaSeleccionada == TableConstants.ACTOR){succesful=databaseSQL.deleteTableDataActor();}
            }
            else{
                //ver si no es nulo
                if(nombre==null || nombre.equals("")){
                    resultadosDelete.setText("Can\'t delete when the field is null ");
                }
                else{
                    //mirar la tabla que tienes
                    //miras que metodo has de hacer
                    if(Variables.tablaSeleccionada == TableConstants.MOVIE){
                        //llamar al metodo
                        succesful=databaseSQL.specificDeletePelicula(nombre);

                    }
                    else if(Variables.tablaSeleccionada == TableConstants.ACTOR){
                        //llamar al metodo
                        succesful=databaseSQL.specificDeleteActor(nombre);
                    }
                }
                if(succesful==true){resultadosDelete.setText("Deleted succesful");}
                else{resultadosDelete.setText("Something went wrong");}
            }
        }

        //--------------
        if(Variables.databaseSelected== DatabaseSelectedConstant.MONGO){
            if(Variables.aHacer== Constants.DELETE_ALL){
                if(Variables.tablaSeleccionada == TableConstants.MOVIE){succesful=databaseMongo.deleteTableDataPelicula();}
                if(Variables.tablaSeleccionada == TableConstants.ACTOR){succesful=databaseMongo.deleteTableDataActor();}
            }
            else{
                //ver si no es nulo
                if(nombre==null || nombre.equals("")){
                    resultadosDelete.setText("Can\'t delete when the field is null ");
                }
                else{
                    //mirar la tabla que tienes
                    //miras que metodo has de hacer
                    if(Variables.tablaSeleccionada == TableConstants.MOVIE){
                        //llamar al metodo
                        succesful=databaseMongo.specificDeletePelicula(nombre);

                    }
                    else if(Variables.tablaSeleccionada == TableConstants.ACTOR){
                        //llamar al metodo
                        succesful=databaseMongo.specificDeleteActor(nombre);
                    }
                }
                if(succesful==true){resultadosDelete.setText("Deleted succesful");}
                else{resultadosDelete.setText("Something went wrong");}
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void closeStage(){
        Controller_CambiosScene.stageVentana2.close();
    }
}
