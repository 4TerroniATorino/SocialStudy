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
            <h2>${user.nome} ${user.cognome} (${user.username})</h2>
            <div id="profile-info">
                <img src="data/users/${user.id}.jpg" class="profile-picture"/>
                <c:if test="${user.id eq sessionScope.utente.id}">
                    <p>E-mail:${user.email}</p>
                    <p>Numero: ${user.phoneNumber}</p>
                </c:if>
            </div>
            <div style="clear: both"></div>
            <c:if test="${user.id eq sessionScope.utente.id}">
                <br><br>
                <h3>Gruppi di studio</h3>
                <c:if test="${gruppi.size() ne 0}">
                    <table class="table table-striped table-bordered">
                        <c:forEach var="gruppo" items="${gruppi}">
                            <tr><td><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></td></tr>
                        </c:forEach>
                    </table>
                </c:if>
                <form method="POST" action="Groups?action=createGroup">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" class="btn btn-primary btn-lg" value="Crea gruppo di studio">
                </form>
                <br><br>
                <h3>Libretto</h3>
                <c:if test="${libretto.size() eq 0}">
                    <form method="POST" action="Career?action=crealibretto">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" class="btn btn-primary btn-lg" value="Inserisci piano di studi">
                    </form>
                </c:if>
                <c:if test="${libretto.size() ne 0}">
                    <table class="table table-striped table-bordered">
                        <tr><th>Materia</th><th>Voto</th></tr>
                        <c:forEach var="voto" items="${libretto}">
                            <tr><td>${voto.corso.nome}</td><td>${voto.voti}</td></tr>
                        </c:forEach>
                    </table>
                </c:if>
            </c:if>
        </c:if>
    </div>
</div>
