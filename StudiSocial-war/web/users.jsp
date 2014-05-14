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
        <h2>Pagina utente</h2>
        <h3></h3>
        <%--  creazione libretto se il profilo è tuo--%>
        <%@page import="entity.Utente"%>
        <%
            if(request.getAttribute("person")!=null) {
                out.print("utente");
                //<c:out value="${person.nome} ${person.cognome}"/c:out>;
            }
            else if (request.getAttribute("users")!=null) {
                out.print("lista utenti");
            }
            Utente usr = (Utente) session.getAttribute("utente");
            if (usr.getLibrettoId() == null && usr.getId() == request.getAttribute("idUtente")) {
                out.print("<form method=\"get\" action=\"Career\">"
                    + "<input type=\"hidden\" name=\"id\" value=\"request.getAttribute(\"idUtente\")\">"
                    + "<input type=\"hidden\" name=\"op\" value=\"crealibretto\">"
                    + "<input type=\"submit\" class=\"btn btn-primary btn-lg\" value=\"Inserisci piano di studi\">"
                    + "</form>");
            }
        %>
    </div>
</div>
