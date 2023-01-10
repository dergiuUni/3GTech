<%@page import="bean.ProdottoBean"%>
<%@page import="bean.OrdineBean"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Ordini</title>
</head>
<body>
	<section class="prodottiNuovi">	
		<%
			JSONArray nuovi = new JSONArray(request.getAttribute("elenco").toString());
		    for(int i = 0; i < nuovi.length(); i++){
		    	JSONObject ob = new JSONObject(nuovi.getString(i));
		%>
			<div class="product">
					<h2 class="TitleProduct"><%= ob.getInt("id")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getInt("ivaProdotto")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getString("orarioOrdine")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getDouble("prezzoProdotto")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getString("indirizzo")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getString("dataOrdine")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getInt("quantitaProdotto")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getJSONObject("prodotto").getInt("codice")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getJSONObject("prodotto").getString("nome")%></h2><hr>
					<h2 class="TitleProduct"><%= ob.getJSONObject("prodotto").getString("descrizione")%></h2><hr> 
			</div>
			<br>
		<% } %>
	</section>
</body>
</html>