//Nome da dupla:
//Kaueh Farias Ferreira dos Santos - CB3031438
// Lucas da Silva Santos - CB3030598

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
