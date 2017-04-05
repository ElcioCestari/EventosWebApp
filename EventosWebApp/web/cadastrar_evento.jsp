<%-- 
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
        <br><br><br><br>
        <section class="container">
            <form class="col-md-6" action="${pageContext.request.contextPath}/salvarEvento" method="post" autocomplete="on">
                <%@include file="body/section/form/evento.jsp" %>
                <%@include file="body/section/form/local.jsp" %>
                <%@include file="body/section/form/endereco.jsp" %>
                <input type="submit" class="btn btn-default" value="Salvar"></input> 
            </form>
        </section>
        <footer class="col-md-12">
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>




