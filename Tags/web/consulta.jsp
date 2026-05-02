<%-- 
    Document   : consulta
    Created on : 2 de mai. de 2026, 14:58:44
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${empty alunos}">
            <p>Nenhum aluno cadastrado</p> 
        </c:if>
        
        <c:forEach items="${alunos}" var="aluno">
            <p>Nome: ${aluno}</p>
        </c:forEach>
    </body>
</html>
