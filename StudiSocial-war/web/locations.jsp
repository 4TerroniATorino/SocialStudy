<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--<div class="jumbotron">
    <div class="container">
        <c:if test="${empty param.id}">
            <h2>Lista locations</h2>
            <c:forEach var="location" items="${locations}">
                <p><a href="Locations?id=${location.id}">${location.descrizione} ${location.indirizzo} ${location.type}</a></p>
            </c:forEach>
        </c:if>

        <c:if test="${not empty param.id}">
            <h2>Pagina location</h2>
            <p>${location.descrizione} ${location.indirizzo} ${location.type}</p>
            <a href="Map?action=showInMap&id=${location.id}">
                <input type="submit" class="btn btn-primary btn-lg" value="Visualizza su mappa">
            </a>
        </c:if>
    </div>
</div> --%>
        
        
<div class="container">
    <div class="jumbotron">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-8 column">
					<ul class="nav nav-pills">
						<li class="active">
							 <a href="#"> <span class="badge pull-right">42</span> Lauree</a>
						</li>
						<li>
							 <a href="#"> <span class="badge pull-right">16</span> Corsi</a>
						</li>
					</ul>
					<div class="row clearfix">
						<div class="col-md-12 column">
						</div>
					</div>
				</div>
				<div class="col-md-4 column">
     <%-- Location unica: A CHE SERVE??????????? --%>
                                        <c:if test="${empty param.id}">
                                                <h2>Lista locations</h2>
                                                <c:forEach var="location" items="${locations}">
                                                    <p><a href="Locations?id=${location.id}">${location.descrizione} ${location.indirizzo} ${location.type}</a></p>
                                                </c:forEach>
                                        </c:if>
                                                    
      <%-- Lista location --%>
                                        <c:if test="${not empty param.id}">
                                            <h2>
                                                ${location.descrizione}
                                            </h2>
                                            <p>
                                                ${location.indirizzo} <br> ${location.type}
                                            </p>
                                            <p>
                                                <a class="btn" href="Map?action=showInMap&id=${location.id}">Show in map »</a>
                                            </p><img alt="140x140" src="http://lorempixel.com/140/140/" class="img-rounded">
                                        </c:if>

				</div>
			</div>
		</div>
	</div>
    </div>
</div>
