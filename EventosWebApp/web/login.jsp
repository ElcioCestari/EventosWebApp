<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@include file="head/head.jsp" %>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <%@include file="body/nav/nav.jsp" %>
        </nav>
        <header class="jumbotron">
            <%--<%@include file="body/header/header.jsp" %>--%>
        </header>
        
        <div class="container">
            <form  method="post" action="${pageContext.request.contextPath}/login" action="POST">
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input type="email" class="form-control" id="login" name="login" autocomplete="on" required placeholder="seuemail@email.com">
                </div>
                <div class="form-group">
                    <label for="pwd">Senha:</label>
                    <input type="password" class="form-control" id="pwd" name="senha" autocomplete="off" placeholder="Digite sua senha aqui...">
                </div>
                <input class="text-left btn-primary" type="submit" value="Logar"/>
            </form>
            <div class="text-right">
                <a href="cadastrar_usuario">regisstrar-se</a>
            </div>
        </div>
                
        <footer class="col-md-12">
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>
