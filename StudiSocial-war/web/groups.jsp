<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
    function checkForm() {
        f = document.createForm;
        if (f.nome.value === null || f.argomenti.value === null || f.nome.value === "" || f.argomenti.value === "") {
            alert("Riempi tutti i campi");
            return false;
        }
        else
            return true;
    }
</script>

<div class="jumbotron">
    <div class="container">
        <c:if test="${crea}">
            <h2>Crea nuovo gruppo di studio</h2>
            <form id="myForm" method="post" name="createForm" action="Groups?action=addGroup" onkeypress="noEnter(event)" onSubmit="return(checkForm());">
                Inserisci nome <input class="form-control" type="text" name="nome"><br>
                Inserisci argomenti <input class="form-control" type="text" name="argomenti"><br>
                Corsi di riferimento (facoltativo)
                <select name="corso" class="form-control">
                    <option value="-1">Nessuno</option>
                    <c:forEach var="corso" items="${libretto}">
                        <option value="${corso.id}">${corso.nome}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="hidden" name="deviceType" value="android">
                <input type="submit" class="btn btn-primary btn-lg" value="Crea gruppo">
            </form>
        </c:if>
        <c:if test="${not empty gruppi}">
            <h2>Gruppi creati</h2>
            <c:forEach var="gruppo" items="${groups}">
                <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
            </c:forEach>
        </c:if>
        <c:if test="${not empty gruppo}">
            <h2>Pagina del gruppo</h2>
            <p>Nome del gruppo: ${gruppo.nome}</p>
            <p>Argomenti: ${gruppo.argomenti}</p>
            <p>Fondatore: ${fondatore.nome} ${fondatore.cognome} (${fondatore.username})</p>
            <c:if test="${not empty corso}">
                <p>Corso di riferimento: ${corso.nome}</p>
            </c:if>
        </c:if>
    </div>
</div>