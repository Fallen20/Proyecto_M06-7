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

public class ControllerInsert implements Initializable{

    @FXML
    public Text idSQLInsert=new Text();
    @FXML
    public Text nameSQLInsert=new Text();
    @FXML
    public Text synopsisSQLInsert=new Text();
    @FXML
    public Text resultDataSQLInsert=new Text();

    @FXML
    public Text synopsis_Age=new Text();
    @FXML
    public Text nameTitlePalabra=new Text();




    public void recuperarDatosInsert(String nombre, String  synopsis, String age){
        //recuperas los datos

        if(Variables.tablaSeleccionada == TableConstants.MOVIE){
            nameTitlePalabra.setText("Title:");
            synopsis_Age.setText("Synopsis:");
        }
         else if(Variables.tablaSeleccionada == TableConstants.ACTOR){
            nameTitlePalabra.setText("Name:");
             synopsis_Age.setText("Age:");
         }

        boolean succesful=false;


        if(Variables.databaseSelected== DatabaseSelectedConstant.SQL){
            //ver si no es nulo
            if(Variables.tablaSeleccionada==TableConstants.MOVIE && (nombre==null || nombre.equals(""))){//0 es nulo en int
                resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                resultDataSQLInsert.setText("Something is wrong");

                //poner null a los datos
                idSQLInsert.setText("ERROR");
                nameSQLInsert.setText("ERROR");
                synopsisSQLInsert.setText("ERROR");
            }
            else if(Variables.tablaSeleccionada==TableConstants.ACTOR && (nombre==null || nombre.equals("")) && (age==null || age.equals(""))){
                resultDataSQLInsert.setStyle("fx-text-fill:red;");
                resultDataSQLInsert.setText("Something is wrong");

                //poner null a los datos
                idSQLInsert.setText("ERROR");
                nameSQLInsert.setText("ERROR");
                synopsisSQLInsert.setText("ERROR");
            }
            else{
                resultDataSQLInsert.setStyle("-fx-text-fill: green;");
                resultDataSQLInsert.setText("OK");

                //mirar la database
                if(Variables.tablaSeleccionada == TableConstants.MOVIE){
                    //meter datos
                    succesful=databaseSQL.insertPelicula(nombre,synopsis);


                    //recuperar datos especificos si es correcto
                    if(succesful==true){
                        Pelicula pelicula=new Pelicula();
                        databaseSQL.specificSearchPelicula(nombre).forEach(result->{
                            //ponerlos
                            pelicula.setIdSQL(result.getIdSQL());
                            pelicula.setTitle(result.getTitle());
                            pelicula.setSynopsis(result.getSynopsis());
                            return;//salir
                        });
                        System.out.println(pelicula.getSynopsis());

                        nameSQLInsert.setText(pelicula.getTitle());
                        idSQLInsert.setText(pelicula.getIdSQL());

                        if(synopsis==null || synopsis.equals("")){synopsisSQLInsert.setText("NULL");}
                        else{synopsisSQLInsert.setText(pelicula.getSynopsis());}

                    }
                    else{
                        resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                        resultDataSQLInsert.setText("Something is wrong");
                        idSQLInsert.setText("Database Error");
                        nameSQLInsert.setText("Database Error");
                        synopsisSQLInsert.setText("Database Error");
                    }
                }



                else if(Variables.tablaSeleccionada == TableConstants.ACTOR){
                    //meter datos

                    try {
                        succesful=databaseSQL.insertActor(nombre,Integer.parseInt(age));
                    } catch(NumberFormatException e){
                        resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                        resultDataSQLInsert.setText("Something is wrong");
                        idSQLInsert.setText("ERROR");
                        nameSQLInsert.setText("ERROR");
                        synopsisSQLInsert.setText("ERROR");
                    }



                    //recuperar datos especificos si es correcto
                    if(succesful){
                        Actor actor=new Actor();
                        databaseSQL.specificSearchActor(nombre).forEach(result->{
                            actor.setAge(result.getAge());
                            actor.setIdSQL(result.getIdSQL());
                            actor.setName_actor(result.getName_actor());
                        });

                        idSQLInsert.setText(actor.getIdSQL());
                        nameSQLInsert.setText(actor.getName_actor());
                        synopsisSQLInsert.setText(String.valueOf(actor.getAge()));

                    }
                    else{
                        resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                        resultDataSQLInsert.setText("Something is wrong");
                        idSQLInsert.setText("Database Error");
                        nameSQLInsert.setText("Database Error");
                        synopsisSQLInsert.setText("Database Error");
                    }
                }

            }
        }

        //------------------------------
        if(Variables.databaseSelected== DatabaseSelectedConstant.MONGO){
            //ver si no es nulo
            if(Variables.tablaSeleccionada==TableConstants.MOVIE && (nombre==null || nombre.equals(""))){//0 es nulo en int
                resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                resultDataSQLInsert.setText("Something is wrong");

                //poner null a los datos
                idSQLInsert.setText("ERROR");
                nameSQLInsert.setText("ERROR");
                synopsisSQLInsert.setText("ERROR");
            }
            else if(Variables.tablaSeleccionada==TableConstants.ACTOR && (nombre==null || nombre.equals("")) && (age==null || age.equals(""))){
                resultDataSQLInsert.setStyle("fx-text-fill:red;");
                resultDataSQLInsert.setText("Something is wrong");

                //poner null a los datos
                idSQLInsert.setText("ERROR");
                nameSQLInsert.setText("ERROR");
                synopsisSQLInsert.setText("ERROR");
            }
            else{
                resultDataSQLInsert.setStyle("-fx-text-fill: green;");
                resultDataSQLInsert.setText("OK");

                //mirar la database
                if(Variables.tablaSeleccionada == TableConstants.MOVIE){
                    //meter datos
                    succesful=databaseMongo.insertPelicula(nombre,synopsis);


                    //recuperar datos especificos si es correcto
                    if(succesful==true){
                        Pelicula pelicula=new Pelicula();
                        databaseMongo.specificSearchPelicula(nombre).forEach(result->{
                            //ponerlos
                            pelicula.setIdMongo(result.getIdMongo());
                            pelicula.setTitle(result.getTitle());
                            pelicula.setSynopsis(result.getSynopsis());
                            return;//salir
                        });

                        nameSQLInsert.setText(pelicula.getTitle());
                        idSQLInsert.setText(String.valueOf(pelicula.getIdMongo()));

                        if(synopsis==null || synopsis.equals("")){synopsisSQLInsert.setText("NULL");}
                        else{synopsisSQLInsert.setText(pelicula.getSynopsis());}

                    }
                    else{
                        resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                        resultDataSQLInsert.setText("Something is wrong");
                        idSQLInsert.setText("Database Error");
                        nameSQLInsert.setText("Database Error");
                        synopsisSQLInsert.setText("Database Error");
                    }
                }



                else if(Variables.tablaSeleccionada == TableConstants.ACTOR){
                    //meter datos

                    try {
                        succesful=databaseSQL.insertActor(nombre,Integer.parseInt(age));
                    } catch(NumberFormatException e){
                        resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                        resultDataSQLInsert.setText("Something is wrong");
                        idSQLInsert.setText("ERROR");
                        nameSQLInsert.setText("ERROR");
                        synopsisSQLInsert.setText("ERROR");
                    }



                    //recuperar datos especificos si es correcto
                    if(succesful){
                        Actor actor=new Actor();
                        databaseMongo.specificSearchActor(nombre).forEach(result->{
                            actor.setAge(result.getAge());
                            actor.setIdMongo(result.getIdMongo());
                            actor.setName_actor(result.getName_actor());
                            return;
                        });



                        idSQLInsert.setText(String.valueOf(actor.getIdMongo()));
                        nameSQLInsert.setText(actor.getName_actor());
                        synopsisSQLInsert.setText(String.valueOf(actor.getAge()));

                    }
                    else{
                        resultDataSQLInsert.setStyle("-fx-text-fill: red;");
                        resultDataSQLInsert.setText("Something is wrong");
                        idSQLInsert.setText("Database Error");
                        nameSQLInsert.setText("Database Error");
                        synopsisSQLInsert.setText("Database Error");
                    }
                }

            }
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void closeStage(){
        Controller_CambiosScene.stageVentana2.close();
    }
}
