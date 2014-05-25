<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container">
    <c:if test="${empty param.id}">
        <div class="jumbotron">
            <div class="row clearfix">
                <h2>Lista utenti</h2>
                <c:forEach var="user" items="${users}">
                    <p><a href="Users?id=${user.id}">${user.nome} ${user.cognome}</a></p>
                </c:forEach>
            </div>
        </div>
    </c:if>

    <c:if test="${not empty param.id}">
        <div class="jumbotron">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-7 column">
                            <h3>Carrer Bar</h3>
                            <div class="progress">
                                <div class="progress-bar progress-success">
                                </div>
                            </div>
                            <br>
                            <ul class="nav nav-pills">
                                <li class="active">
                                    <a href="#"> <span class="badge pull-right">42</span> Amici</a>
                                </li>
                                <li>
                                    <a href="#"> <span class="badge pull-right">16</span> Gruppi</a>
                                </li>
                            </ul>
                        </div>

                        <div class="col-md-5 column">
                            <h2>${user.nome} ${user.cognome} (${user.username})</h2>
                            <img alt="140x140" src="data/users/${user.id}.jpg" class="img-circle">
                            <br><br>
                            <c:if test="${user.id eq sessionScope.utente.id}">
                                <p>E-mail: ${user.email}</p>
                                <p>Numero: ${user.phoneNumber}</p>
                                <p><a class="btn" href="#">View details »</a></p>
                            </c:if>
                        </div>
                    </div>
                    <blockquote>
                        <p>Buongiorno...</p>
                        <small>...stamattina <cite> adda studià !! :D</cite></small>
                    </blockquote>
                </div>
            </div>
        </div>
                            
        <c:if test="${user.id eq sessionScope.utente.id}">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="alert alert-dismissable alert-success">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>Alert!</h4>
                        <strong>Warning!</strong> Devi dare l'esame di SSCWEB. <a href="#" class="alert-link">alert link</a>
                    </div>
                </div>
            </div>

            <div class="jumbotron">                                
                <div class="row clearfix">
                    <div class="col-md-4 column">
                        <h3 class="text-center text-primary">Libretto</h3>
                        <div class="btn-group">
                            <c:if test="${libretto.size() eq 0}">
                                <form method="POST" action="Career?action=crealibretto">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <input type="submit" class="btn btn-primary btn-lg" value="Inserisci piano di studi">
                                </form>
                            </c:if>
                            <c:if test="${libretto.size() ne 0}">
                                <table class="table table-striped table-bordered">
                                    <tr><th>Materia</th><th>Voto</th></tr>
                                            <c:forEach var="voto" items="${libretto}">
                                        <tr><td>${voto.corso.nome}</td><td>${voto.voti}</td></tr>
                                    </c:forEach>
                                </table>
                            </c:if>
                            <button class="btn btn-default" type="button">Create</button>
                            <button class="btn btn-default" type="button"> View</button>
                            <button class="btn btn-default" type="button"> Add</button>
                            <button class="btn btn-default" type="button"> Delete</button>
                        </div>
                    </div>
                    <div class="col-md-4 column">
                        ...
                    </div>
                    <div class="col-md-4 column">
                        <div class="list-group">
                            <a href="#" class="list-group-item active">Materie</a>
                            <div class="list-group-item">Lista Materie</div>
                            <div class="list-group-item">
                                <h4 class="list-group-item-heading">Materia</h4>
                                <p class="list-group-item-text">Argomenti</p>
                            </div>
                            <div class="list-group-item">
                                <span class="badge">14</span>List
                            </div> <a class="list-group-item active"><span class="badge">14</span>List</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="jumbotron">
                <div class="row clearfix">
                    <div class="col-md-6 column">
                        <h3 class="text-left">Gruppi di studio</h3>
                        <c:if test="${gruppi.size() ne 0}">
                            <table class="table table-striped table-bordered">
                                <c:forEach var="gruppo" items="${gruppi}">
                                    <tr><td><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></td></tr>
                                </c:forEach>
                            </table>
                        </c:if>
                        <div class="btn-group btn-group-sm">
                            <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> Left</button>
                            <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> Center</button>
                            <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-right"></em> Right</button>
                            <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> Justify</button>
                        </div>
                    </div>
                    <div class="col-md-6 column">
                        <form method="POST" action="Groups?action=createGroup">
                            <input type="submit" class="btn btn-primary btn-lg" value="Crea gruppo di studio">
                        </form>
                        <form method="POST" action="Groups?action=inviteGroup">
                            <input type="hidden" name="id" value="${user.id}">
                            <input type="submit" class="btn btn-primary btn-lg" value="Invita ad gruppo di studio">
                        </form>    
                    </div>
                </div>
            </div>
        </c:if>
    </c:if>
</div>