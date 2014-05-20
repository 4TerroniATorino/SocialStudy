<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="jumbotron">
    <div class="container">

        <%-- Lista di tutti gli utenti --%>
        <c:if test="${empty param.id}">
            <h2>Lista utenti</h2>
            <c:forEach var="user" items="${users}">
                <p><a href="Users?id=${user.id}">${user.nome} ${user.cognome}</a></p>
            </c:forEach>
        </c:if>

        <%-- Profilo unico --%>
                                    <c:if test="${not empty param.id}">

            <div style="clear: both"></div>
            <c:if test="${user.id eq sessionScope.utente.id}">
                <br><br>
                <h3>Gruppi di studio</h3>
                <c:if test="${gruppi.size() ne 0}">
                    <table class="table table-striped table-bordered">
                        <c:forEach var="gruppo" items="${gruppi}">
                            <tr><td><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></td></tr>
                        </c:forEach>
                    </table>
                </c:if>
                <form method="POST" action="Groups?action=createGroup">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" class="btn btn-primary btn-lg" value="Crea gruppo di studio">
                </form>
                <br><br>
                <h3>Libretto</h3>
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
            </c:if>
        </c:if>
    </div>
</div>

        
        

<div class="container">
    <div class="jumbotron">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-8 column">
					<h3>
						Carrer Bar
					</h3>
					<div class="progress">
						<div class="progress-bar progress-success">
						</div>
					</div>
					<ul class="nav nav-pills">
						<li class="active">
							 <a href="#"> <span class="badge pull-right">42</span> Amici</a>
						</li>
						<li>
							 <a href="#"> <span class="badge pull-right">16</span> Gruppi</a>
						</li>
					</ul>
				</div>
				<div class="col-md-4 column">
                                    <c:if test="${not empty param.id}">
                                        <h2>${user.nome} ${user.cognome} (${user.username})</h2>
                                        <div id="profile-info">
                                            <c:if test="${user.id eq sessionScope.utente.id}">
                                                <p>E-mail:${user.email}</p>
                                                <p>Numero: ${user.phoneNumber}</p>
                                                <p><a class="btn" href="#">View details »</a></p>
                                                <img alt="140x140" src="data/users/${user.id}.jpg" class="img-circle">
                                            </c:if>
                                        </div>
                                    </c:if>
				</div>
			</div>
                                        
			<blockquote>
				<p>
					Buongiorno...
				</p> <small>A Michele <cite>lorenzo e Daniele</cite></small>
			</blockquote>
		</div>
	</div>
        </div>                                
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="alert alert-dismissable alert-success">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					Alert!
				</h4> <strong>Warning!</strong> Notizie e consigli dall'agente. <a href="#" class="alert-link">alert link</a>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
			<h3 class="text-center text-primary">
				h3. Lorem ipsum dolor sit amet.
			</h3>
			<div class="btn-group">
				 <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> Left</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> Center</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-right"></em> Right</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> Justify</button>
			</div>
		</div>
		<div class="col-md-6 column">
		</div>
		<div class="col-md-4 column">
			<div class="list-group">
				 <a href="#" class="list-group-item active">Home</a>
				<div class="list-group-item">
					List header
				</div>
				<div class="list-group-item">
					<h4 class="list-group-item-heading">
						List group item heading
					</h4>
					<p class="list-group-item-text">
						...
					</p>
				</div>
				<div class="list-group-item">
					<span class="badge">14</span>Help
				</div> <a class="list-group-item active"><span class="badge">14</span>Help</a>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-6 column">
			<h3 class="text-left">
				h3. Lorem ipsum dolor sit amet.
			</h3>
			<div class="btn-group btn-group-sm">
				 <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> Left</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> Center</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-right"></em> Right</button> <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> Justify</button>
			</div>
		</div>
		<div class="col-md-6 column">
		</div>
	</div>
</div>


