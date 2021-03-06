<%-- 
    Document   : listaDeEventos
    Created on : 18/04/2017, 10:40:22
    Author     : Elcio Cestari Taira
    Descricao  : Contem uma lista basica, ou seja, apenas as informações principais de um evento
--%>
<c:choose>
    <c:when test="${ empty listEventos}"><p class="col-md-12">Não ha eventos cadastrados</p></c:when>
    <c:otherwise>
        <c:forEach var="evento" items="${listEventos}">
            <section class="card evento-card" >
                <div class="card-img-top">
                    <img src="http://www.estadosecapitaisdobrasil.com/wp-content/uploads/2014/11/monumento-cavaleiro-guaicuru-parque-das-nacoes-indigenas-campo-grande-1024x685.jpg" alt="foto do evento" class="img-rounded" width="280" height="210">
                </div>
                <div class="card-body"> 
                    <h3 class="card-title">${evento.nome}</h3>
                    <p class="card-text">${evento.descricao}</p>
                    <p><bold>Faixa etaria</bold>: ${evento.faixaEtaria}</p>
                    <p><bold>Valor</bold>: R$ ${evento.valor}</p>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/Evento?id=${evento.id_evento}">info</a>
                    
                </div>
            </section> 
        </c:forEach>
    </c:otherwise>
</c:choose>