package com.example.proyecto_m067;

import com.example.proyecto_m067.Database.DatabaseMethodsMongo;
import com.example.proyecto_m067.Database.DatabaseMethods_SQL;
import com.example.proyecto_m067.Database.DatabasePadre;

public class Variables {
    public static Constants aHacer=Constants.INSERT;
    public static TableConstants tablaSeleccionada=TableConstants.MOVIE;
    public static DatabaseSelectedConstant databaseSelected=null;
    public static DatabasePadre databasePadre=null;
    public static final String uri="jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass";

    public static DatabaseMethods_SQL databaseSQL=new DatabaseMethods_SQL();
    public static DatabaseMethodsMongo databaseMongo=new DatabaseMethodsMongo();
}
