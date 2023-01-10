<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.OrdineBean"%>
<%@page import="bean.ProdottoBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fattura</title>
<style>
th{
	border-right:1px black solid;
	border-left:1px black solid;
	padding:2px;
}
table{
	border:1px black solid;
	text-align:center;
	height:50%;
	width:50%;
}
</style>
</head>
<body>

<%
JSONArray list = new JSONArray(request.getAttribute("list").toString());
	if(list.length() == 0){
%>
	<h1>lista Vuota</h1>
<%
}
else{
	for(int i=1; i<list.length(); i++){
	JSONObject ordine = new JSONObject(list.getString(i));
	i++;
	JSONObject prodotto = new JSONObject(list.getString(i));
	%>
		FATTURA #<%=ordine.getInt("id")%>
		<table><tr><th>Prodotto</th><th>Quantità</th><th>Prezzo</th><th>Importo</th></tr>
		<tr><th><%=prodotto.getInt("codice")%></th>
			<th><%=ordine.getInt("quantitaProdotto")%></th>
			<th><%=ordine.getDouble("prezzoProdotto")%></th>
			<th><%=ordine.getDouble("prezzoProdotto") * ordine.getInt("quantitaProdotto")%></th>
		<tr><th>Data</th><th>Ora</th><th>Indirizzo</th><th>IVA</th></tr>
		<tr><th><%=ordine.getString("dataOrdine")%></th>
			<th><%=ordine.getString("orarioOrdine")%></th>
			<th><%=ordine.getString("indirizzo")%></th>
			<th><%=ordine.getInt("ivaProdotto")%>%</th></tr>
		</table><br>
		
	<%}}%>
<br>
<a href=index>Torna al sito</a>
</body>
</html>