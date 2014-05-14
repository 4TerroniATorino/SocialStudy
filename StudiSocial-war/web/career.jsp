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
        $("#corsi").children().each(function() {
            var selectedCdS = $('#corsostudi').find(":selected").text();
            var toShow = !($(this).attr('class') === selectedCdS);
            $(this).prop('disabled', toShow);
        });
    }

    $(function() {
        updateCorsi();
    });
</script>
<style>
    select option[disabled] {
        display: none;
    }
</style>

<div class="jumbotron">
    <div class="container">
        <h2>Carriera</h2>
        <h3>Inserisci piano di studi</h3>
        <div>
            <form method="post" action ="Career">
                Corso di studi <select id="corsostudi" onchange="updateCorsi()"><br>
                    <option>---</option>
                    <c:forEach var="corsoDiStudi" items="${corsiDiStudi}">
                        <option>${corsoDiStudi}</option>
                    </c:forEach>
                </select>
            </form>
        </div>
        <div>
            <select id="corsi">
                <option>---</option>
                <c:forEach var="corso" items="${corsi}">
                    <option class="${corso.corsodistudi}">${corso.nome}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="divRes">
    </div>
</div>