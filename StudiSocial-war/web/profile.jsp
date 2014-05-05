<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Profilo</title>
        <meta name="description" content="">
        <jsp:include page="includes.jsp"></jsp:include>
        <script src="js/cordova.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <div class="jumbotron">
            <div class="container">
                <h1>Questo è il tuo fottuto profilo, st....udente</h1>
                <%@page import="entity.Utente"%>
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
            </div>
        </div>
        
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
