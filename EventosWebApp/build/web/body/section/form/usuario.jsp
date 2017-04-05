<%-- 
    Document   : usuario
    Created on : 05/04/2017, 14:51:07
    Author     : Elcio Cestari Taira
--%>

<div class="form-group">
    <label for="nome">Nome:</label>
    <input type="text" class="form-control" id="nome" name="nome" placeholder="Seu Nome Completo" size="40" required>
</div>
<div class="form-group">
    <label for="idade">Idade:</label>
    <input type="number" class="form-control" id="idade" name="idade" placeholder="18" min="1" max="100" required>
</div>
<div class="form-group">
    <label for="nome">Login:</label>
    <input type="email" class="form-control" id="email" name="login" placeholder="seuemail@email.com" size="40" required>
</div>
<div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="senha" class="form-control" id="pwd" required autocomplete="off">
</div>
