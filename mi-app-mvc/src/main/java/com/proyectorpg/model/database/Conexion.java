package com.proyectorpg.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Ajusta estos valores según tu configuración local
    private static final String URL = "jdbc:mysql://localhost:3306/JuegoRPG";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Andres1804";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conexion;
    }
}