//Nome da dupla:
//Kaueh Farias Ferreira dos Santos - CB3031438
// Lucas da Silva Santos - CB3030598

package com.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void inserir(Livro livro) {

        try {

            Connection con = Conexao.conectar();

            String sql = "INSERT INTO livro(titulo,autor,preco) VALUES(?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setDouble(3, livro.getPreco());

            stmt.execute();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<Livro> listar() {

        List<Livro> lista = new ArrayList<>();

        try {

            Connection con = Conexao.conectar();

            String sql = "SELECT * FROM livro";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("preco")
                );

                lista.add(livro);
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }

    public Livro buscar(int id) {

        Livro livro = null;

        try {

            Connection con = Conexao.conectar();

            String sql = "SELECT * FROM livro WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("preco")
                );
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return livro;
    }

    public void atualizar(Livro livro) {

        try {

            Connection con = Conexao.conectar();

            String sql = "UPDATE livro SET titulo=?, autor=?, preco=? WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setDouble(3, livro.getPreco());
            stmt.setInt(4, livro.getId());

            stmt.execute();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        try {

            Connection con = Conexao.conectar();

            String sql = "DELETE FROM livro WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
