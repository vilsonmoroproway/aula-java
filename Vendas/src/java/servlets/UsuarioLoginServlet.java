/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import modelos.Usuario;

/**
 *
 * @author aluno
 */
@WebServlet("/login_usuario")
public class UsuarioLoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String senha = req.getParameter("senha");
       
        UsuarioDao userDao = new UsuarioDao();
        Usuario user = userDao.login(email, senha);
        
        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", user);

            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{
            resp.sendRedirect(req.getContextPath()+"/login.jsp?erro=1");
        }
        
    }
    
}
