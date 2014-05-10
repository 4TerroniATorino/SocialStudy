<%--
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<html class="no-js"> <!--<![endif]-->
    <head>
        <jsp:include page="includes.jsp"></jsp:include>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Incontro</h1>
                <h3><%request.getParameter("elenco")%></h3>
                <form method="post" action ="Meetings">
                    <input type="hidden" name="op" value="modMeeting">
                    <input type="submit" value="Modifica">
                </form>
                <form method="post" action ="Meetings">
                    <input type="hidden" name="id" value="<%request.getAttribute("idIncontro")%>"
                    <input type="hidden" name="op" value="delMeeting">
                    <input type="submit" value="Cancella">
                </form>
            </div>
        </div>
        <hr>
    </body>
</html>
