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
            var url = "Career?op=getcorsi&corso="+corso.value;
            xhrObj.open("GET", url, true);
            xhrObj.onreadystatechange = updateRis;
            xhrObj.send(null);
        }
        
        function updateRis() {
	if(xhrObj.readyState==4) {
            var risp = xhrObj.responseText;
            document.getElementById("divRes").innerHTML=risp;
	}
}

    </script>
    <head>
        <jsp:include page="includes.jsp"></jsp:include>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Carriera</h1>
                <h2>Inserisci piano di studi</h2>
                <form method="post" action ="Career">
                    Corso di studi <select name="corsostudi" onchange="getCorsi(this)"><br>
                    <% String [] corsi = (String[])request.getAttribute("elenco");
                    for (int i = 0; i < corsi.length; i++) {%>
                        <option><%=corsi[i]%></option>
                    <%}%>
                    </select>
                    <input type="hidden" name="idLib" value="<%request.getAttribute("idLibretto")%>">
                </form>
            </div>
            <div class="divRes">
            </div>
        </div>
        <hr>
    </body>
</html>
