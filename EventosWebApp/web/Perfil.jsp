<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
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


            <div class="container-fluid">
                
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">Eventos Web</a>
            </div>
                <ul class="nav navbar-nav">
                    <li ><a href="${pageContext.request.contextPath}/Home">Home</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/CadastrarEvento">Cadastrar Evento</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="active" ><a href="${pageContext.request.contextPath}/Perfil">Perfil</a></li>
                </ul>
              
            </div>
        </nav>
        <header class="jumbotron text-center">
            <h1 class="tituloDaPagina">${tituloDaPagina}</h1>
            <h2 class="subtituloDaPagina">Encontre e divulgue os seus eventos preferidos!</h2> 
        </header>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcStfDAuvu8lCkbu5ugjEKhsT00G01fnZLhSAbhNFbiza8MIFZfUjYA8n4A">
                    </img>
                </div>
                <div class="col-md-8">
                    <h3>Titulo da Festa</h3>
                    <p>Aqui vai uma breve descrição do que conterá na festa</p>
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
                </div>
            </div><div class="row">
                <div class="col-md-4">
                    <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcStfDAuvu8lCkbu5ugjEKhsT00G01fnZLhSAbhNFbiza8MIFZfUjYA8n4A">
                    </img>
                </div>
                <div class="col-md-8">
                    <h3>Titulo da Festa</h3>
                    <p>Aqui vai uma breve descrição do que conterá na festa</p>
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
                </div>
            </div>
        </div>
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
