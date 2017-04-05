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
            <%@include file="body/header/header.jsp"%>
        </header>
        <section>
            <c:choose>
                <c:when test="${ empty listaDeEventos}"><p>Não ha eventos cadastrados</p></c:when>
                <c:otherwise>
                    <ul>
                        <c:forEach var="evento" items="${listaDeEventos}">
                            <li>${evento.nome}</li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </section>
        <footer class="col-md-12">
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>
