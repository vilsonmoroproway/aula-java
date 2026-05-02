/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dao.ProdutoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import modelos.Produto;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    /* Produto p1 = new Produto("Milho", 10.5, java.sql.Date.valueOf("2026-05-02"));
   Produto p2 = new Produto("Farinha", 10.5, java.sql.Date.valueOf("2026-06-02"));
   Produto p3 = new Produto("Trigo", 10.5, java.sql.Date.valueOf("2026-07-02"));
   
   List<Produto> listaProdutos = List.of(p1, p2, p3);*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if (acao == null) {
            List<Produto> listaProdutos = new ProdutoDao().consultar();
            req.setAttribute("produtos", listaProdutos);
            req.getRequestDispatcher("consulta_produtos.jsp").forward(req, resp);
        } else {
           if(acao.equals("excluir")) {
              String idProduto = req.getParameter("id");
              new ProdutoDao().delete(Long.parseLong(idProduto)); 
           }
        }
       req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        Double preco = Double.parseDouble(req.getParameter("preco"));
        String validade = req.getParameter("validade");

        Produto produto = new Produto(nome, preco, java.sql.Date.valueOf(validade));

        new ProdutoDao().salvar(produto);

        doGet(req, resp);
    }
}
