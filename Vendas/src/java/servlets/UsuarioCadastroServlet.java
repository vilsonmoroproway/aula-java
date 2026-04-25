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
import java.io.IOException;
import javax.swing.JOptionPane;
import modelos.Usuario;

/**
 *
 * @author aluno
 */
@WebServlet("/cadastro_usuario")
public class UsuarioCadastroServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Usuario user = new Usuario();
        user.setNome(req.getParameter("nome"));
        user.setEmail(req.getParameter("email"));
        user.setSenha(req.getParameter("senha"));
        user.setPerfil(req.getParameter("perfil"));
        
        
        
        try{
           new UsuarioDao().cadastrar(user); 
           resp.sendRedirect("login.jsp");
        }catch(RuntimeException e){
           resp.sendRedirect("cadastroUsuario.jsp?erro=" + e.getMessage());
        }
        
    }
    
}
