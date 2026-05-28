package com.crud;

import java.sql.Connection;
import java.sql.Statement;

public class CriarTabela {

    public static void main(String[] args) {

        try {

            Connection con = Conexao.conectar();

            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS livro ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "titulo TEXT,"
                    + "autor TEXT,"
                    + "preco REAL)";

            stmt.execute(sql);

            System.out.println("Tabela criada!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}