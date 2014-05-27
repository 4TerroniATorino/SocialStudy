<%-- 
    Document   : group
    Created on : 25-may-2014
    Author     : Lorenzo
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    #discussion img {max-width: 60px; max-height: 60px}
</style>

<script>
    function checkForm() {
        f = document.createForm;
        if (f.nome.value === null || f.argomenti.value === null || f.nome.value === "" || f.argomenti.value === "") {
            alert("Riempi tutti i campi");
            return false;
        }
        else
            return true;
    }
</script>

<div class="container">
    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-2 column">
                <img alt="140x140" src="http://lorempixel.com/140/140/" class="img-rounded">
            </div>
            <div class="col-md-10 column">
                <h2>Gruppo "${gruppo.nome}"</h2>
                <h5>Goal bar</h5>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                        60%
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <p><strong>Argomento</strong>: ${gruppo.argomenti}</p>
                <p><strong>Corso di riferimento</strong>: ${gruppo.corso.nome}</p>
                <p><strong>Partecipanti</strong>:</p>
                <ul>
                <li><small><a href="Users?id=${gruppo.fondatore.id}">
                    ${gruppo.fondatore.nome} ${gruppo.fondatore.cognome} (${gruppo.fondatore.username})
                </a> - Fondatore</small></li>
                <c:forEach var="component" items="${gruppo.utenteCollection}">
                    <li><small><a href="Users?id=${component.id}">
                        ${component.nome} ${component.cognome} (${component.username})
                    </a></small></li>
                </c:forEach>
                    </ul>
                <%--<p><a class="btn" href="#">View details »</a></p>--%>
            </div>
            <div class="col-md-5 column">
                <%--<blockquote>
                    <p>Esami inerenti... </p>
                    <small>...architetture di sputo, <cite> database ficcanaso, reti di nonsoccosa </cite></small>
                </blockquote>--%>
            </div>
        </div>
    </div>

    <c:if test="${adminLevel gt 0}">
        <div class="jumbotron">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <button type="button" class="btn btn-success btn-lg btn-block">Invita studente al gruppo</button>
                </div>
                <div class="col-md-6 column">
                    <form method="POST" action="Meetings?action=createMeeting">
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="Crea incontro">
                            <input type="hidden" name="idGruppo" value="${gruppo.id}" />
                    </form>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${adminLevel gt 0}">
        <div class="jumbotron">
            <h2>Discussione</h2>
            <br>
            <div class="row clearfix">
                <ul id="discussion" class="media-list">
                    <li class="media">
                        <a class="pull-left" href="#">
                            <img class="media-object" src="${gruppo.fondatore.picture}" alt="">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">Creazione del gruppo</h4>
                            ${gruppo.fondatore.nome} ${gruppo.fondatore.cognome} ha creato il gruppo!
                        </div>
                    </li>
                    <c:forEach var="component" items="${gruppo.utenteCollection}">
                        <li class="media">
                            <a class="pull-left" href="#">
                                <img class="media-object" src="${component.picture}" alt="">
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading">Iscrizione al gruppo</h4>
                                ${component.nome} ${component.cognome} si è unito al gruppo!
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <br>
            <button type="button" class="btn btn-primary btn-lg btn-block">Aggiungi risposta</button>
        </div>
    </c:if>

    <div class="jumbotron">
        <div class="row clearfix">
            <c:if test="${adminLevel eq 0}">
                <button type="button" class="btn btn-success btn-lg btn-block">Richiedi partecipazione</button>
            </c:if>
            <c:if test="${adminLevel eq 1}">
                <button type="button" class="btn btn-danger btn-lg btn-block">Abbandona il gruppo</button>
            </c:if>
            <c:if test="${adminLevel eq 2}">
                <div class="col-md-6 column">
                    <button type="button" class="btn btn-warning btn-lg btn-block">Modifica le informazioni del gruppo</button>
                </div>
                <div class="col-md-6 column">
                    <button type="button" class="btn btn-danger btn-lg btn-block">Elimina definitivamente il gruppo</button>
                </div>
            </c:if>
        </div>
    </div>
</div>
