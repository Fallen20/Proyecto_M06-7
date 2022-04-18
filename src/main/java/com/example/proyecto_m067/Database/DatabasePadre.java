package com.example.proyecto_m067.Database;


import java.util.stream.Stream;

public abstract class DatabasePadre {
    abstract boolean insertPelicula(String title, String sinopsis);
    abstract Stream<Pelicula> generalConsultPelicula();
    abstract Stream<Pelicula> specificSearchPelicula(String title);
    abstract boolean specificDeletePelicula(String title);
    abstract boolean deleteTableDataPelicula();

    abstract boolean insertActor(String name, int age);
    abstract Stream<Actor> generalConsultActor();
    abstract Stream<Actor> specificSearchActor(String name);
    abstract boolean specificDeleteActor(String name);
    abstract boolean deleteTableDataActor();

}
