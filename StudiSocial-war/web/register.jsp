<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Registrazione</title>
        <meta name="description" content="">
        <jsp:include page="includes.jsp"></jsp:include>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Registrazione</h1>
                <h3> Non sei un utente registrato, compila tutti i campi e clicca su "registrati"</h3>
                <form method="post" action ="Registration">
                    Inserisci nome <input type="text" name="nome" value="<%= request.getAttribute("nome")%>"><br>
                    Inserisci cognome <input type="text" name="cognome" value="<%= request.getAttribute("cognome")%>"><br>
                    Inserisci numero di telefono <input type="text" name="numero"><br>
                    Inserisci username <input type="text" name="username"><br>
                    Inserisci password <input type="password" name="password"><br>
                    Inserisci email <input type="text" name="email" value="<%= request.getAttribute("email")%>"><br>
                    <input type="hidden" name="deviceType" value="android">
                    <input type="hidden" name="op" value="reg">
                    <input type="submit" value="Registrati">
                </form>
            </div>
        </div>
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
