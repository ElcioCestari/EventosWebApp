<%-- 
    Document   : endereco
    Created on : 05/04/2017, 14:43:48
    Author     : Elcio Cestari Taira
--%>

<fieldset><legend><strong>Detalhes do Endereco:</strong></legend>
    <div class="form-group">
        <label for="rua">Rua</label>
        <input type="text" class="form-control" id="rua" name="rua" placeholder="Nome da rua" size="40" required>
    </div>
    <div class="form-group">
        <label for="numero">numero</label>
        <input type="number" class="form-control" id="numero" name="numero" placeholder="numero" required>
    </div>
    <div class="form-group">
        <label for="bairro">Bairro</label>
        <input type="text" class="form-control" id="bairro" name="bairro" placeholder="Nome do bairro" size="40" required>
    </div>
    <div class="form-group">
        <label for="cidade">Cidade:</label>
        <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Nome da cidade" size="40" required>
    </div>
    <div class="form-group">
        <label for="estado">Estado:</label>
        <input type="text" class="form-control" id="estado" name="estado" placeholder="MS" size="2" maxlength="2" required>
    </div>
</fieldset>
