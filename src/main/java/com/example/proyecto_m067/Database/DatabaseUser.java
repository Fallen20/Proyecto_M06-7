package com.example.proyecto_m067.Database;

import java.sql.*;

import static com.example.proyecto_m067.Variables.uri;

public class DatabaseUser {
    public boolean checkUser(String username, String password) {

        try(Connection conn = DriverManager.getConnection(uri)){

            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM users");
            //buscamos todos los users en la base de datos

            while (resultSet.next()) {
                //miramos si de los resultados coinciden user y pass
                if(username.equals(resultSet.getString("username"))
                    && password.equals(resultSet.getString("password"))){
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean insertUser(String username, String password) {
        try(Connection conn = DriverManager.getConnection(uri)){
            //comprobar que todos los datos estan completos
            if(
                    (!username.equalsIgnoreCase("") || username!=null)
                    &&(!password.equalsIgnoreCase("") || password!=null)
            ){
                PreparedStatement statement = conn.prepareStatement("INSERT INTO users(username, password) VALUES(?,?)");

                statement.setString(1, username);
                statement.setString(2, password);

                statement.executeUpdate();//hace el statement
            }
            return true;

        } catch (SQLException e) {e.printStackTrace();}
        return false;

    }

}
