<%-- 
    Document   : consulta_produtos
    Created on : 2 de mai. de 2026, 15:26:30
    Author     : aluno
--%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" 
              rel="stylesheet" 7
              integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" 
              crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Lista de produtos</h1>
        <hr />
        <table class="table table-stripped">
            <thead>
            <tr>
               <th>Descrição</th>
               <th>Preço</th>
               <th>Validade</th>
               <th>Excluir</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtos}" var="prod">
                    <tr>
                        <td>${prod.nome}</td>
                        <td> <fmt:formatNumber value="${prod.preco}"  type="currency"/></td>
                        <td><fmt:formatDate value="${prod.validade}"  pattern="dd/MM/yyyy"/></td>
                        <td><a href="produtos?acao=excluir&id=${prod.id}">Excluir</a></td>
                    </tr>
                </c:forEach>    
            </tbody>
        </table>
        <hr />
        <a href="./index.jsp">Home</a>
    </body>
</html>
