<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Carrello</title>
	<link rel=stylesheet href="${pageContext.request.contextPath}/carrello/carrello.css">
	</head>
	
	<body>
		<%@include file="header.jsp" %>
		<div class=cart>
		<%
			JSONArray getArray = new JSONArray(request.getAttribute("listaCarrello").toString());
		%>
			<table>
			<%
			  for(int i = 0; i < getArray.length(); i++){
				  JSONObject ob = new JSONObject(getArray.getString(i));
			%>
			<tr>
			  <td><%=ob.getInt("codice")%><td>
			  <td><%=ob.getString("descrizione")%><td>
			  <td><%=ob.getInt("quantitaCarrello")%><td>
			</tr> 
			<%
			 }
			%>
			</table>
		</div>
		<%@include file="footer.jsp" %>
	</body>
</html>