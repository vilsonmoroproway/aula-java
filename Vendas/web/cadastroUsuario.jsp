<%-- 
    Document   : cadastroUsuario.jsp
    Created on : 25 de abr. de 2026, 14:24:59
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
        <h1>Novo usuario</h1>
        <form action="cadastro_usuario" method="POST">
            <label for="nome">Informe nome</label>
            <input type="text" id="nome" name="nome" />
            
            <label for="email">Informe email</label>
            <input type="email" id="email" name="email" />
            
            <label for="senha">Informe senha</label>
            <input type="password" id="senha" name="senha" />
            
            <label>Selecione uma opção</label>
            <select id="perfil" name="perfil">
                <option value="USER">USER</option>
                <option value="ADMIN">ADMIN</option>
            </select>
            <button>Gravar</button>
        </form>        
        <hr />
        <a href="index.jsp">Home</a>
    </body>
</html>
