
<%--
    Descrição  : Este documento representa os nav de todas jsp
    Document   : nav
    Created on : 05/04/2017, 13:56:15
    Author     : Elcio Cestari Taira
--%>
<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">Eventos Web</a>
    </div>
    <ul class="nav navbar-nav">
        <li class="active" ><a href="${pageContext.request.contextPath}/Home">Home</a></li>
    </ul>
    <ul class="nav navbar-nav">
        <li ><a href="${pageContext.request.contextPath}/Perfil">Perfil</a></li>
    </ul>
    <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath}/CadastrarEvento">Cadastrar Evento</a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/CadastrarUsuario"><span class="glyphicon glyphicon-user"></span> Criar Conta</a></li>
        <li><a href="${pageContext.request.contextPath}/LoginPage"><span class="glyphicon glyphicon-log-in"></span> Fazer login</a></li>
    </ul>
</div>
