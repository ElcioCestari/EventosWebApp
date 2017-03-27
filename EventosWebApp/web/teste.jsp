<%-- 
    Document   : teste
    Created on : 21/03/2017, 18:46:28
    Author     : Elcio Cestari Taira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nome: ${usuario.nome}</h1>
        <h1>id: ${usuario.id_usuario}</h1>
        <h1>idade: ${usuario.idade}</h1>
        <h1>senha: ${usuario.senha}</h1>
        <p>${
        nomeEvento}</p>
        <p>${tipo}</p>
        <p>${descricao}</p>
        <p>${valor}</p>
        <p>${faixaEtaria}</p>
    </body>
</html>
