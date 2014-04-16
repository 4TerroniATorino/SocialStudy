<%-- 
    Document   : profile
    Created on : 7-feb-2014, 14.59.14
    Author     : Daniele
--%>

<%@page import="entity.Utente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profilo</title>
        <script type="text/javascript" charset="utf-8" src="/js/cordova.js"></script>
    </head>
    <body>
        <h1>Questo è il tuo fottuto profilo, st....udente</h1>
        <%
            Utente usr = (Utente) session.getAttribute("utente");
            if(usr.getLibrettoId()==null)
                out.print("<form method=\"get\" action=\"Login\">"
                + "<input type=\"hidden\" name=\"op\" value=\"crealibretto\">"
                + "<input type=\"submit\" value=\"Crea libretto\">"
                + "</form>");
        %>
        <p>
        <button	onClick="cordova.exec(function(res){}, function(err){}, 'avviaActivity' , 'chat', [<%= usr.getPhoneNumber()%>]);">Chat</button>
       </p>
    </body>
</html>
