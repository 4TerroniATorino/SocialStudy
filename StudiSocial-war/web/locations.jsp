<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container">
    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    
                    <div class="col-md-12 column">
                        <div class="page-header">
                            <h2>Gruppi</h2>
                        </div>

                        <div class="tabbable">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1" data-toggle="tab">Dipartimenti</a></li>
                                <li><a href="#tab2" data-toggle="tab">Aulee Studio</a></li>
                                <li><a href="#tab3" data-toggle="tab">Bibilioteche</a></li>
                            </ul>
                            <div class="tab-content">
                                <br>
                                <div class="tab-pane active" id="tab1">
                                    <c:forEach var="location" items="${locations1}">
                                        <p><a href="Location?id=${location.id}">${location.descrizione}</a></p>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane" id="tab2">
                                    <c:forEach var="location" items="${locations2}">
                                        <p><a href="Location?id=${location.id}">${location.descrizione}</a></p>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane" id="tab3">
                                    <c:forEach var="location" items="${locations3}">
                                        <p><a href="Location?id=${location.id}">${location.descrizione}</a></p>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane" id="tab4">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
