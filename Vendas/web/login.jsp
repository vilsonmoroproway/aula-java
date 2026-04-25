<%-- 
    Document   : login
    Created on : 25 de abr. de 2026, 15:20:12
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            form{
                width: 40%
            }
            
            input{
                width: 100%
            }
        </style>  
    </head>
    <body>
        <h1>Login de usuário</h1>
        <form action="login_usuario" method="POST">
            <label for="email">Informe email</label>
            <input type="email" id="email" name="email" />
            
            <label for="senha">Informe senha</label>
            <input type="password" id="senha" name="senha" />
            
            <button>Login</button>
        </form>
    </body>
</html>
