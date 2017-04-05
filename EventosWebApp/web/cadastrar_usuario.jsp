<%-- 
    Descrição  : Esta jsp comtém um formulário para criar um usuario
                 método de envio é post e será recebido pelo action /salvarUsuario
    Document   : Home
    Created on : 09/03/2017, 21:32:11
    Author     : Elcio Cestari Taira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head/head.jsp" %>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <%@include file="body/nav/nav.jsp" %>
        </nav>
        <header class="jumbotron text-center col-md-12">
            <%@include file="body/header/header.jsp" %>
        </header>
        <section class="container">
            <form class="col-md-6" action="${pageContext.request.contextPath}/SalvarUsuario" method="post" autocomplete="on">
                <%@include file="body/section/form/usuario.jsp" %>
                <input type="submit" class="btn btn-default" value="Salvar"></input>
            </form>
        </section>
        <footer class="col-md-12">
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>




