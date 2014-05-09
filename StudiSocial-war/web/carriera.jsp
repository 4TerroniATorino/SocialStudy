<%-- 
    Document   : carriera
    Created on : 12-feb-2014, 14.52.16
    Author     : Daniele
--%>

<!DOCTYPE html>
<html>
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
            var url = "Controller?op=getcorsi&corso=" + corso.value;
            xhrObj.open("GET", url, true);
            xhrObj.onreadystatechange = updateRis;
            xhrObj.send(null);
        }
    </script>
    <head>
        <title>Carriera</title>
    </head>
    <body>
        <h2>Inserisci piano di studi</h2>
        <form method="get" action ="Login">
            Corso di studi <select name="corsostudi" onchange="getCorsi(corso)"><br>
                <% String [] corsi = (String[])request.getAttribute("elenco");
                for (int i = 0; i < corsi.length; i++) {%>
                <option><%=corsi[i]%></option>
            <%}%>
            </select>

                <%-- Scegli corsi
            <% for (int i = 0; i < request.getAttribute("elenco"); i++) {%>
            <input type="checkbox" name="corso" value="<%= ((String[]) request.getAttribute("elenco"))[i]%>"><br><%}%>
            <input type="hidden" name="op" value="riempilibretto">
            <input type="submit" value="Confema">--%>
        </form>
    </body>
</html>
