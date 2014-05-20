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

<%--
<div class="container">
    <div class="jumbotron">
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
      </div>
</div>          
            
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
--%>


<div class="container">
    <div class="jumbotron">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
                            
                            
                             <%--questa dovrebbe essere l'intestazione della pagina di un GRUPPO SPECIFICO.jsp --%>
                             <c:if test="${not empty gruppo}">
				<div class="col-md-8 column">
					<div class="page-header">
						<h3>
                                                    <small>Goal Bar</small>
						</h3>
					</div>
					<div class="progress">
						<div class="progress-bar progress-success">
						</div>
                                            
					</div>
				</div>
				<div class="col-md-4 column">
                                    <c:if test="${not empty gruppo}">
					<h2>
                                            ${gruppo.nome}
                                        </h2>
                                        <p>Argomenti: ${gruppo.argomenti}</p>
                                        <p>Corso di riferimento: ${corso.nome}</p>
                                        <p><small>Fondatore: ${fondatore.nome} ${fondatore.cognome} (${fondatore.username})</small></p>
                                        <p>
                                            <a class="btn" href="#">View details »</a>
                                        </p>
					<img alt="140x140" src="http://lorempixel.com/140/140/" class="img-rounded">
				    </c:if>
                                </div>
                        <blockquote>
                               
				<p>
					Esami inerenti...
				</p> <small>...architetture di sputo, <cite> database ficcanaso, reti di nonsoccosa </cite></small>
			</blockquote>
                             </c:if> 

            
                                <%--questa invece dovrebbe essere l'intestazione della PAGINA DEI UN GRUPPI CREATI dall'user.jsp --%>
                                    <c:if test="${not empty gruppi}">
                                        <div class="col-md-8 column">
                                            <div class="page-header">
                                                    <h3>
                                                         Gruppi  <%-- verificare se creati o partecipante --%>
                                                    </h3>
                                            </div>
                                                    
                                            <div class="tabbable" id="tabs-124889">
                                                <ul class="nav nav-tabs">
                                                        <li class="active">
                                                                <a href="#panel-181395" data-toggle="tab">Grppi Creati</a>
                                                        </li>
                                                        <li>
                                                                <a href="#panel-513287" data-toggle="tab">Partecipante</a>
                                                        </li>
                                                        <li>
                                                                <a href="#panel-513287" data-toggle="tab">Inviti</a>
                                                        </li>
                                                </ul>
                                                <div class="tab-content">
                                                        <div class="tab-pane active" id="panel-181395">
                                                            <br>
                                                                        <c:forEach var="gruppo" items="${groups}">
                                                                            <p><a href="Groups?action=show&id=${gruppo.id}">${gruppo.nome}</a></p>
                                                                        </c:forEach>
                                                        </div>
                                                        <div class="tab-pane" id="panel-513287">
                                                            <br>
                                                                <p>
                                                                        --> Lista dei gruppi a cui partecipo.
                                                                </p>
                                                        </div>
                                                </div>
                                            </div>
                                        </div>
                                                    
                                        <div class="col-md-4 column">
                                                        
                                            <ul class="nav nav-pills">
						<li class="active">
							 <a href="#"> <span class="badge pull-right">42</span> TOT</a>
						</li>   
                                            </ul>
                                        </div>
                                    </c:if>			
                            </div>
     
                                          <%-- questa invece quella della CREA GRUPPO.jsp --%>                                
                      
                            <c:if test="${crea}">
                                <div class="col-md-12 column">
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
                                  </div>
                            </c:if>
                </div>
        </div>
    </div> <%-- fine primo jumbotron --%>
                                          
    
    <%-- questa è la seconda parte della pagina GRUPPO SPECIFICO.jsp --%>
    <c:if test="${not empty gruppo}">
    <div class="jumbotron">                                
	<div class="row clearfix">
		<div class="col-md-3 column">
                    
			<h3 class="text-center text-primary">
				Forum
			</h3>
                    <br>
                        <a id="modal-185130" href="#modal-container-185130" role="button" class="btn" data-toggle="modal">Reply on forum</a>
			
			<div class="modal fade" id="modal-container-185130" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								Title
							</h4>
						</div>
						<div class="modal-body">
							...dovè il forum?...
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">Reply</button> <button type="button" class="btn btn-primary">Find</button>
						</div>
					</div>
					
				</div>
				
			</div>
                </div>
			
			<div class="col-md-9 column">
                            <div class="list-inline">
				<div class="list-group-item">
					<h4 class="list-group-item-heading">
						Gianvito
					</h4>
					<p class="list-group-item-text">
						Ragazzi c'è un file nascosto che dice che daniele....
					</p>
				</div>
                            </div>
			</div>
                    
	</div>
    </div>
    </c:if>   
        
	<div class="row clearfix">
		<div class="col-md-12 column">
			
		</div>
	</div>
</div>
