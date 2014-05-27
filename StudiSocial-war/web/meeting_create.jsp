<%-- 
    Document   : group_create
    Created on : 25-may-2014
    Author     : Lorenzo
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

<div class="container">
    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h2>Crea nuovo incontro nel gruppo ${idGruppo}</h2>
                        <form id="myForm" method="post" name="createForm" action="Meetings?action=addIncontro" onkeypress="noEnter(event)" onSubmit="return(checkForm());">
                            Inserisci data <input class="form-control" type="text" name="data"><br>
                            Inserisci argomento <input class="form-control" type="text" name="argomento"><br>
                            Location (facoltativo)
                            <select name="location" class="form-control">
                                <option value="-1">Nessuno</option>
                                <c:forEach var="location" items="${locations}">
                                    <option value="${location.id}">${location.descrizione}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <input type="hidden" name="deviceType" value="android">
                            <input type="hidden" name="idGruppo" value="${idGruppo}">
                            <input type="submit" class="btn btn-primary btn-lg" value="Crea incontro">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
