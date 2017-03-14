<%-- 
    Document   : Home
    Created on : 09/03/2017, 21:32:11
    Author     : 201319020135
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${tituloDaPagina}</title>
    </head>
    <body>
        <h1>${tituloDaPagina}</h1>

        <form action="${pageContext.request.contextPath}/SalvarUsuario" method="post" autocomplete="on">
            Nome:<br>
            <input type="text" name="nome" placeholder="Seu Nome Completo" size="40" required>
            <input type="number" name="idade" placeholder="20" min="1" max="100" required>
            <br>
            login:<br>
            <input type="email" name="login" placeholder="seuemail@email.com" size="40" required>
            <br>
            Senha:<br>
            <input type="password" name="senha" placeholder="digite sua senha..." size="20" required autocomplete="off"> 
            <br><br>
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
