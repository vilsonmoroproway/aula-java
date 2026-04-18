<%-- 
    Document   : sucesso.jsp
    Created on : 18 de abr. de 2026, 15:26:13
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%
               out.print(request.getAttribute("msg"));
            %></h1>
            <hr />
            <a href="consulta.jsp">Ver dados</a>
    </body>
</html>
