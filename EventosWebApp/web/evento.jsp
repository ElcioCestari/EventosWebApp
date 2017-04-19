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
        <header class="jumbotron text-center">
            <%@include file="body/header/header.jsp" %>
        </header>
        <section class="container">
            <%@include file="body/section/evento_detalhado.jsp" %>
        </section>
        <footer class="col-md-12">
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>
