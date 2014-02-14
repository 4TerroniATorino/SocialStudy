<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrazione</title>
    </head>
    <body>
        <h2> Non sei un utente registrato, compila tutti i campi e clicca su "registrati"</h2>
        <form method="post" action ="Login">
            Inserisci nome <input type="text" name="nome" value="<%= request.getAttribute("nome")%>"><br>
            Inserisci cognome <input type="text" name="cognome" value="<%= request.getAttribute("cognome")%>"><br>
            Inserisci username <input type="text" name="username"><br>
            Inserisci password <input type="password" name="password"><br>
            Inserisci email <input type="text" name="email" value="<%= request.getAttribute("email")%>"><br>
            <input type="hidden" name="op" value="reg">
            <input type="submit" value="Registrati">
        </form>
    </body>
</html>
