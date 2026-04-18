<%-- 
    Document   : consulta.jsp
    Created on : 18 de abr. de 2026, 15:45:08
    Author     : aluno
--%>

<%@page import="java.util.List"%>
<%@page import="modelos.Contato"%>
<%@page import="dao.ContatoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" 
              crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center">Lista de contatos</h1>
        <table class="table table-striped container">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                  List<Contato> contatos = ContatoDao.getAll();
                 
                  for(Contato ct : contatos){
                     out.print("<tr>");
                     out.print("<td>"+ct.getId()+"</td>");
                     out.print("<td>"+ct.getNome()+"</td>");
                     out.print("<td>"+ct.getEmail()+"</td>");
                     out.print("<td><a href='editar.jsp?id="+ct.getId()+"'>Editar</a></td>");
                     out.print("</tr>");
                  }
                  
                %>
            </tbody>    
        </table>
    </body>
</html>
