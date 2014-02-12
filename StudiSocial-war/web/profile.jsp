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
        <br>
        <%
            Utente usr = (Utente) session.getAttribute("utente");
            if(usr.getLibretto()==null)
                out.print("Devi Inserire i dati del tuo piano carriera");
        %>
    </body>
</html>
