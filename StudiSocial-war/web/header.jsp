<%@page import="entity.Utente"%>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--[if lt IE 7]>
    <p class="chromeframe">You are using an <strong>outdated</strong> browser.
    Please <a href="http://browsehappy.com/">upgrade your browser</a> or
    <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>
    to improve your experience.</p>
<![endif]-->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Social Study</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Utenti <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Il tuo profilo</li>
                        <li><a href="Users?id=${sessionScope.utente.id}">${sessionScope.utente.nome} ${sessionScope.utente.cognome}</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">I tuoi amici</li>
                        <c:forEach var="user" items="${users}" end="10">
                            <c:if test="${user.id ne sessionScope.utente.id}">
                                <li><a href="Users?id=${user.id}">${user.nome} ${user.cognome}</a></li>
                            </c:if>
                        </c:forEach>
                        <li class="divider"></li>
                        <li><a href="Users">Altro...</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Location <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Dipartimenti</li>
                        <c:forEach var="location" items="${locations1}" end="5">
                            <li><a href="Location?id=${location.id}">${location.descrizione}</a></li>
                        </c:forEach>
                        <li class="divider"></li>
                        <li class="dropdown-header">Aule Studio</li>
                        <c:forEach var="location" items="${locations2}" end="5">
                            <li><a href="Location?id=${location.id}">${location.descrizione}</a></li>
                        </c:forEach>
                        <li class="divider"></li>
                        <li class="dropdown-header">Biblioteche</li>
                        <c:forEach var="location" items="${locations3}" end="5">
                            <li><a href="Location?id=${location.id}">${location.descrizione}</a></li>
                        </c:forEach>
                        <li class="divider"></li>
                        <li><a href="Location">Altro...</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Gruppi <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <c:if test="${empty groups}">
                            <li class="dropdown-header">Non sono presenti gruppi</li>
                        </c:if>
                        <c:forEach var="group" items="${groups}" end="10">
                            <li><a href="Groups?id=${group.id}">${group.nome}</a></li>
                        </c:forEach>
                        <li class="divider"></li>
                        <li><a href="Groups">Altro...</a></li>
                    </ul>
                </li>
                <li><a href="Meetings">Incontri</a></li>
                <li><a href="Career">Carriera</a></li>
                <li><a href="Map">Mappa</a></li>
            </ul>
            <% Utente usr = (Utente)session.getAttribute("utente"); %> 
            <form class="navbar-form navbar-right">
                <a class="btn btn-danger" href="Controller?action=logout">Logout: Ciao  <%=usr.getUsername() %></a>
                <%
                Boolean mobile = (Boolean)session.getAttribute("mobile");
                if(mobile != null && mobile){
                %>
                <script src="js/cordova.js"></script>
                <button class="btn btn-success"	onClick="cordova.exec(function(res){}, function(err){}, 'avviaActivity' , 'chat', [<%= usr.getPhoneNumber()%>]);">Chat</button>
            
                <% } %>
            </form>

        </div><!--/.navbar-collapse -->
    </div>
</div>
