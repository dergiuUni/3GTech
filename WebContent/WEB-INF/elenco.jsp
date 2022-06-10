<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.ProdottoImplementazioneDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Prodotti</title>
</head>
<body>
	<%	ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
		String elenco=dao.elenco();
	%>
	<h1>ELENCO PRODOTTI</h1>
	<p><%=elenco%></p>
</body>
</html>