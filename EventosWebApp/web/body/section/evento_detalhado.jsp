<%-- 
    Document   : evento_detalhado
    Created on : 18/04/2017, 22:40:19
    Author     : Elcio Cestari Taira
    Descrição  : mostra um Evento com todos os seus detalhes
--%>

<div class="row">
    <div class="col-md-4">
        <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcStfDAuvu8lCkbu5ugjEKhsT00G01fnZLhSAbhNFbiza8MIFZfUjYA8n4A">
        </img>
    </div>
    <div class="col-md-8">
        <h3>${evento.nome}</h3>
        <p>${evento.descricao}</p>
        <p>Valor: ${evento.valor}</p>
        <p>Faixa etaria: ${evento.faixaEtaria}</p>
        <p>id: ${evento.id_evento}</p>
    </div>
</div>
