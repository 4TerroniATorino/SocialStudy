<%-- 
    Document   : carriera
    Created on : 12-feb-2014, 14.52.16
    Author     : Daniele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        function addCorso(op) {
            var url = "Controller?op=" + op + "&id=" + id.value + "&method=" + method.value;
            xhrObj.open("GET", url, true);
            xhrObj.onreadystatechange = updateRis;
            xhrObj.send(null);
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carriera</title>
    </head>
    <body>
        <h2>Inserisci piano di studi</h2>
        <form method="get" action ="Login">
            Corso di studi <input type="text" name="corsodistudi"><br>
            Scegli corsi
            <% for (int i = 0; i<((String[])request.getAttribute("elenco")).length; i++) {%>
            <input type="checkbox" name="corso" value="<%= ((String[])request.getAttribute("elenco"))[i] %>"><br><%}%>
            <input type="hidden" name="op" value="riempilibretto">
            <input type="submit" value="Confema">
        </form>
    </body>
</html>
