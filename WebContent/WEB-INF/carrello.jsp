<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Carrello</title>
	<link rel=stylesheet href="${pageContext.request.contextPath}/carrello/carr.css">
	</head>	
	
	
	<body>
		<%@include file="header.jsp" %>
		<div class = prodotto>
		<%
			JSONArray getArray = new JSONArray(request.getAttribute("listaCarrello").toString());
		%>
			<%if(getArray.length() == 0){%>
				<h1 class  = vuoto><b>IL CARRELLO E VUOTO!</b></h1>
			<%
			}
			%>
			<%
			  for(int i = 0; i < getArray.length(); i++){
				  JSONObject ob = new JSONObject(getArray.getString(i));
			%>
			<table class = tabella>
			<%String path1="/3GTech/imageProdotto/"+ob.getInt("codice")+"/1.jpg";%>
			<tr class = prodotto>
				<td class = nome><b><%=ob.getString("nome")%></b></td>
				<td class = desc><b>DESCRIZIONE</b></td>
				<td class = q> <b>QUANTITA</b></td>
			</tr>
			<tr >
			  <td class = rigaImg> <img src = "<%=path1%>" height = 300px width = 300px> </td> 
			  <td class = rigaDesc><%=ob.getString("descrizione")%></td>
			  <td class = rigaQ><%=ob.getInt("quantitaCarrello")%></td>
			 
			</tr> 
			<tr>&nbsp;</tr>	
			</table>
			<div>
				<input id="addCarrello" class = acquista type = image src = "${pageContext.request.contextPath}/images/acquistaOra.png" height = 80 width = 250>
				<a href="DispatcherAcquistaCarrello">test</a>
			</div>
			<%
			 }
			%>
			
		</div>
		
		
		
		<%@include file="footer.jsp" %>
	</body>
</html>