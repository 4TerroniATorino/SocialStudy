<%--
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<div class="jumbotron">
    <div class="container">
        <h1>Incontro</h1>
        <%
            if (request.getAttribute("incontro") != null) {
                out.print("incontro");
                //<c:out value="${person.nome} ${person.cognome}"/c:out>;
            } else if (request.getAttribute("incontri") != null) {
                out.print("lista incontri");
            }
        %>
        <form method="post" action ="Meetings">
            <input type="hidden" name="op" value="modMeeting">
            <input type="submit" value="Modifica">
        </form>
        <form method="post" action ="Meetings">
            <input type="hidden" name="id" value="${incontro.id}%>">
            <input type="hidden" name="op" value="delMeeting">
            <input type="submit" value="Cancella">
        </form>
    </div>
</div>
