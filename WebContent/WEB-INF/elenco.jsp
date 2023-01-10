<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="implementazione.ProdottoImplementazioneDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Prodotti</title>
</head>
<body>

	<section class="prodottiNuovi">	
		<%
			JSONArray nuovi = new JSONArray(request.getAttribute("elenco").toString());
		    for(int i = 0; i < nuovi.length(); i++){
		    	JSONObject ob = new JSONObject(nuovi.getString(i));
		%>
			<div class="product">
				<a id=<%=ob.getBigInteger("codice")%> onClick="goTo(this.id)">
					<h2 class="TitleProduct"><%= ob.getInt("codice")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getString("nome")%></h2><hr>
					<img src="${pageContext.request.contextPath}/imageProdotto/<%= ob.getBigInteger("codice")%>/1.jpg" class="ImageProduct">
				</a>
			</div>
			<br>
		<% } %>
	</section>
</body>
</html>