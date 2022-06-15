<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrdineBean"%>
<%@page import="model.ProdottoBean"%>
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

<%ArrayList<OrdineBean> list=(ArrayList)request.getAttribute("list");
for(int i=0; i<list.size(); i++){%>
	FATTURA #<%=list.get(i).getId()%>
	<table><tr><th>Prodotto</th><th>Quantità</th><th>Prezzo</th><th>Importo</th></tr>
	<tr><th><%=list.get(i).getProdotto().getCodice()%></th>
		<th><%=list.get(i).getQuantitaProdotto()%></th>
		<th><%=list.get(i).getPrezzoProdotto()%></th>
		<th><%=list.get(i).getPrezzoProdotto() * list.get(i).getQuantitaProdotto()%></th>
	<tr><th>Data</th><th>Ora</th><th>Indirizzo</th><th>IVA</th></tr>
	<tr><th><%=list.get(i).getDataOrdine()%></th>
		<th><%=list.get(i).getOrarioOrdine()%></th>
		<th><%=list.get(i).getIndirizzo()%></th>
		<th><%=list.get(i).getIvaProdotto()%>%</th></tr>
	</table><br>
<%}%>
<br>
<a href=index>Torna al sito</a>
</body>
</html>