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
        <nav class="navbar navbar-inverse navbar-fixed-top"
             <%@include file="body/nav/nav.jsp" %>
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
            <%@include file="body/footer/footer.jsp" %>
        </footer>
    </body>
</html>




