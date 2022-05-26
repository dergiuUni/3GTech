<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="ISO-8859-1">
	<title>HomePage</title>
	<link rel=stylesheet href=index.css>
	<link rel=stylesheet href=max1101px.css>
	<link rel=stylesheet href=max864px.css>
	
	<link rel=stylesheet href=../header_footer/header.css>
	
	<link rel=stylesheet href=../header_footer/footer.css>
	
	<link rel=stylesheet href=../header_footer/navbar.css>
	
</head>

<body>

	<%@include file="../header_footer/header.jsp"%>
	<%@include file="../header_footer/navbar.jsp" %>
	<!-- MENU CATEGORIE -->		
	
	<div class=containerMaxMax>
	
	<!-- PRODOTTI: NOVITA' -->
		<div class=containerMax>
			<div class=separator>&nbsp;<br>&nbsp;</div>
			<div class=sezioneProdotti><label class=sezione><strong>Novità</strong></label></div>
			<section class="prodottiNuovi">	
				<% for(int i=0; i<3; i++){ %>
					<div class="product">
						<h2 class="TitleProduct"><a href=../Prodotto/prodotto.jsp>Nome Prodotto</a></h2><hr>
						<!-- ESEMPIO PRODOTTO -->
						<img src="../images/macbook.jpg" class="ImageProduct">
						<div class="DivPrezzo">
							<article class="ArticlePrezzo">X.Y$</article>
						</div>
					</div>
				<% } %>
			</section>
		</div>
		
	<!-- PRODOTTI: OFFERTE -->
		<div class=containerMax>
			<div class=separator>&nbsp;<br>&nbsp;</div>
			<div class=sezioneProdotti><label class=sezione><strong>Prodotti in Offerta</strong></label></div>
			<section class="prodottiNuovi">	
				<% for(int i=0; i<3; i++){ %>
					<div class="product">
						<h2 class="TitleProduct"><a href=../Prodotto/prodotto.jsp>Nome Prodotto</a></h2><hr>
						<!-- ESEMPIO PRODOTTO -->
						<img src="../images/macbook.jpg" class="ImageProduct">
						<div class="DivPrezzo">
							<article class="ArticlePrezzo">X.Y$</article>
						</div>
					</div>
				<% } %>
			</section>
		</div>
		
	</div>
	
	<%@include file="../header_footer/footer.jsp" %>
</body>

</html>