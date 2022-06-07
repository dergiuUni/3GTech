<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%
			JSONArray getArray = new JSONArray(request.getAttribute("listaCarrello").toString());
		%>
			<table>
			<tr><td>Email</td><td>Password</td></tr>
			
			
			
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
	</body>
</html>