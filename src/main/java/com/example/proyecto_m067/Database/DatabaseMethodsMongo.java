package com.example.proyecto_m067.Database;

import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseMethodsMongo extends DatabasePadre {

    private boolean succesfull=false;
    private final String uri="mongodb://localhost";
    static MongoDatabase database;

    @Override
    public boolean insertPelicula(String title, String sinopsis) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");


            org.bson.Document doca=new org.bson.Document();

            doca.append("title", title);

            if(!sinopsis.equalsIgnoreCase("")){//si no es nulo
                doca.append("synopsis", sinopsis);
            }
            database.getCollection("movies").insertOne(doca);

            succesfull=true;
        }

        return succesfull;

    }

    @Override
    public Stream<Pelicula> generalConsultPelicula() {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            final List<Pelicula> peliculaList = new ArrayList<>();

            database.getCollection("movies").find().forEach((Block<? super org.bson.Document>) d -> {
                Pelicula pelicula = new Pelicula(d.getObjectId("_id"),d.getString("title"), d.getString("synopsis"));
                //el id ha de ser objectID pero en sql lo usas como string
                peliculaList.add(pelicula);

            });

            return peliculaList.stream();
        }


    }

    @Override
    public Stream<Pelicula> specificSearchPelicula(String title) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            final List<Pelicula> peliculaList = new ArrayList<>();

            database.getCollection("movies").find(eq("title", title)).forEach((Block<? super org.bson.Document>) d -> {
                Pelicula pelicula = new Pelicula(d.getObjectId("_id"),d.getString("title"), d.getString("synopsis"));
                peliculaList.add(pelicula);

            });

            return peliculaList.stream();

        }

    }

    @Override
    public boolean specificDeletePelicula(String title) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            database.getCollection("movies").deleteMany(Filters.eq("title", title));

            succesfull=true;
        }
        return succesfull;
    }

    @Override
    public boolean deleteTableDataPelicula() {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            database.getCollection("movies").deleteMany(new org.bson.Document());
            succesfull=true;
        }
        return succesfull;
    }

    //-------------------------------------------
    //ACTOR

    @Override
    public boolean insertActor(String name, int age) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            org.bson.Document doc = new org.bson.Document();
            doc.append("name_actor", name);
            doc.append("age", age);

            database.getCollection("actors").insertOne(doc);
            succesfull=true;
        }
        return succesfull;
    }

    @Override
    public Stream<Actor> generalConsultActor() {

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            final List<Actor> actorList = new ArrayList<>();

            database.getCollection("actors").find().forEach((Block<? super org.bson.Document>) d -> {
                Actor actor = new Actor(d.getObjectId("actor_id"),d.getString("name_actor"), d.getInteger("age"));
                //el id ha de ser objectID pero en sql lo usas como string
                actorList.add(actor);

            });

            return actorList.stream();
        }
    }

    @Override
    public Stream<Actor> specificSearchActor(String name) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            final List<Actor> actorList = new ArrayList<>();

            database.getCollection("actors").find(eq("name_actor", name)).forEach((Block<? super org.bson.Document>) d -> {
                Actor actor = new Actor(d.getObjectId("actor_id"),d.getString("name_actor"), d.getInteger("age"));
                actorList.add(actor);

            });

            return actorList.stream();

        }
    }

    @Override
    public boolean specificDeleteActor(String name) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            database.getCollection("actors").deleteMany(Filters.eq("name_actor", name));
            succesfull=true;
        }
        return succesfull;

    }

    @Override
    public boolean deleteTableDataActor() {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("sampledb");

            database.getCollection("actors").deleteMany(new Document());
            succesfull=true;
        }
        return succesfull;

    }

}
