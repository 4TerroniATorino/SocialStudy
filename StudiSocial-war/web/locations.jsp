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
        <%-- Location unica --%>
        <c:if test="${empty param.id}">
            <h2>Lista locations</h2>
            <c:forEach var="location" items="${locations}">
                <p><a href="Locations?id=${location.id}">${location.descrizione} ${location.indirizzo} ${location.type}</a></p>
            </c:forEach>
        </c:if>

        <%-- Lista location --%>
        <c:if test="${not empty param.id}">
            <h2>Pagina location</h2>
            <p>${location.descrizione} ${location.indirizzo} ${location.type}</p>
            <form method="POST" action="Map">
                <input type="hidden" name="id" value="${location.id}">
                <input type="hidden" name="action" value="showInMap">
                <input type="submit" class="btn btn-primary btn-lg" value="Visualizza su mappa">
            </form>
        </c:if>
    </div>
</div>
