<%-- 
    Document   : evento
    Cr 05/04/2017, 14:47:44
    Author     : Elcio Cestari Taira
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>alert(${resultado})</script>
<fieldset><legend><strong>Detalhes do evento:</strong></legend>
    <c:set var="error" scope="session" value="${param.error}"/>  
    <c:if test="${error != null}">  
        <p>My income is: <c:out value="${error}"/><p>  
    </c:if> 
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
    <div class="form-group">
        <label for="imagem">Imagem do Evento</label>
        <input type="file" class="form-control" id="imgEvento" name="nomeImagem" placeholder="Foto para divulgação" required accept="image/*">
    </div>
</fieldset>
