<%-- 
    Document   : index
    Created on : 2 de mai. de 2026, 13:37:43
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

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
    <body>

        <c:out value="Olá pessoal"/>

        <c:set var="idade" value="25"/>

        <c:if test="${idade >= 18}">
            <p>Maior de idade</p>
        </c:if>
            
        <c:set var="nota" value="7" />

        <c:choose>

            <c:when test="${nota >= 7}">
                <p>Aprovado</p>
            </c:when>

            <c:when test="${nota >= 5}">
                <p>Recuperação</p>
            </c:when>

            <c:otherwise>
                <p>Reprovado</p>
            </c:otherwise>

        </c:choose>
                
                <form action="alunos">
                    <button>Ver alunos</button>
                </form>
                
                 <form action="produtos">
                    <button>Ver produtos</button>
                </form>
                
                <hr />
                <form class="container" action="produtos" method="POST">
                    <label>Informe nome</label>
                    <input type="text" placeholder="EX: milho" class="form-control" name="nome"/>
                    <label>Informe preço</label>
                    <input type="text" placeholder="EX: 10.25" class="form-control" name="preco"/>
                    <label>Informe validade</label>
                    <input type="date" placeholder="EX: " class="form-control" name="validade"/>
                    <button class="btn btn-primary mt-3">Salvar</button>
                </form>


    </body>
</html>
