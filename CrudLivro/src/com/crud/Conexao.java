package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL =
            "jdbc:sqlite:C:/sqlite/livros.db";

    public static Connection conectar() {

        try {

            Class.forName("org.sqlite.JDBC");

            return DriverManager.getConnection(URL);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}