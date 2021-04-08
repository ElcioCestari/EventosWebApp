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
            <div class=""> 
                <img src="${pageContext.request.contextPath}/ExibirImagemServlet?img_path=${evento.listImagem[0].path}" alt="foto do evento" class="img-rounded" width="100%" height="300px">
                <h2 class="">${evento.nome}</h2>
            </div>
        </header>
        <section class="container">
            <%@include file="body/section/evento_detalhado.jsp" %>
        </section>
        <footer class="footer">
            <%--<%@include file="body/footer/footer.jsp" %>--%>
        </footer>
    </body>
</html>
