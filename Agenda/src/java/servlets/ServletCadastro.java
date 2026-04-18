/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dao.ContatoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelos.Contato;

/**
 *
 * @author aluno
 */
@WebServlet("/cadastro_pessoa")
public class ServletCadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nome = req.getParameter("nome");
       String email = req.getParameter("email");
       
       
       if(nome == null || nome.isEmpty() || email == null || email.isEmpty()){
          req.setAttribute("Erro", "Todos os campos são obrigatórios");
        
          RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
          dispatcher.forward(req, resp);
          return;
       }
       
       Contato contato = new Contato();
       contato.setNome(nome);
       contato.setEmail(email);
       
       String idContato = req.getParameter("id");
       if(idContato != null){
          contato.setId(Integer.parseInt(idContato));
          ContatoDao.update(contato);
          req.setAttribute("msg", "Contato alterado com sucesso"); 
       }
       else{
          ContatoDao.salvar(contato);
          req.setAttribute("msg", "Contato cadastrado com sucesso");
       }
        
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("sucesso.jsp");
        dispatcher.forward(req, resp);
      
    }
    
    
    
}
