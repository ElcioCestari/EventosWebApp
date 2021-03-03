<%-- 
    Document   : card_evento
    Created on : Feb 26, 2021, 10:54:28 PM
    Author     : elciotaira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:forEach items="${eventos}" var="evento">
<div class="card" style="width: 18rem;">
  <img class="card-img-top" 
       src="https://www.dreamlines.com.br/wp-blog/uploads/2020/02/27175426/800-533.jpg" 
       alt="Card image cap"
       width="150"
       height="200"
       >
  <div class="card-body">
    <h5 class="card-title">{evento.tipo}</h5>
    <p class="card-text">{evento.descricao}</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
</c:forEach>