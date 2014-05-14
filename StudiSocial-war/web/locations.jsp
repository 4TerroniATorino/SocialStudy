<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<div class="jumbotron">
    <div class="container">
        <h2>Pagina location</h2>
        <%
            if(request.getAttribute("location")!=null) {
                out.print("location");
            }
            else if (request.getAttribute("locations")!=null) {
                out.print("lista locations");
            }
        %>
    </div>
</div>
