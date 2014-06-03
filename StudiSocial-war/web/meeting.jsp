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
                <h2>${incontro.argomento}</h2>
            </div>
        </div>
        <br>
        <div class="well">
            <div class="col-md-12 column">
                <p><strong>Gruppo</strong>:
                    <a href="Groups?action=show&id=${incontro.gruppo.id}">${incontro.gruppo.nome}</a>
                </p>
                <p><strong>Location</strong>:
                    <a href="Locations?action=show&id=${incontro.location.id}">${incontro.location.descrizione}</a>
                </p>
            </div>
        </div>
    </div>
</div>