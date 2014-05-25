<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

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
                                <li class="active"><a href="#tab1" data-toggle="tab">Tutti</a></li>
                                <li><a href="#tab2" data-toggle="tab">Gruppi Creati</a></li>
                                <li><a href="#tab3" data-toggle="tab">Partecipante</a></li>
                                <li><a href="#tab4" data-toggle="tab">Inviti</a></li>
                            </ul>
                            <div class="tab-content">
                                <br>
                                <div class="tab-pane active" id="tab1">
                                    <c:forEach var="gruppo" items="${gruppi}">
                                        <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane" id="tab2">
                                    <c:forEach var="gruppo" items="${gruppi}">
                                        <c:if test="${gruppo.fondatore eq sessionScope.utente}">
                                            <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane" id="tab3">
                                    <c:forEach var="gruppo" items="${gruppi}">
                                        <c:forEach var="utente" items="${gruppo.utenteCollection}">
                                            <c:if test="${utente eq sessionScope.utente}">
                                                <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                                <div class="tab-pane" id="tab4">
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--<div class="col-md-4 column">

                        <ul class="nav nav-pills">
                            <li class="active">
                                <a href="#"> <span class="badge pull-right">42</span> TOT</a>
                            </li>   
                        </ul>
                    </div>--%>
                </div>
            </div>
        </div>
    </div>
                
                
    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <a href="Groups?action=createGroup">
                    <button type="button" class="btn btn-success btn-lg btn-block">Crea nuovo gruppo di studi</button>
                </a>
            </div>
        </div>
    </div>
</div>
