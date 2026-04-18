<%-- 
    Document   : index
    Created on : 18 de abr. de 2026, 13:42:37
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
        <h1>Hello World!</h1>
        <form  action="${pageContext.request.contextPath}/cadastro_pessoa" method="POST">
            <label>Informe nome</label>
            <input type="text" placeholder="Ex: ana" name="nome"/>
            <label>Informe email</label>
            <input type="text" placeholder="Ex: ana@gmail.com" name="email"/>
            <button>Enviar</button>
        </form>
            
         <%
            
            if(request.getAttribute("Erro") != null){
               out.print("<p>"+ request.getAttribute("Erro") +"</p>");
            }
        %>
       
        <h1>Hello World!</h1>
        <form  action="${pageContext.request.contextPath}/cadastro.jsp" method="POST">
            <label>Informe nome</label>
            <input type="text" placeholder="Ex: ana" name="nome"/>
            
            <label>Informe email</label>
            <input type="text" placeholder="Ex: ana@gmail.com" name="email"/>
            
            <button>Enviar</button>
        </form>
        
    </body>
</html>
