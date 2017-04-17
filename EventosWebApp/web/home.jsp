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
        <section class="container">
            <c:choose>
                <c:when test="${ empty listaDeEventos}"><p class="col-md-12">Não ha eventos cadastrados</p></c:when>
                <c:otherwise>
                    <c:forEach var="evento" items="${listaDeEventos}">
                        <section class="row">
                            <div class="col-md-4">
                                <img src="http://www.estadosecapitaisdobrasil.com/wp-content/uploads/2014/11/monumento-cavaleiro-guaicuru-parque-das-nacoes-indigenas-campo-grande-1024x685.jpg" alt="foto do evento" class="img-rounded" width="304" height="236">
                            </div>
                            <div class="col-md-8"> 
                                <h3>${evento.nome}</h3>
                                <p>${evento.descricao}</p>
                                <p>Faixa etaria: ${evento.faixaEtaria}</p>
                                <p>Valor: R$ ${evento.valor}</p>
                                <a href="">Para mais informações sobre o evento clique aqui!</a>
                            </div>
                        </section> 
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </section>
        <footer class="col-md-12">
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>
