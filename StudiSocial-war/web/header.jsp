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
                <%--<p> tasto per la chat
                <button	onClick="cordova.exec(function(res){}, function(err){}, 'avviaActivity' , 'chat', [<%= usr.getPhoneNumber()%>]);">Chat</button>
               </p>--%>
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
                <li class="active"><a href="#">Utenti</a></li>
                <li><a href="#about">Gruppi</a></li>
                <li><a href="#contact">Location</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <%
                Boolean mobile = (Boolean)session.getAttribute("mobile");
                if(mobile != null && mobile){
                Utente usr = (Utente)session.getAttribute("utente");
                %>
                <script src="js/cordova.js"></script>
                <button class="btn btn-success"	onClick="cordova.exec(function(res){}, function(err){}, 'avviaActivity' , 'chat', [<%= usr.getPhoneNumber()%>]);">Chat</button>
            
                <% } %>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</div>