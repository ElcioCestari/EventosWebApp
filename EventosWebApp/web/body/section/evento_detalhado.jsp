<%-- 
    Document   : evento_detalhado
    Created on : 18/04/2017, 22:40:19
    Author     : Elcio Cestari Taira
    Descrição  : mostra um Evento com todos os seus detalhes
--%>

<div class="row">
    <div class="col-md-4">
        <img src="${pageContext.request.contextPath}/ExibirImagemServlet?img_path=${evento.listImagem[0].path}" alt="foto do evento" class="img-rounded" width="280" height="210">
    <div class="col-md-8">
        <h3>${evento.nome}</h3>
        <p>Valor: ${evento.valor}</p>
        <p>Faixa etaria: ${evento.faixaEtaria}</p>
        <p>id: ${evento.id_evento}</p>    
        <p>Descrição: ${evento.descricao}</p>
    </div>
</div>
