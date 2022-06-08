<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dove siamo</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDuo8Rhu3c6KpperiTaE9uJbt3eyh2SICk"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div style="width:100%; height:800px; margin-top:3px; margin-bottom:3px;" id=where></div>
	<%@include file="footer.jsp"%>
	
	<script>
		$(document).ready(function(){
			var posizione={lat: 40.774293, lng:14.7897807};
			var map=new google.maps.Map(document.getElementById('where'), {center:posizione, zoom:18, mapTypeId:'hybrid'});
			var marker=new google.maps.Marker({
				position:{lat:40.774293, lng:14.7897807},
				map:map,
				title:'3GTech'
			});
			
			var contentString =
				    '<div id="content">' +
				    '<h1 id="firstHeading" class="firstHeading">3GTech - World of Technology</h1>' +
				    '<div id="bodyContent">' +
				    "<p><hr style='width:100%;'> bla bla bla descrizione<br>...<br>...<br><br>Autori:<br><br> Cascone Giovanni<br>De Rosa Giuseppe<br>Tortorelli Gioacchino<hr style='width:100%;'></p>" +
				    '<p>3GTech: <a href="index">' +
				    "Visita il nostro sito!</a> " +
				    "</p>" +
				    "</div>" +
				    "</div>";
			var infoWindow=new google.maps.InfoWindow({
				content:contentString
			});
				
			marker.addListener("click",function(){
				infoWindow.open({
				      anchor: marker,
				      map,
				      shouldFocus: false,
				});
			});
		});
	</script>
</body>
</html>