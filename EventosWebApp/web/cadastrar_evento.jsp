<%-- 
    Document   : Home
    Created on : 09/03/2017, 21:32:11
    Author     : Elcio Cestari Taira
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
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">Eventos Web</a>
                </div>
                <ul class="nav navbar-nav">
                    <li ><a href="${pageContext.request.contextPath}/Home">Home</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li ><a href="${pageContext.request.contextPath}/Perfil">Perfil</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="active" ><a href="${pageContext.request.contextPath}/CadastrarEvento">Cadastrar Evento</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/CadastrarUsuario"><span class="glyphicon glyphicon-user"></span> Criar Conta</a></li>
                    <li><a href="${pageContext.request.contextPath}/LoginPage"><span class="glyphicon glyphicon-log-in"></span> Fazer login</a></li>
                </ul>
            </div>
        </nav>
                <br><br><br><br>
        <section class="container">
            <form class="col-md-6" action="${pageContext.request.contextPath}/salvarEvento" method="post" autocomplete="on">
                <fieldset><legend><strong>Detalhes do evento:</strong></legend>
                    <div class="form-group">
                        <label for="nomeEvento">Nome:</label>
                        <input type="text" class="form-control" id="nomeEvento" name="nomeEvento" placeholder="Nome de Evento" size="40" required>
                    </div>
                    <div class="form-group">
                        <label for="tipo_evento">Tipo:</label>
                        <input type="text" class="form-control" id="tipo_evento" name="tipo_evento" placeholder="Tipo de Evento" size="40" required>
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição:</label>
                        <input type="text" class="form-control" id="descricao" name="descricao" required>
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor:</label>
                        <input type="number" class="form-control" id="valor" name="valor" min="0" placeholder="Qual o valor?" required>
                    </div>
                    <div class="form-group">
                        <label for="faixaEtaria">Faixa Etaria</label>
                        <input type="number" class="form-control" id="faixaEtaria" name="faixaEtaria" placeholder="Qual a faixa etaria do evento?" min="0" max="21" required>
                    </div>
                </fieldset><br><br>
                <fieldset><legend><strong>Detalhes do Local:</strong></legend>
                    <div class="form-group">
                        <label for="nomeLocal">Nome:</label>
                        <input type="text" class="form-control" id="nomeLocal" name="nomeLocal" placeholder="Nome de Local" size="40" required>
                    </div>
                    <div class="form-group">
                        <label for="capacidade">Capacidade:</label>
                        <input type="number" class="form-control" id="capacidade" name="capacidade" placeholder="Qual a capacidade?" min="1" required>
                    </div>
                </fieldset><br><br>
                <fieldset><legend><strong>Detalhes do Endereco:</strong></legend>
                    <div class="form-group">
                        <label for="rua">Rua</label>
                        <input type="text" class="form-control" id="rua" name="rua" placeholder="Nome da rua" size="40" required>
                    </div>
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Nome da cidade" size="40" required>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <input type="text" class="form-control" id="estado" name="estado" placeholder="Nome do Estado" size="2" required>
                    </div>
                </fieldset>

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




