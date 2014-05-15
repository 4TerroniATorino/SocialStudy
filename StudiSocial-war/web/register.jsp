<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Registrazione</title>
        <meta name="description" content="">
        <jsp:include page="includes.jsp"></jsp:include>
        <script>
        function checkForm() {
            f = document.regForm;
            if (f.nome.value == null || f.cognome.value == null || f.numero.value == null || f.username.value == null || f.password.value == null || f.email.value == null
                    || f.nome.value == "" || f.cognome.value == "" || f.numero.value == "" || f.username.value == "" || f.password.value == "" || f.email.value == "") {
                alert("Riempi tutti i campi della registrazione");
                return false;
            }
            else
                return true;
        }
        </script>
        
        </head>
        <body>
            <div class="jumbotron">
                <div class="container">
                    <h1>Registrazione</h1>
                <% 
                    if (request.getSession().getAttribute("utente")!=null) {
                        String redirectURL = "/index.jsp";
                        response.sendRedirect(redirectURL);
                    }
                %>
                <h3> Non sei un utente registrato, compila tutti i campi e clicca su "registrati"</h3>

                    
                    <form class="form-horizontal" role="form" method="post" name="regForm" action="Registration" onkeypress="noEnter(event)" onSubmit="return(checkForm());">
                        
                        <div class="form-group">
                          <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                          <div class="col-sm-10">
                            <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="Email" value="<%= request.getAttribute("email")%>">
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label for="inputNome3" class="col-sm-2 control-label">Nome</label>
                          <div class="col-sm-10">
                            <input type="text" name="nome" value="<%= request.getAttribute("nome")%>" class="form-control" id="inputNome3" placeholder="Nome">
                          </div>
                        </div>
                          
                        <div class="form-group">
                          <label for="inputCognome3" class="col-sm-2 control-label">Cognome</label>
                          <div class="col-sm-10">
                            <input type="text" name="cognome" value="<%= request.getAttribute("cognome")%>" class="form-control" id="inputCognome3" placeholder="Cognome">
                          </div>
                        </div>
                          
                        <div class="form-group">
                          <label for="inputUsername3" class="col-sm-2 control-label">Username</label>
                          <div class="col-sm-10">
                            <input type="text" name="username" class="form-control" id="inputUsername3" placeholder="Username">
                          </div>
                        </div>
                          
                        <div class="form-group">
                          <label for="inputNumero3" class="col-sm-2 control-label">Numero</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputNumero3" placeholder="Numero +39">
                          </div>
                        </div>
                          
                        <div class="form-group">
                          <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                  <input type="checkbox"> Accetto qualunque tipo di uso legale dei miei dati :)
                                </label>
                            </div>
                          </div>
                        </div>
  
                        <div class="form-group">
                          <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" value="Registrati">Sign in</button>
                            <input type="hidden" name="deviceType" value="android">
                            <input type="hidden" name="op" value="reg">
                          </div>
                        </div>
                        
                    </form>
                    
            </div>
        </div>
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
