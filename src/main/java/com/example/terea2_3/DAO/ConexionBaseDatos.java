package com.example.terea2_3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    public static Connection connection = null ;
    public static Connection getConnection() {

        String dbName = "Compañia";
        String dbPort = "5432";
        String dbUser = "odoo";
        String dbPass = "odoo";

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:" + dbPort + "/" + dbName + "?user=" + dbUser + "&password=" + dbPass;
            //Conseguir direccion de conexion fisica
            connection = DriverManager.getConnection(url, dbName, dbPass);

        } catch (ClassNotFoundException | SQLException i) {
            i.printStackTrace();
            System.exit(-1);

        }

        return connection;
    }

}
