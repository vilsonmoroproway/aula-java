<%-- 
    Document   : index
    Created on : 25 de abr. de 2026, 13:40:07
    Author     : aluno
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Usuario u = (Usuario) session.getAttribute("usuarioLogado");
            if (u != null) {%>          
                 <h1>Bem vindo <%= u.getNome()%></h1>              
         <% } else{%>
            <h1>Ola mundo</h1>
         <%}%>
         
        <hr />

        <%
            if (u != null && u.getPerfil().equals("ADMIN")) {               
        %>
            <a href="cadastroProduto.jsp">Cadastro Produto</a>
        <% } %>

        <a href="consultaProduto.jsp">Consulta Produto</a>
        <a href="cadastroUsuario.jsp">Usuario</a>
        <a href="admin/relatorio.jsp">relatorios</a>
        
        <hr />
        <%
          if (u != null ) {               
        %>
        <form action="logout" method="POST">
                <input type="submit" value="Logout" />
            </form>
        <% } %>
       
    </body>
</html>
