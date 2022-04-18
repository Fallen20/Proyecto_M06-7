package com.example.proyecto_m067.Controllers;

import com.example.proyecto_m067.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_CambiosScene {

    Scene sceneOriginal;
    static Stage stageVentana2=new Stage();

    //llamar a las cosas de las escenas

    @FXML
    public Button botonConsulta;

    @FXML
    public Button botonErase;


    //    ---------------
//    MOVIES
    @FXML
    public TextField deleteTitle;

    @FXML
    public TextField titleInsertSQL;
    @FXML
    public TextField synopsisInsertSQL;

    @FXML
    public TextField consultSQLMovies;
//    -----------------
//    ACTOR

    @FXML
    public  TextField deleteTitleActor;

    @FXML
    public  TextField ageInsertSQL;

    @FXML
    public  TextField nameInsertSQL;

    @FXML
    public  TextField consultSQLAuthor;



    //------
    //actor
    public void selectedActors(){
        Variables.tablaSeleccionada= TableConstants.ACTOR;

        if(Variables.aHacer==null){
            try {
                FXMLLoader fxmlLoaderInsert2 = new FXMLLoader(OpenApplication.class.getResource("Actor_Insert_SQL.fxml"));
                sceneOriginal = new Scene(fxmlLoaderInsert2.load(), 840, 530);

                OpenApplication.stageOriginal.setTitle("SQL database");
                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();

                Variables.aHacer=Constants.INSERT;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            if(Variables.aHacer == Constants.INSERT){
                try {
                    FXMLLoader fxmlLoaderInsert2 = new FXMLLoader(OpenApplication.class.getResource("Actor_Insert_SQL.fxml"));
                    sceneOriginal = new Scene(fxmlLoaderInsert2.load(), 840, 530);

                    OpenApplication.stageOriginal.setTitle("SQL database");
                    OpenApplication.stageOriginal.setScene(sceneOriginal);
                    OpenApplication.stageOriginal.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(Variables.aHacer == Constants.DELETE_ONE){
                //abrir la ventana

                try {
                    FXMLLoader fxmlLoaderDelete = new FXMLLoader(OpenApplication.class.getResource("Actor_Delete.fxml"));
                    sceneOriginal = new Scene(fxmlLoaderDelete.load(), 840, 530);

                    OpenApplication.stageOriginal.setTitle("SQL database");
                    OpenApplication.stageOriginal.setScene(sceneOriginal);
                    OpenApplication.stageOriginal.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(Variables.aHacer == Constants.DELETE_ALL){
                //abrir la ventana

                try {
                    FXMLLoader fxmlLoaderDelete = new FXMLLoader(OpenApplication.class.getResource("DeleteALL_SQL.fxml"));
                    sceneOriginal = new Scene(fxmlLoaderDelete.load(), 840, 530);

                    OpenApplication.stageOriginal.setTitle("SQL database");
                    OpenApplication.stageOriginal.setScene(sceneOriginal);
                    OpenApplication.stageOriginal.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if(Variables.aHacer == Constants.CONSULT_ALL){
                try {
                    FXMLLoader fxmlLoaderConsult1 = new FXMLLoader(OpenApplication.class.getResource("ConsultALL_SQL.fxml"));
                    sceneOriginal = new Scene(fxmlLoaderConsult1.load(), 840, 530);

                    OpenApplication.stageOriginal.setTitle("SQL database");
                    OpenApplication.stageOriginal.setScene(sceneOriginal);
                    OpenApplication.stageOriginal.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(Variables.aHacer == Constants.CONSULT_ONE){
                try {
                    FXMLLoader fxmlLoaderConsult1 = new FXMLLoader(OpenApplication.class.getResource("Actor_ConsultONE.fxml"));
                    sceneOriginal = new Scene(fxmlLoaderConsult1.load(), 840, 530);
                    OpenApplication.stageOriginal.setTitle("SQL database");
                    OpenApplication.stageOriginal.setScene(sceneOriginal);
                    OpenApplication.stageOriginal.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }


    //-----
    //Movie
    public void selectedMovies(){

        Variables.tablaSeleccionada=TableConstants.MOVIE;

        if(Variables.aHacer == Constants.INSERT || Variables.aHacer==null){
            try {
                FXMLLoader fxmlLoaderInsert2 = new FXMLLoader(OpenApplication.class.getResource("Movies_Insert_SQL.fxml"));
                 sceneOriginal = new Scene(fxmlLoaderInsert2.load(), 840, 530);

                OpenApplication.stageOriginal.setTitle("SQL database");
                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Variables.aHacer == Constants.DELETE_ONE){
            //abrir la ventana

            try {
                FXMLLoader fxmlLoaderDelete = new FXMLLoader(OpenApplication.class.getResource("Movies_Delete.fxml"));
                 sceneOriginal = new Scene(fxmlLoaderDelete.load(), 840, 530);

                OpenApplication.stageOriginal.setTitle("SQL database");
                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Variables.aHacer == Constants.DELETE_ALL){
            //abrir la ventana

            try {
                FXMLLoader fxmlLoaderDelete = new FXMLLoader(OpenApplication.class.getResource("DeleteALL_SQL.fxml"));
                sceneOriginal = new Scene(fxmlLoaderDelete.load(), 840, 530);

                OpenApplication.stageOriginal.setTitle("SQL database");
                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(Variables.aHacer == Constants.CONSULT_ALL){
            try {
                FXMLLoader fxmlLoaderConsult1 = new FXMLLoader(OpenApplication.class.getResource("ConsultALL_SQL.fxml"));
                sceneOriginal = new Scene(fxmlLoaderConsult1.load(), 840, 530);

                OpenApplication.stageOriginal.setTitle("SQL database");
                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Variables.aHacer == Constants.CONSULT_ONE){
            try {
                FXMLLoader fxmlLoaderConsult1 = new FXMLLoader(OpenApplication.class.getResource("Movies_ConsultONE.fxml"));
                 sceneOriginal = new Scene(fxmlLoaderConsult1.load(), 840, 530);

                OpenApplication.stageOriginal.setTitle("SQL database");
                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    ///-----------------
    //Botones grandes

    public void insertLayoutChange(){

        if(Variables.tablaSeleccionada==TableConstants.MOVIE){

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Movies_Insert_SQL.fxml"));
                sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("SQL database");

                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);
                Variables.aHacer= Constants.INSERT;

                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}
        }

        else if(Variables.tablaSeleccionada==TableConstants.ACTOR){

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Actor_Insert_SQL.fxml"));
                sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("SQL database");

                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);
                Variables.aHacer= Constants.INSERT;

                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}
        }
    }

    public void deleteOneLayoutChange(){

        if(Variables.tablaSeleccionada==TableConstants.ACTOR){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Actor_Delete.fxml"));
                sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("SQL database");

                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);

                Variables.aHacer =Constants.DELETE_ONE;

                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}
        }
        else if(Variables.tablaSeleccionada==TableConstants.MOVIE){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Movies_Delete.fxml"));
                sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("SQL database");

                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);

                Variables.aHacer =Constants.DELETE_ONE;

                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}
        }



    }



    public void deleteAllLayoutChange(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("DeleteALL_SQL.fxml"));
            sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
            OpenApplication.stageOriginal.setTitle("SQL database");

            OpenApplication.stageOriginal.setMaxHeight(530);
            OpenApplication.stageOriginal.setMaxWidth(840);
            Variables.aHacer =Constants.DELETE_ALL;

            OpenApplication.stageOriginal.setScene(sceneOriginal);
            OpenApplication.stageOriginal.show();
        } catch (IOException e) {e.printStackTrace();}
    }



    public void generalConsultLayoutChange(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("ConsultALL_SQL.fxml"));
             sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
            OpenApplication.stageOriginal.setTitle("SQL database");

            OpenApplication.stageOriginal.setMaxHeight(530);
            OpenApplication.stageOriginal.setMaxWidth(840);
            Variables.aHacer =Constants.CONSULT_ALL;

            OpenApplication.stageOriginal.setScene(sceneOriginal);
            OpenApplication.stageOriginal.show();
        } catch (IOException e) {e.printStackTrace();}
    }



    public void specificConsultLayoutChange(){

        if(Variables.tablaSeleccionada==TableConstants.ACTOR){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Actor_ConsultONE.fxml"));
                sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("SQL database");


                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);
                Variables.aHacer =Constants.CONSULT_ONE;

                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}
        }

        else if(Variables.tablaSeleccionada==TableConstants.MOVIE){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(OpenApplication.class.getResource("Movies_ConsultONE.fxml"));
                sceneOriginal = new Scene(fxmlLoader.load(), 840, 530);
                OpenApplication.stageOriginal.setTitle("SQL database");


                OpenApplication.stageOriginal.setMaxHeight(530);
                OpenApplication.stageOriginal.setMaxWidth(840);
                Variables.aHacer =Constants.CONSULT_ONE;

                OpenApplication.stageOriginal.setScene(sceneOriginal);
                OpenApplication.stageOriginal.show();
            } catch (IOException e) {e.printStackTrace();}
        }

    }

    @FXML
    protected void consult(){
        String escenaActual=botonConsulta.getScene().toString();//recupera el nombre ed la escena donde estas


        //abrir nueva ventana u otra dependiendo de lo que haces
        //mostarr resultados en ella
        //la conexion en el metodo
        //se llama al metodo correcto en los if


        if(Variables.aHacer==null){
            if(SelectDBController.insertSceneCode.equals(escenaActual)){
                try {

                    FXMLLoader fxmlLoaderInsert = new FXMLLoader(OpenApplication.class.getResource("results_SQLInsert.fxml"));
                    Scene scene = new Scene(fxmlLoaderInsert.load(), 840, 530);


                    ControllerInsert controllerInsert=fxmlLoaderInsert.getController();
                    if(Variables.tablaSeleccionada==TableConstants.MOVIE){
                        controllerInsert.recuperarDatosInsert(titleInsertSQL.getText(), synopsisInsertSQL.getText(),"0");
                    }
                    else if(Variables.tablaSeleccionada== TableConstants.ACTOR){
                        controllerInsert.recuperarDatosInsert(titleInsertSQL.getText(), synopsisInsertSQL.getText(),ageInsertSQL.getText());
                    }




                    stageVentana2.setTitle("Insert window");
                    stageVentana2.setScene(scene);
                    stageVentana2.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("el metodo a hacer es el de INSERT desde el origen");
            }
        }
        else{
            if(Variables.aHacer == Constants.INSERT){
                try {
                    FXMLLoader fxmlLoaderInsert2 = new FXMLLoader(OpenApplication.class.getResource("results_SQLInsert.fxml"));
                    Scene scene = new Scene(fxmlLoaderInsert2.load(), 840, 530);

                    ControllerInsert controller=fxmlLoaderInsert2.getController();
                    if(Variables.tablaSeleccionada==TableConstants.MOVIE){
                        controller.recuperarDatosInsert(titleInsertSQL.getText(), synopsisInsertSQL.getText(),null);
                    }
                    else if(Variables.tablaSeleccionada== TableConstants.ACTOR){
                        controller.recuperarDatosInsert(nameInsertSQL.getText(), null,ageInsertSQL.getText());
                    }




                    stageVentana2.setTitle("Insert window");
                    stageVentana2.setScene(scene);
                    stageVentana2.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(Variables.aHacer == Constants.DELETE_ONE || Variables.aHacer == Constants.DELETE_ALL){
                //abrir la ventana

                try {
                    Stage stage=new Stage();
                    FXMLLoader fxmlLoaderDelete = new FXMLLoader(OpenApplication.class.getResource("results_Delete.fxml"));
                    Scene scene = new Scene(fxmlLoaderDelete.load(), 840, 530);


                    ControllerDeletes controller=fxmlLoaderDelete.getController();
                    if(Variables.tablaSeleccionada==TableConstants.MOVIE){
                        if(Variables.aHacer==Constants.DELETE_ONE){
                            controller.recuperarDatos(deleteTitle.getText());
                        }
                        else{controller.recuperarDatos("");}
                    }
                    else if(Variables.tablaSeleccionada==TableConstants.ACTOR){
                        if(Variables.aHacer==Constants.DELETE_ONE){
                            controller.recuperarDatos(deleteTitleActor.getText());
                        }
                        else{controller.recuperarDatos("");}

                    }

                    stage.setTitle("Delete window");
                    stage.setScene(scene);
                    stage.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(Variables.aHacer == Constants.CONSULT_ALL){
                try {
                    FXMLLoader fxmlLoaderConsult1 = new FXMLLoader(OpenApplication.class.getResource("results_ConsultALL_SQL_Movies.fxml"));
                    Scene scene = new Scene(fxmlLoaderConsult1.load(), 840, 530);

                    ControllerConsultALL controller=fxmlLoaderConsult1.getController();
                    controller.recuperarDatosConsult();


                    stageVentana2.setTitle("Consult one window");
                    stageVentana2.setScene(scene);
                    stageVentana2.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(Variables.aHacer == Constants.CONSULT_ONE){
                try {
                    FXMLLoader fxmlLoaderConsult1 = new FXMLLoader(OpenApplication.class.getResource("results_ConsultONE_SQL_Movies.fxml"));
                    Scene scene = new Scene(fxmlLoaderConsult1.load(), 840, 530);

                    ControllerConsultONE controller=fxmlLoaderConsult1.getController();
                    if(Variables.tablaSeleccionada==TableConstants.ACTOR){
                        controller.recuperarDatosConsult(consultSQLAuthor.getText());
                    }
                    if(Variables.tablaSeleccionada==TableConstants.MOVIE){
                        controller.recuperarDatosConsult(consultSQLMovies.getText());
                    }


                    stageVentana2.setTitle("Consult one window");
                    stageVentana2.setScene(scene);
                    stageVentana2.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }

//                System.out.println("el metodo a hacer es el de CONSULT1");
            }
        }


    }

    @FXML
    protected void eraseData(){

        //delete
        //actor o movie
        if(Variables.aHacer==Constants.DELETE_ONE){
            if(Variables.tablaSeleccionada==TableConstants.MOVIE){deleteTitle.setText("");}
            if(Variables.tablaSeleccionada==TableConstants.ACTOR){deleteTitleActor.setText("");}
        }

        if(Variables.aHacer==Constants.INSERT){

            if(Variables.tablaSeleccionada==TableConstants.MOVIE){

                synopsisInsertSQL.setText("");
                titleInsertSQL.setText("");
            }
            if(Variables.tablaSeleccionada==TableConstants.ACTOR){
                ageInsertSQL.setText("");
                nameInsertSQL.setText("");
            }
        }

        if(Variables.aHacer==Constants.CONSULT_ONE){
            if(Variables.tablaSeleccionada==TableConstants.MOVIE){consultSQLMovies.setText("");}
            if(Variables.tablaSeleccionada==TableConstants.ACTOR){consultSQLAuthor.setText("");}
        }
    }

}
