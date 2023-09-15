package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String url = "jdbc:postgresql://localhost/dbDesafio";
    private static final String user = "postgres";
    private static final String password = "58235718";

    public static Connection connection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
            } else {
                System.out.println("Falha na conexão com o servidor");
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

