//Nome da dupla:
//Kaueh Farias Ferreira dos Santos - CB3031438
// Lucas da Silva Santos - CB3030598

package com.crud;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/")
public class LivroServlet extends HttpServlet {

    LivroDAO dao = new LivroDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        try {

            if (acao == null) {

                listar(request, response);

            } else if (acao.equals("novo")) {

                RequestDispatcher rd = request.getRequestDispatcher("formulario.jsp");
                rd.forward(request, response);

            } else if (acao.equals("inserir")) {

                inserir(request, response);

            } else if (acao.equals("editar")) {

                editar(request, response);

            } else if (acao.equals("atualizar")) {

                atualizar(request, response);

            } else if (acao.equals("excluir")) {

                excluir(request, response);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Livro> lista = dao.listar();

        request.setAttribute("lista", lista);

        RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");

        rd.forward(request, response);
    }

    private void inserir(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        double preco = Double.parseDouble(request.getParameter("preco"));

        Livro livro = new Livro(titulo, autor, preco);

        dao.inserir(livro);

        response.sendRedirect("?");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        Livro livro = dao.buscar(id);

        request.setAttribute("livro", livro);

        RequestDispatcher rd = request.getRequestDispatcher("formulario.jsp");

        rd.forward(request, response);
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        double preco = Double.parseDouble(request.getParameter("preco"));

        Livro livro = new Livro(id, titulo, autor, preco);

        dao.atualizar(livro);

        response.sendRedirect("?");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        dao.excluir(id);

        response.sendRedirect("?");
    }
}
