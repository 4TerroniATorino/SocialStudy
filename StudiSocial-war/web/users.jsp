<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="jumbotron">
    <div class="container">

        <%-- Lista di tutti gli utenti --%>
        <c:if test="${empty param.id}">
            <h2>Lista utenti</h2>
            <c:forEach var="user" items="${users}">
                <p><a href="Users?id=${user.id}">${user.nome} ${user.cognome}</a></p>
            </c:forEach>
        </c:if>

        <%-- Profilo unico --%>
        <c:if test="${not empty param.id}">
            <h2>Pagina utente</h2>
            <p>${user.nome} ${user.cognome}</p>
            <c:if test="${empty user.librettoId && user.id eq sessionScope.utente.id}">
                <form method="POST" action="Career?action=crealibretto">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" class="btn btn-primary btn-lg" value="Inserisci piano di studi">
                </form>

                <c:if test="${empty user.librettoId && user.id eq sessionScope.utente.id}">
                    <form method="POST" action="Career?action=crealibretto">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" class="btn btn-primary btn-lg" value="Inserisci piano di studi">
                    </form>
                </c:if>
            </c:if>
        </c:if>
    </div>
</div>
