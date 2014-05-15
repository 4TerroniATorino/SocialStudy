<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>

    function updateCorsi() {
        var selectedCdS = $('#corsostudi').find(":selected").text();
        $("#corsi input").each(function() {
            var toShow = ($(this).attr('class') === selectedCdS);
            if (toShow)
                $(this).closest("div").show();
            else
                $(this).closest("div").hide();
        });
    }

    $(function() {
        updateCorsi();
    });
</script>

<div class="jumbotron">
    <div class="container">
        <h2>Carriera</h2>
        <h3>Inserisci piano di studi</h3>
        <div>
                Corso di studi <select id="corsostudi" onchange="updateCorsi()"><br>
                    <option>---</option>
                    <c:forEach var="corsoDiStudi" items="${corsiDiStudi}">
                        <option>${corsoDiStudi}</option>
                    </c:forEach>
                </select>
        </div>
        <form method="POST" action="Career?action=riempilibretto">
            <div id="corsi">
                <c:forEach var="corso" items="${corsi}">
                    <div>
                        <label>
                            <input type="checkbox" name="corsiselezionati" value="${corso.id}" class="${corso.corsodistudi}">${corso.nome}
                        </label>
                        <br>
                    </div>
                </c:forEach>
            </div>
            <input type="submit" class="btn btn-primary btn-lg" value="Conferma">
        </form>
    </div>
    <div class="divRes">
    </div>
</div>