<%-- 
    Document   : evento_detalhado
    Created on : 18/04/2017, 22:40:19
    Author     : Elcio Cestari Taira
    Descrição  : mostra um Evento com todos os seus detalhes
--%>
<div class="row">
    <div class="col-md-12">
        <div class="col-md-8">
            <p>Descrição: ${evento.descricao}</p>
            <p>Valor: ${evento.valor}</p>
            <p>Faixa etaria: ${evento.faixaEtaria}</p>
            <button class="btn btn-danger" onclick="${pageContext.request.contextPath}/delete-evento">DELETE</button>
        </div>
    </div>
