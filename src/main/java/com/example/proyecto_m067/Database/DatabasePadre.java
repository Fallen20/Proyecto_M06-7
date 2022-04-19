package com.example.proyecto_m067.Database;


import java.util.stream.Stream;

public abstract class DatabasePadre {
    public abstract boolean insertPelicula(String title, String sinopsis);
    public abstract Stream<Pelicula> generalConsultPelicula();
    public abstract Stream<Pelicula> specificSearchPelicula(String title);
    public abstract boolean specificDeletePelicula(String title);
    public abstract boolean deleteTableDataPelicula();

    public abstract boolean insertActor(String name, int age);
    public abstract Stream<Actor> generalConsultActor();
    public abstract Stream<Actor> specificSearchActor(String name);
    public abstract boolean specificDeleteActor(String name);
    public abstract boolean deleteTableDataActor();

}
