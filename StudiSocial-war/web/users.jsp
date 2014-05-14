<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<div class="jumbotron">
    <div class="container">
        <h2>Utente</h2>
        <h3></h3>
        <%--  creazione libretto se il profilo è tuo--%>
        <%@page import="entity.Utente"%>
        <%
            if(request.getAttribute("person")!=null) {
                out.print("utente");
            }
            else if (request.getAttribute("users")!=null) {
                out.print("lista utenti");
            }
            Utente usr = (Utente) session.getAttribute("utente");
            if (usr.getLibrettoId() == null && usr.getId() == request.getAttribute("idUtente")) {
                out.print("<form method=\"get\" action=\"Career\">"
                    + "<input type=\"hidden\" name=\"id\" value=\"request.getAttribute(\"idUtente\")\">"
                    + "<input type=\"hidden\" name=\"op\" value=\"crealibretto\">"
                    + "<input type=\"submit\" value=\"Riempi libretto\">"
                    + "</form>");
            }
        %>
    </div>
</div>
