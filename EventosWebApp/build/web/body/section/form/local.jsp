<%-- 
    Document   : local
    Created on : 05/04/2017, 14:46:50
    Author     : Elcio Cestari Taira
--%>


<fieldset><legend><strong>Detalhes do Local:</strong></legend>
    <div class="form-group">
        <label for="nomeLocal">Nome:</label>
        <input type="text" class="form-control" id="nomeLocal" name="nomeLocal" placeholder="Nome de Local" size="40" required>
    </div>
    <div class="form-group">
        <label for="capacidade">Capacidade:</label>
        <input type="number" class="form-control" id="capacidade" name="capacidade" placeholder="Qual a capacidade?" min="1" required>
    </div>
</fieldset>