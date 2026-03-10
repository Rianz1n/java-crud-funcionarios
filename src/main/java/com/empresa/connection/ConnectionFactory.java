package com.empresa.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/db_cadastro";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão", e);
        }
    }
}