<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->

<style type="text/css">
    #map {
        width: available;
        height: 600px;
    }
</style>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASm3CwaK9qtcZEWYa-iQwHaGi3gcosAJc&sensor=false"></script>
<script type="text/javascript">
    
    var map;
    var markers = {};
    
    google.maps.event.addDomListener(window, 'load', init);
    
    function infoRow(key, value, link) {
        if (value && value.length > 0) {
            string = '<strong>' + key + '</strong>: ';
            if ('undefined' === typeof link) string += value;
            else string += '<a href=' + link + ' target="_blank">' + value + '</a>';
            return string + '<br/>';
        }
        return '';
    };

    function init() {
        var mapOptions = {
            zoom: 13,
            center: new google.maps.LatLng(45.076, 7.670),
            styles: [{"featureType":"poi","stylers":[{"visibility":"off"}]},{"stylers":[{"saturation":-70},{"lightness":37},{"gamma":1.15}]},{"elementType":"labels","stylers":[{"gamma":0.26},{"visibility":"off"}]},{"featureType":"road","stylers":[{"lightness":0},{"saturation":0},{"hue":"#ffffff"},{"gamma":0}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"lightness":20}]},{"featureType":"road.highway","elementType":"geometry","stylers":[{"lightness":50},{"saturation":0},{"hue":"#ffffff"}]},{"featureType":"administrative.province","stylers":[{"visibility":"on"},{"lightness":-50}]},{"featureType":"administrative.province","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"administrative.province","elementType":"labels.text","stylers":[{"lightness":20}]}]
        };

        map = new google.maps.Map(document.getElementById('map'), mapOptions);
        
        <c:forEach var="location" items="${locations}">
            if ('${location.type}' === 'Dipartimento'){
                icon = 'pin-blue-solid-11.png';
            } else if ('${location.type}' === 'Biblioteca'){
                icon = 'pin-green-solid-3.png';
            } else {
                icon = 'pin-red-solid-12.png';
            }
            
            infoWindowContent = '<div id="content">';
            infoWindowContent += '<h3><a href="Location?id='+ ${location.id} +'">${fn:escapeXml(location.descrizione)}</a></h3>';
            infoWindowContent += '<p>Indirizzo: <b>${fn:escapeXml(location.indirizzo)}</b></p>';
            infoWindowContent += '</div>';
            
            markers[${location.id}] = new google.maps.Marker({
                map: map,
                animation: google.maps.Animation.DROP,
                position: new google.maps.LatLng(${location.lat}, ${location.lng}),
                draggable:false,
                icon: 'img/markers/' + icon,
                infoWindow: new google.maps.InfoWindow({
                    content: infoWindowContent,
                    maxWidth: 300
                })
            });
            
            google.maps.event.addListener(markers[${location.id}], 'click', function() {
		closeInfoWindow();
		markers[${location.id}].infoWindow.open(map, markers[${location.id}]);
            });
        </c:forEach>
    }
    
    function closeInfoWindow(){
	for (m in markers){markers[m].infoWindow.close();}
    }
</script>
<div id="map"></div>

