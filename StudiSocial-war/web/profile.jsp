<%-- 
    Document   : profile
    Created on : 7-feb-2014, 14.59.14
    Author     : Daniele
--%>

<%@page import="ejb.Utente"%>
<%@page import="ejb.GestoreUtenti"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profilo</title>
    </head>
    <body>
        <h1>Questo è il tuo fottuto profilo, st....udente</h1>
        <%
            Utente usr = (Utente) session.getAttribute("utente");
            if(usr.getLibretto()==null)
                out.print("<form method=\"get\" action=\"Login\">"
                + "<input type=\"hidden\" name=\"op\" value=\"crealibretto\">"
                + "<input type=\"submit\" value=\"Crea libretto\">"
                + "</form>");
        %>
        
    </body>
</html>
