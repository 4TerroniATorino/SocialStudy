<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<div class="jumbotron">
    <div class="container">
        <h1>Utente</h1>
        <h3>In questa pagina andrà il profilo di un utente</h3>
        <%--  creazione libretto se il profilo è tuo--%>
        <%@page import="entity.Utente"%>
        <%
            Utente usr = (Utente) session.getAttribute("utente");
            if (usr.getLibrettoId() == null && usr.getId() == request.getAttribute("idUtente")) {
                out.print("<form method=\"get\" action=\"Career\">"
                        + "<input type=\"hidden\" name=\"id\" value=\"request.getAttribute(\"idUtente\")\">"
                        + "<input type=\"hidden\" name=\"op\" value=\"crealibretto\">"
                        + "<input type=\"submit\" value=\"Riempi libretto\">"
                        + "</form>");
            }
            request.getAttribute("elenco");
        %>
    </div>
</div>
