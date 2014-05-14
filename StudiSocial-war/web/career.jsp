<%-- 
    Document   : Register
    Created on : 7-feb-2014, 14.28.51
    Author     : Daniele
--%>

<html class="no-js"> <!--<![endif]-->
    <script>
        function setXMLHttpRequest() {
            var xhr = null;
            if (window.XMLHttpRequest) { // browser standard con supporto nativo
                xhr = new XMLHttpRequest();
            }
            else if (window.ActiveXObject) { // browser MS Internet Explorer - ActiveX
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xhr;
        }

        var xhrObj = setXMLHttpRequest();

        function getCorsi(corso) {
            var url = "Career?action=getcorsi&corso=" + corso.value;
            xhrObj.open("GET", url, true);
            xhrObj.onreadystatechange = updateRis;
            xhrObj.send(null);
        }

        function updateRis() {
            if (xhrObj.readyState == 4) {
                var risp = xhrObj.responseText;
                document.getElementById("corsi").innerHTML = risp;
            }
        }

    </script>
    <head>
        <jsp:include page="includes.jsp"></jsp:include>
        </head>
        <body>
            <div class="jumbotron">
                <div class="container">
                    <h2>Carriera</h2>
                    <h3>Inserisci piano di studi</h3>
                    <div id="corsostudi">
                        <form method="post" action ="Career">
                            Corso di studi <select name="corsostudi" onchange="getCorsi(corsostudi)"><br>
                            <% String[] corsi = (String[]) request.getAttribute("elenco");
                            for (int i = 0; i < corsi.length; i++) {%>
                                <option><%=corsi[i]%></option>
                            <%}%>
                            </select>
                        </form>
                    </div>
                    <div id="corsi">
                    </div>
                </div>
            <div class="divRes">
            </div>
        </div>
        <hr>
    </body>
</html>
