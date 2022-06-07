<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.ProdottoBean" %>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="ISO-8859-1">
	<title>3GTech-Product Page</title>
	<meta name = viewport content= "width=device-width, initial-scale =1.0">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/prodotto.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/max1497px.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/max1101px.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/max864px.css">
	
	<style type="text/css">
	
		#STAR_RATING ul
		{
		 	margin: 0px;
			padding: 0px;
  			height: 16px;
  			list-style: none;
		}
		
		#STAR_RATING li{
  			width: 19px;
  			height: 16px;
  			display: block;
		 	float: left;
			background-image: url('/3GTech/images/star-off.gif.webp');
  			background-repeat: no-repeat;
  			cursor: pointer;
  		}
		#STAR_RATING li.on{
  			background-image: url('/3GTech/images/star-on.gif.webp');
		}
		#STAR_RATING span.output{
			padding: 3px;
			color: #339900;
			font-weight: bold;
		}
	</style>

	<script type="text/javascript">
		// faccio il preload dell'immagine utilizzata per l'effetto rollover
		var staron = new Image();
		staron.src = "/3GTech/images/star-on.gif.webp";

		// Definisco la funzione per la votazione che verrà lanciata all'evento onclick su una delle 5 stelle
		function star_vota(QT)
		{
 			// Creo una variabile con l'output da restituire al momento del voto
  			var star_output = '<span class="output">Hai votato ' + QT + ' stelle!</span>';
  			// Cambio dinamicamente il contenuto del DIV contenitore con il messaggio di  conferma di votazione avvenuta
 		 	document.getElementById('STAR_RATING').innerHTML = star_output;
		}

		// Definisco la funzione per "accendere" dinamicamente le stelle  unico argomento è il numero di stelle da accendere
		function star_accendi(QT)
		{
 		 	// verifico che esistano i DIV delle stelle  se il DIV non esiste significa che si è già votato
  			if (document.getElementById('star_1'))
  			{
  	  		// Ciclo tutte e 5 i DIV contenenti le stelle
   				for (i=1; i<=5; i++)
     	 		// se il div è minore o uguale del numero di stelle da accendere
     	 		// imposto dinamicamente la classe su "on"
      			if (i<=QT)
					document.getElementById('star_' + i).className = 'on';
      			else 
      				document.getElementById('star_' + i).className = '';
    		}
	 	}


		// Questa è la funzione che produce l'output.
		// richiede come unico argomento il numero di stelle che si vuole accendere  di default (possiamo in questo, ad esempio, modo mostrare il voto ottenuto nelle precedenti votazioni)
		function star(QT)
		{
  			// stampo il codice HTML che produce le stelle
  			document.write('<div id="STAR_RATING" onmouseout="star_accendi(' + QT + ')""><ul>');
 		 	document.write('<li id="star_1" onclick="star_vota(1)" onmouseover="star_accendi(0); star_accendi(1)"></li>');
  			document.write('<li id="star_2" onclick="star_vota(2)" onmouseover="star_accendi(0); star_accendi(2)"></li>');
  			document.write('<li id="star_3" onclick="star_vota(3)" onmouseover="star_accendi(0); star_accendi(3)"></li>');
  			document.write('<li id="star_4" onclick="star_vota(4)" onmouseover="star_accendi(0); star_accendi(4)"></li>');
  			document.write('<li id="star_5" onclick="star_vota(5)" onmouseover="star_accendi(0); star_accendi(5)"></li>');
  			document.write('</ul></div>');
  			// accendo le stelle definite in argomento
  			star_accendi(QT);
		}
	</script>
	
</head>

