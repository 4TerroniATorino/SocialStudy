<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Mappa</title>
        <meta name="description" content="">
        <jsp:include page="includes.jsp"></jsp:include>

            <style type="text/css">
                #map {
                    width: available;
                    height: 600px;
                }
            </style>

            <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASm3CwaK9qtcZEWYa-iQwHaGi3gcosAJc&sensor=false"></script>
            <script type="text/javascript">
                google.maps.event.addDomListener(window, 'load', init);

                function init() {
                    var mapOptions = {
                        zoom: 11,
                        center: new google.maps.LatLng(45.076, 7.670),
                        styles: [{featureType: 'water', elementType: 'geometry', stylers: [{hue: '#165c64'}, {saturation: 34}, {lightness: -69}, {visibility: 'on'}]}, {featureType: 'landscape', elementType: 'geometry', stylers: [{hue: '#b7caaa'}, {saturation: -14}, {lightness: -18}, {visibility: 'on'}]}, {featureType: 'landscape.man_made', elementType: 'all', stylers: [{hue: '#cbdac1'}, {saturation: -6}, {lightness: -9}, {visibility: 'on'}]}, {featureType: 'road', elementType: 'geometry', stylers: [{hue: '#8d9b83'}, {saturation: -89}, {lightness: -12}, {visibility: 'on'}]}, {featureType: 'road.highway', elementType: 'geometry', stylers: [{hue: '#d4dad0'}, {saturation: -88}, {lightness: 54}, {visibility: 'simplified'}]}, {featureType: 'road.arterial', elementType: 'geometry', stylers: [{hue: '#bdc5b6'}, {saturation: -89}, {lightness: -3}, {visibility: 'simplified'}]}, {featureType: 'road.local', elementType: 'geometry', stylers: [{hue: '#bdc5b6'}, {saturation: -89}, {lightness: -26}, {visibility: 'on'}]}, {featureType: 'poi', elementType: 'geometry', stylers: [{hue: '#c17118'}, {saturation: 61}, {lightness: -45}, {visibility: 'on'}]}, {featureType: 'poi.park', elementType: 'all', stylers: [{hue: '#8ba975'}, {saturation: -46}, {lightness: -28}, {visibility: 'on'}]}, {featureType: 'transit', elementType: 'geometry', stylers: [{hue: '#a43218'}, {saturation: 74}, {lightness: -51}, {visibility: 'simplified'}]}, {featureType: 'administrative.province', elementType: 'all', stylers: [{hue: '#ffffff'}, {saturation: 0}, {lightness: 100}, {visibility: 'simplified'}]}, {featureType: 'administrative.neighborhood', elementType: 'all', stylers: [{hue: '#ffffff'}, {saturation: 0}, {lightness: 100}, {visibility: 'off'}]}, {featureType: 'administrative.locality', elementType: 'labels', stylers: [{hue: '#ffffff'}, {saturation: 0}, {lightness: 100}, {visibility: 'off'}]}, {featureType: 'administrative.land_parcel', elementType: 'all', stylers: [{hue: '#ffffff'}, {saturation: 0}, {lightness: 100}, {visibility: 'off'}]}, {featureType: 'administrative', elementType: 'all', stylers: [{hue: '#3a3935'}, {saturation: 5}, {lightness: -57}, {visibility: 'off'}]}, {featureType: 'poi.medical', elementType: 'geometry', stylers: [{hue: '#cba923'}, {saturation: 50}, {lightness: -46}, {visibility: 'on'}]}]
                    };

                    new google.maps.Map(document.getElementById('map'), mapOptions);
                }
            </script>
        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div id="map"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
