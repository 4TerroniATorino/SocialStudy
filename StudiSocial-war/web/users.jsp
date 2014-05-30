<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
    $(function() {
        
        $("#rigaAggiungi").hide();
        $("#addButton").click(function() {
            $("#rigaAggiungi").show();
            $("#addButton").hide();
            $("#deleteButton").hide();
            $("#addButton").after('<button id="confirmButton" class="btn btn-default" type="button"> Conferma</button>');
            $("#confirmButton").click(function() {
                /*$("addCorsoForm").ajaxSubmit({
                    type : "POST",
                    url : "",
                    timeout : 20000,
                    success : function(data) {
                    },
                    error: function(e) {
                    } 
                });*/
                $("addCorsoForm").submit();
            });
        });
    });
</script>

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
                            <div class="clearfix">
                                <img alt="140x140" src="${user.picture}" class="img-circle profile-picture">
                            </div>
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
                    <div class="col-md-12 column">
                        <h3 class="text-center text-primary">Libretto</h3>
                        <c:if test="${libretto.size() eq 0}">
                            <form method="POST" action="Career?action=crealibretto">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="submit" class="btn btn-primary btn-lg" value="Inserisci piano di studi">
                            </form>
                        </c:if>
                        <c:if test="${libretto.size() ne 0}">
                            <table id="materieTable" class="table table-striped table-bordered">
                                <tr><th>Materia</th><th>Voto</th></tr>
                                <c:forEach var="voto" items="${libretto}">
                                    <tr><td>${voto.corso.nome}</td><td>${voto.voti}</td></tr>
                                </c:forEach>
                            </table>
                            <form method="POST" action="Career?action=addCorso">
                                <select class="form-control" name="corso">
                                    <c:forEach var="corso" items="${corsiNonInLibretto}">
                                        <option value="${corso.id}">${corso.nome}</option>
                                    </c:forEach>
                                </select>
                            </form>
                        </c:if>
                        <button id="addButton" class="btn btn-default" type="button"> Aggiungi corso</button>
                        <button id="deleteButton" class="btn btn-default" type="button"> Elimina corso</button>
                    </div>
                </div>
            </div>

            <div class="jumbotron">
                <div class="row clearfix">
                    <div class="tabbable">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab2" data-toggle="tab">Gruppi Creati</a></li>
                            <li><a href="#tab3" data-toggle="tab">Partecipante</a></li>
                            <li><a href="#tab4" data-toggle="tab">Inviti</a></li>
                        </ul>
                        <div class="tab-content">
                            <br>
                            <div class="tab-pane active" id="tab2">
                                <c:forEach var="gruppo" items="${gruppiFondati}">
                                    <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
                                </c:forEach>
                            </div>
                            <div class="tab-pane" id="tab3">
                                <c:forEach var="gruppo" items="${gruppi}">
                                    <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
                                </c:forEach>
                            </div>
                            <div class="tab-pane" id="tab4">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </c:if>
</div>