<body>
	<%@include file="header.jsp" %>
	<%@include file="navbar.jsp" %>
	<%ProdottoBean p=(ProdottoBean)request.getAttribute("prodotto"); %>
	<%String path1="/3GTech/imageProdotto/"+p.getCodice()+"/1.jpg";%>
	<%String path2="/3GTech/imageProdotto/"+p.getCodice()+"/2.jpg";%>
	<%String path3="/3GTech/imageProdotto/"+p.getCodice()+"/3.jpg";%>
	<%String path4="/3GTech/imageProdotto/"+p.getCodice()+"/4.jpg";%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		$(document).on("click", "#addCarrello", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("AjaxAggiungiAlCarrelloServlet?prodotto=" + <%=p.getCodice()%>, function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                $("#stampa").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });
	</script>
	
	<div class=containerMaxMax>
	
	<div class = parteSopra>
		
		<div class = "prodMax">
			<h2><%=p.getNome() %></h2>
			<div class = prodotto>
				<img class = "immagine" id="slider" src=<%=path1 %> alt = "Immagine Prodotto">
			</div>
		</div>
		
			<div class = "caratteristiche">
				<h1><br> CARATTERISTICHE PRODOTTO </h1>
			
				<table class = caratteristicheInterno>
					<tr><td>&nbsp;</td></tr>
					<tr class = r><td>Prezzo:</td>  <td class = vuoto1>  <td><%=p.getPrezzo() %></td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr class = r><td>Categoria</td> <td class = vuoto1> </td> <td><%=p.getTipo() %></td></tr>
					<tr><td>&nbsp;</td></tr>				
					<tr class = r><td>Costi di spedizione</td>  <td class = vuoto1>  <td>Spedizione Gratuita</td></tr>
				</table>
				
				<table class = pagamento>
				<tr> <td class = testo>Modalita di pagamento</td>
					<td class = vuoto> <img src = "${pageContext.request.contextPath}/images/paypal.jpg" height = 35 width = 50> </td>
					<td class = vuoto> <img src = "${pageContext.request.contextPath}/images/mastercard.webp" height = 35 width = 50> </td>	
					<td class = vuoto> <img src = "${pageContext.request.contextPath}/images/visa.png" height = 35 width = 50> </td>
				</table>
			</div>
		
			<div class = sliderButton>
				<table>
					<tr>
						<td><button class= buttonSx onclick="back();"></button> <br>
						<td class = space>
						<td><button style="background-image:url(<%=path1%>)" class= imm1 onclick="imm1();"></button> <br>
						<td class = space>
						<td><button style="background-image:url(<%=path2%>)" class= imm2 onclick="imm2();"></button> <br>
						<td class = space>
						<td><button style="background-image:url(<%=path3%>)" class= imm3 onclick="imm3();"></button> <br>
						<td class = space>
						<td><button style="background-image:url(<%=path4%>)" class= imm4 onclick="imm4();"></button> <br>
						<td class = space>
						<td><button class= buttonDx onclick="forward();"></button> <br>
						<td class = space>
				</table>
				<script>		
					var immagine=1;
					function imm1(){
						immagine=1;
						document.getElementById("slider").src="<%=path1 %>";
					}
					function imm2(){
						immagine=2;
						document.getElementById("slider").src="<%=path2 %>";
					}
					function imm3(){
						immagine=3;
						document.getElementById("slider").src="<%=path3 %>";
					}
					function imm4(){
						immagine=4;
						document.getElementById("slider").src="<%=path4 %>";
					}
					
					function forward(){
						if(immagine > 4) immagine = 1;
						if(immagine==1) document.getElementById("slider").src="<%=path2 %>";
						else if(immagine==2) document.getElementById("slider").src="<%=path3 %>";
						else if(immagine==3) document.getElementById("slider").src="<%=path4 %>";
						else if(immagine==4) document.getElementById("slider").src="<%=path1 %>";
						immagine++;
					}
					function back(){
						if(immagine < 1) immagine = 4;
						if(immagine==1) document.getElementById("slider").src="<%=path4 %>";
						else if(immagine==2) document.getElementById("slider").src="<%=path1 %>";
						else if(immagine==3) document.getElementById("slider").src="<%=path2 %>";
						else if(immagine==4) document.getElementById("slider").src="<%=path3 %>";
						immagine--;
					}
				</script>
			</div>
			
			<div class = carrello>
				<input id="addCarrello" class = aggiungiCarrelloButton type = image src = "${pageContext.request.contextPath}/images/pulsante-aggiungialcarrello1.png" height = 65 width = 65>
			</div>
		
		
	</div>
	</div>
	
	<div class = descrizione>
		<h2 class = descBar> Descrizione prodotto</h2>
		<div class = areaDesc>
			<p class = areadesc> <%=p.getDescrizione() %></p>
		</div>	
	</div>
	
	
	<!-- FORM PER LA RECENSIONE --> 
	<h2 class = descBar> Lascia una recensione!</h2>
	<div class = recensione>
		<form class=formRecensione action="RecensioneServlet" method="post">
			<p><b>Racconta com'è il prodotto:</b><p>
			<textarea class = recdx cols = 50 rows =10 name = recensione placeholder = "Inscerisci la tua recensione"></textarea>
			<div>
				<script type="text/javascript">star(3);</script>
				<input class=invia type=submit value=Invia>
			</div>
		</form>
	</div>
     
	<!-- PRODOTTI CORRELATI -->
		<div class=containerMax>
			<h2 class=descBar>Prodotti Consigliati</h2>
			<section class="prodottiNuovi">	
				 <% JSONArray random = new JSONArray(request.getAttribute("prodottiRandom").toString());
					for(int i = 0; i < random.length(); i++){
				    	JSONObject ob = new JSONObject(random.getString(i)); %>
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
		
	
	<%@include file="footer.jsp" %>
	<script>
		function goTo(id){
			var path="DispatcherProdottoServlet?id="+id;
			location.replace(path);
		}
	</script>
</body>

</html>