<%-- 
    Document   : index
    Created on : 25 de abr. de 2026, 13:40:07
    Author     : aluno
--%>

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
          if(u != null){%>          
              <h1>Bem vindo <%= u.getNome()%></h1>              
         <% } %>
                  
       <hr />
        <a href="cadastroProduto.jsp">Cadastro Produto</a>
        <a href="consultaProduto.jsp">Consulta Produto</a>
        <a href="cadastroUsuario.jsp">Usuario</a>
    </body>
</html>
