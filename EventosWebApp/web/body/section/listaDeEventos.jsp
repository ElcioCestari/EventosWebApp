<%-- 
    Document   : listaDeEventos
    Created on : 18/04/2017, 10:40:22
    Author     : Elcio Cestari Taira
    Descricao  : Contem uma lista basica, ou seja, apenas as informações principais de um evento
--%>
<c:choose>
    <c:when test="${ empty listaDeEventos}"><p class="col-md-12">Não ha eventos cadastrados</p></c:when>
    <c:otherwise>
        <c:forEach var="evento" items="${listaDeEventos}">
            <section class="row">
                <div class="col-md-4">
                    <img src="http://www.estadosecapitaisdobrasil.com/wp-content/uploads/2014/11/monumento-cavaleiro-guaicuru-parque-das-nacoes-indigenas-campo-grande-1024x685.jpg" alt="foto do evento" class="img-rounded" width="304" height="236">
                </div>
                <div class="col-md-8"> 
                    <h3>${evento.nome}</h3>
                    <p>${evento.descricao}</p>
                    <p>Faixa etaria: ${evento.faixaEtaria}</p>
                    <p>Valor: R$ ${evento.valor}</p>
                    <a href="${pageContext.request.contextPath}/Evento?id=${evento.id_evento}">Para mais informações sobre o evento clique aqui!</a>
                    
                </div>
            </section> 
        </c:forEach>
    </c:otherwise>
</c:choose>