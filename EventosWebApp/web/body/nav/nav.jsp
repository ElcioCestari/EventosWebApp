
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Descrição  : Este documento representa os nav de todas jsp
    Document   : nav
    Created on : 05/04/2017, 13:56:15
    Author     : Elcio Cestari Taira
--%>
<%--<c:choose>--%>
    <%--<c:when test="${tituloDaPagina eq '/home'}"><c:set var="class_active_home" value="active"></c:set></c:when>--%>
    <%--<c:when test="${tituloDaPagina eq 'Evento'}"><c:set var="class_active_evento" value="active"></c:set></c:when>--%>
    <%--<c:when test="${tituloDaPagina eq 'Login'}"><c:set var="class_active_login" value="active"></c:set></c:when>--%>
    <%--<c:when test="${tituloDaPagina eq 'Novo Usuario'}"><c:set var="class_active_usuario" value="active"></c:set></c:when>--%>
    <%--<c:when test="${tituloDaPagina eq 'Perfil'}"><c:set var="class_active_perfil" value="active"></c:set></c:when>--%>
    <%--<c:when test="${tituloDaPagina eq 'Cadastrar Evento'}"><c:set var="class_active_evento" value="active"></c:set></c:when>--%>
<%--</c:choose>--%> 
<div class="container-fluid">
    <div class="navbar-header"><a class="navbar-brand" href="${pageContext.request.contextPath}/home">Eventos Web</a></div>
    <!--<ul class="nav navbar-nav"><li class="${class_active_home}"><a href="${pageContext.request.contextPath}/home">home</a></li></ul>-->
    <ul class="nav navbar-nav"><li class="${class_active_perfil}"><a href="${pageContext.request.contextPath}/login">Login</a></li></ul>
    <ul class="nav navbar-nav"><li class="${class_active_evento}"><a href="${pageContext.request.contextPath}/CadastrarEvento">Cadastrar Evento</a></li></ul>
    <!--<ul class="nav navbar-nav navbar-right">-->
        <%--<c:choose>--%>
            <%--<c:when test="${autorizacao}">--%>
                <!--<li class="${class_active_login}"><a href="${pageContext.request.contextPath}/Sair"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>-->
            <%--</c:when>--%>
                <%--<c:otherwise>--%>
                <!--<li class="${class_active_usuario}"><a href="${pageContext.request.contextPath}/CadastrarUsuario"><span class="glyphicon glyphicon-user"></span> Criar Conta</a></li>-->
                <!--<li class="${class_active_login}"><a href="${pageContext.request.contextPath}/LoginPage"><span class="glyphicon glyphicon-log-in"></span> Fazer login</a></li>-->
                <%--</c:otherwise>--%>    
        <%--</c:choose>--%>
    <!--</ul>-->
</div>
