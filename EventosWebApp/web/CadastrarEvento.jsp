<%-- 
    Document   : Home
    Created on : 09/03/2017, 21:32:11
    Author     : 201319020135
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${tituloDaPagina}</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css_principal.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">

            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">Eventos Web</a>
            </div>
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/CadastrarEvento">Cadastrar Evento</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li ><a href="${pageContext.request.contextPath}/Perfil">Perfil</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li ><a href="${pageContext.request.contextPath}/Home">Home</a></li>
                </ul>
            </div>
        </nav>

        <header class="jumbotron text-center col-md-12"><h1>${tituloDaPagina}</h1></header>

        <section class="container">
            <form class="col-md-6" action="${pageContext.request.contextPath}/SalvarEvento" method="post" autocomplete="on">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome do seu evento" size="40" required>
                </div>
                <input type="submit" class="btn btn-default" value="Salvar"></input>
            </form>
        </section>

        <footer class="col-md-12">
            <div class="row">
                <p class="col-sm-4 direitos_autorais">&copy; 2017 Celso &AMP; Elcio &AMP; Nélio</p>
                <ul class="col-sm-8">
                    <li class="col-sm-1">
                        <img src="https://s3.amazonaws.com/codecademy-content/projects/make-a-website/lesson-4/twitter.svg">
                    </li>
                    <li class="col-sm-1">
                        <img src="https://s3.amazonaws.com/codecademy-content/projects/make-a-website/lesson-4/facebook.svg">
                    </li>
                </ul>
            </div>
        </footer>
    </body>
</html>




