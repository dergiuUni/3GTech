<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		<title>HomePage</title>
		<link rel=stylesheet href="${pageContext.request.contextPath}/index/index.css">
		<link rel=stylesheet href="${pageContext.request.contextPath}/index/max1101px.css">
		<link rel=stylesheet href="${pageContext.request.contextPath}/index/max864px.css">
		<!-- 
		<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/header.css">
		<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/footer.css">
		<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/navbar.css">
		non serve -->
		<%@page import="java.util.ArrayList" %>
		<%@page import="java.util.Iterator" %>
		<%@page import="model.ProdottoBean" %>
	</head>
	
	<body>
	
		<%@include file="header.jsp"%>
		<%@include file="navbar.jsp" %>
		<!-- MENU CATEGORIE -->		
		
		<div class=containerMaxMax>
		
			<!-- PRODOTTI: NOVITA' -->
			<div class=containerMax>
				<div class=separator>&nbsp;<br>&nbsp;</div>
				<div class=sezioneProdotti><label class=sezione><strong>Ultimi inseriti</strong></label></div>
				<section class="prodottiNuovi">	
					<%
						JSONArray nuovi = new JSONArray(request.getAttribute("prodottiNuovi").toString());
					    for(int i = 0; i < nuovi.length(); i++){
					    	JSONObject ob = new JSONObject(nuovi.getString(i));
					%>
						<div class="product">
							<h2 class="TitleProduct"><a id=<%=ob.getBigInteger("codice")%> onClick="goTo(this.id)"><%= ob.getString("nome")%></a></h2><hr>
							<img src="${pageContext.request.contextPath}/imageProdotto/<%= ob.getBigInteger("codice")%>/1.jpg" class="ImageProduct">
							<div class="DivPrezzo">
								<article class="ArticlePrezzo"><%=ob.getInt("prezzo")%>$</article>
							</div>
						</div>
					<% } %>
				</section>
			</div>
			
			<!-- PRODOTTI: OFFERTE -->
			<div class=containerMax>
				<div class=separator>&nbsp;<br>&nbsp;</div>
				<div class=sezioneProdotti><label class=sezione><strong>Prodotti Consigliati</strong></label></div>
				<section class="prodottiNuovi">	
					<%
						JSONArray random = new JSONArray(request.getAttribute("prodottiRandom").toString());
					    for(int i = 0; i < random.length(); i++){
					    	JSONObject ob = new JSONObject(random.getString(i));
					%>
						<div class="product">
							<h2 class="TitleProduct"><a id=<%=ob.getBigInteger("codice")%> href="" onClick="goTo(this.id)"><%= ob.getString("nome")%></a></h2><hr>
							<img src="${pageContext.request.contextPath}/imageProdotto/<%= ob.getBigInteger("codice")%>/1.jpg" class="ImageProduct">
							<div class="DivPrezzo">
								<article class="ArticlePrezzo"><%=ob.getInt("prezzo")%>$</article>
							</div>
						</div>
					<% } %>
				</section>
			</div>
		</div>

		<%@include file="footer.jsp" %>
		<script>
			function goTo(id){
				var path="DispatcherProdottoServlet?id="+id;
				location.replace(path);
			}
		</script>
	</body>
</html>

<!-- 
			<div class=containerMax>
				<div class=separator>&nbsp;<br>&nbsp;</div>
				<div class=sezioneProdotti><label class=sezione><strong>Novità</strong></label></div>
				<section class="prodottiNuovi">	
					<% for(int i=0; i<3; i++){ %>
						<div class="product">
							<h2 class="TitleProduct"><a href=DispatcherProdottoServlet>Nome Prodotto</a></h2><hr>
							<img src="${pageContext.request.contextPath}/imageProdotto/1/1.jpg" class="ImageProduct">
							<div class="DivPrezzo">
								<article class="ArticlePrezzo">X.Y$</article>
							</div>
						</div>
					<% } %>
				</section>
			</div>
			
			<div class=containerMax>
				<div class=separator>&nbsp;<br>&nbsp;</div>
				<div class=sezioneProdotti><label class=sezione><strong>Prodotti in Offerta</strong></label></div>
				<section class="prodottiNuovi">	
					<% for(int i=0; i<3; i++){ %>
						<div class="product">
							<h2 class="TitleProduct"><a href=DispatcherProdottoServlet>Nome Prodotto</a></h2><hr>
							<img src="${pageContext.request.contextPath}/imageProdotto/1/1.jpg" class="ImageProduct">
							<div class="DivPrezzo">
								<article class="ArticlePrezzo">X.Y$</article>
							</div>
						</div>
					<% } %>
				</section>
			</div>
 -->