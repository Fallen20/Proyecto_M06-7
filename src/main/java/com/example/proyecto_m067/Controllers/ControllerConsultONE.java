package com.example.proyecto_m067.Controllers;

import com.example.proyecto_m067.Database.Actor;
import com.example.proyecto_m067.Database.Pelicula;
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

public class ControllerConsultONE implements Initializable{

    @FXML
    public Text synopsisConsultONE=new Text();
    @FXML
    public Text idConsultONE=new Text();
    @FXML
    public Text titleConsultONE=new Text();

    @FXML
    public Text SynopsisAge;
    @FXML
    public Text TitleName;


    public void recuperarDatosConsult(String nombre){
        //recuperas los datos
        boolean succesful=false;

        if(Variables.tablaSeleccionada == TableConstants.MOVIE) {
            TitleName.setText("Title:");
            SynopsisAge.setText("Synopsis:");
        }
        if(Variables.tablaSeleccionada == TableConstants.ACTOR) {
            TitleName.setText("Name:");
            SynopsisAge.setText("Age:");

        }

        //ver si no es nulo
        if(nombre==null || nombre.equals("")){
            synopsisConsultONE.setText("NULL");
            idConsultONE.setText("NULL");
            titleConsultONE.setText("NULL");
        }
        else{
            if(Variables.tablaSeleccionada == TableConstants.MOVIE) {

                Pelicula pelicula=new Pelicula();
                databaseSQL.specificSearchPelicula(nombre).forEach(result->{
                    //ponerlos
                    pelicula.setIdSQL(result.getIdSQL());
                    pelicula.setTitle(result.getTitle());
                    pelicula.setSynopsis(result.getSynopsis());
                    return;//salir
                });

                if(pelicula.getIdSQL()!=null){idConsultONE.setText(pelicula.getIdSQL());}
                else{idConsultONE.setText("NULL");}

                if(pelicula.getTitle()!=null){titleConsultONE.setText(pelicula.getTitle());}
                else{titleConsultONE.setText("NULL");}

                if(pelicula.getSynopsis()!=null){synopsisConsultONE.setText(pelicula.getSynopsis());}
                else{synopsisConsultONE.setText("NULL");}
            }
            else if(Variables.tablaSeleccionada == TableConstants.ACTOR){

                Actor actor=new Actor();
                databaseSQL.specificSearchActor(nombre).forEach(result->{
                    //ponerlos
                    actor.setIdSQL(result.getIdSQL());
                    actor.setName_actor(result.getName_actor());
                    actor.setAge(result.getAge());
                    return;//salir
                });

                if(actor.getIdSQL()!=null){idConsultONE.setText(actor.getIdSQL());}
                else{idConsultONE.setText("NULL");}

                if(actor.getName_actor()!=null){titleConsultONE.setText(actor.getName_actor());}
                else{titleConsultONE.setText("NULL");}

                synopsisConsultONE.setText(String.valueOf(actor.getAge()));

            }
        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void closeStage(){
        Controller_CambiosScene.stageVentana2.close();
    }
}
