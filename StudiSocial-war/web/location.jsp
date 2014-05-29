<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container">
    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-2 column">
                <img alt="140x140" src="http://lorempixel.com/140/140/" class="img-rounded">
            </div>
            <div class="col-md-10 column">
                <h2>${location.descrizione}</h2>
            </div>
        </div>
        <br>
        <div class="well">
            <div class="col-md-12 column">
                <p><strong>Indirizzo</strong>: ${location.indirizzo}</p>
                <p><strong>Tipo</strong>: ${location.type}</p>
            </div>
        </div>
        <br>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <a href="Map?action=showInMap&id=${location.id}">
                    <button type="button" class="btn btn-success btn-lg btn-block">Mostra nella mappa</button>
                </a>
            </div>
        </div>
    </div>
</div>