<%-- 
    Document   : editar
    Created on : 18 de abr. de 2026, 16:07:19
    Author     : aluno
--%>

<%@page import="modelos.Contato"%>
<%@page import="dao.ContatoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String idContato = request.getParameter("id");
            Contato contato = ContatoDao.getById(Integer.parseInt(idContato));
        %>
        <h1>Editando: <% out.print(contato.getId());%></h1>
        <form  action="${pageContext.request.contextPath}/cadastro_pessoa" method="POST">
            <input type="hidden" name="id" value="<%= contato.getId() %>"/>
            <label>Informe nome</label>
            <input type="text" placeholder="Ex: ana" name="nome" value="<%= contato.getNome() %>"/>
            <label>Informe email</label>
            <input type="text" placeholder="Ex: ana@gmail.com" name="email" value="<%= contato.getEmail()%>"/>
            <button>Enviar</button>
        </form>
    </body>
</html>
