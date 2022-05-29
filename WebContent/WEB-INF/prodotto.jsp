<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="ISO-8859-1">
	<title>3GTech-Product Page</title>
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/prodotto.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/max1497px.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/max1101px.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/prodotto/max864px.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/header.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/navbar.css">
	<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/footer.css">
	
	<style type="text/css">
#STAR_RATING ul
{
  margin: 0px;
  padding: 0px;
  height: 16px;
  list-style: none;
}
#STAR_RATING li
{
  width: 19px;
  height: 16px;
  display: block;
  float: left;
  background-image: url('/TSWProject/WebContent/images/star-off.gif.webp);
  background-repeat: no-repeat;
  cursor: pointer;
}
#STAR_RATING li.on
{
  background-image: url('/TSWProject/WebContent/images/star-on.gif.webp');
}
#STAR_RATING span.output
{
  padding: 3px;
  color: #339900;
  font-weight: bold;
}
</style>

<script type="text/javascript">
// faccio il preload dell'immagine utilizzata per l'effetto rollover
var staron = new Image();
staron.src = "/TSWProject/WebContent/images/star-on.gif.webp";

// Definisco la funzione per la votazione che verrà lanciata
// all'evento onclick su una delle 5 stelle
function star_vota(QT)
{
  // Creo una variabile con l'output da restituire al momento del voto
  var star_output = '<span class="output">Hai votato ' + QT + ' stelle!</span>';
  // Cambio dinamicamente il contenuto del DIV contenitore con il messaggio di
  // conferma di votazione avvenuta
  document.getElementById('STAR_RATING').innerHTML = star_output;
}

// Definisco la funzione per "accendere" dinamicamente le stelle
// unico argomento è il numero di stelle da accendere
function star_accendi(QT)
{
  // verifico che esistano i DIV delle stelle
  // se il DIV non esiste significa che si è già votato
  if (document.getElementById('star_1'))
  {
    // Ciclo tutte e 5 i DIV contenenti le stelle
    for (i=1; i<=5; i++)
    {
      // se il div è minore o uguale del numero di stelle da accendere
      // imposto dinamicamente la classe su "on"
      if (i<=QT) document.getElementById('star_' + i).className = 'on';
      // in caso contrario spengo la stella...
      else document.getElementById('star_' + i).className = '';
    }
  }
}

// Questa è la funzione che produce l'output.
// richiede come unico argomento il numero di stelle che si vuole accendere
// di default (possiamo in questo, ad esempio, modo mostrare il voto ottenuto
// nelle precedenti votazioni)
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
	
	<div class=containerMaxMax>
	
	
	
	<div class = parteSopra>
	
	<div class = "prodMax">
		<h2>NOME PRODOTTO</h2>
		<img class = "prodotto" src = "../images/macbook.jpg"  alt = "Immagine prodotto" title = Macbook height = 320 width = 320>
		
	</div>
	
	
	
	<div>
		<div class = "caratteristiche">
			<h1><br> CARATTERISTICHE PRODOTTO </h1>
			
			<table class = caratteristicheInterno>
				<tr><td>&nbsp;</td></tr>
				<tr class = r><td>Prezzo:</td>  <td class = vuoto1>  <td>prezzo</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr class = r><td>Classe energetica:</td>  <td class = vuoto1>  <td>A+</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr class = r><td>Categoria</td> <td class = vuoto1> </td> <td>Dato</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr class = r><td>Tempo di spedizione</td>  <td class = vuoto1> <td>Dato</td></tr>
				<tr><td>&nbsp;</td></tr>				
				<tr class = r><td>Costi di spedizione</td>  <td class = vuoto1>  <td>Dato</td></tr>
				<tr><td>&nbsp;</td></tr>				
				<tr ><td class = r>Modalità di pagamento</td>
					<td >&nbsp;</td>
					<td class = vuoto> <img src = "../images/paypal.jpg" height = 35 width = 50> </td>
					<td class = vuoto> <img src = "../images/mastercard.webp" height = 35 width = 50> </td>
					<td class = vuoto> <img src = "../images/visa.png" height = 35 width = 50> </td>
				</tr>
				<tr><td>&nbsp;</td></tr>				
				<tr><td>&nbsp;</td></tr>			
				<tr><td>&nbsp;</td></tr>			
			</table>
			<table>
				<tr><td class = aggiungiCarrello> Aggiungi al carrello</td>
					<td class = vuoto2> <td> <img src = "../images/frecciadx.webp" width = 90 height = 60> <td class = vuoto2> 
					<td>  <input class = aggiungiCarrelloButton type = image src = "../images/carrello.png" height = 65 width = 65> </td>
				</tr>
			</table>
		</div>
	</div>
	</div>
	
		<div class = descrizione>
		<h2 class = descBar> Descrizione prodotto</h2>
			<table>
				<tr ><td></td>
					<td class = r1>Marca</td> 
					<td class = r1>Modello</td> 
					<td class = r1>Condizione</td> 
					<td class = r1>Processore</td> 
					<td class = r1>RAM</td> 
					<td class = r1>Batteria</td> 
					<td class = r1>Storage</td> 
					<td class = r1>Display</td> 
					<td class = r1>Contenuto del pacco</td> 
				</tr><tr >
					<td class = r1>Caratteristiche</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
					<td>XXXXXXXXX</td>
				</tr>
			</table>
			<h3> Descrizione:</h3>
			<div class = areaDesc>
				<p> descrzionenenen</p>
			</div>	
	</div>
	
	<!-- FORM PER LA RECENSIONE --> 
	<h2 class = sezioneProdotti> Lascia una recensione!</h2>
	<div class = recensione>
		<form action="RecensioneServlet" method="post">
		<div class = sinistra>
		<p class = dati> <b>Inserisci i dati:</b></p>
			<input class = recsx name = Username type = text placeholder = "Inserisci il tuo username">
			<input class = recsx type="text" name="nome" placeholder = "Inserisci il titolo della recensione">
			<script type="text/javascript">star(3);</script>
		</div>
		<div class = destra>
		<p><b>Racconta com'è il prodotto:</b><p>
				<textarea class = recdx cols = 50 rows =10 name = recensione></textarea>
		</div>
		<input class=invia type=submit value=Invia>
			</form>
	</div>
	<!-- 
	<div class=page>
        <div class="login-page">
        	<form action="RegistrazioneServlet" method="post" onSubmit="return validateReg();">
            	<input class=form-input id="nome" name=nome type=text placeholder="Nome" autofocus onblur="onBlurName(this);"/>
        		<input class=form-input id=cognome name=cognome type=text placeholder="Cognome" onBlur="onBlurSurname(this);"/>
        		<input class=form-input id=indirizzo name=indirizzo type=text placeholder="Indirizzo (<Via/Piazza/...> <Nome> <Civico>)" onBlur="onBlurAddress(this);"/>
        		<input class=form-input id=telefono name=telefono type=text placeholder="Telefono (10 cifre)" onBlur="onBlurPhone(this);"/>
            	<input class=form-input id=email name=email type=text placeholder="E-mail (es. 3GTech@studenti.unisa.it)" onBlur="onBlurEmail(this);"/>
                <input class=form-input id=password name=password type="password" placeholder="Password (Almeno 8 caratteri)" onBlur="onBlurPassword(this);"/>
                <div id=strength>
                	<span id=low></span>
                	<span id=medium></span>
                	<span id=strong></span>
                </div>
                <input class=submit type=submit value=Registrati>
                <p class="message">Sei già registrato? <a href="../login/LoginHTML.html">Accedi</a></p>
            </form>
            <p id=error></p>
        </div>
     </div>  -->
	
	<!--  FORM PER LA RECENSIONE-->
<!-- 
	<h2 class = sezioneProdotti> Lascia una recensione!</h2>
		<div class =rec>
		<form action="RecensioneServlet" method="post" onSubmit="return validateReg();">
			Username:
			<input class = recsx name = Username type = text placeholder = "Inserisci il tuo username">
			Valutazione: 
			<input class = recsx name = valutazione type = range>
			Titolo:
			<input class = recdx name = titolo type = text placeholder = "Inserisci il titolo della recensione...">
			Testo recensione:
			<input class = recdx name = Testo type = text placeholder = "Scrivi la tua recensione...">
			<input class=invia type=submit value=Invia>
		</form>
		</div>
		
-->
			
		
			
     
	<!-- PRODOTTI CORRELATI -->
		<div class=containerMax>
			<h2 class=sezioneProdotti> Prodotti Correlati</h2>
			<section class="prodottiNuovi">	
				 <% for(int i=0; i<3; i++){ %>
						<div class="product">
						<h2 class="TitleProduct">Nome Prodotto</h2><hr>
						<!-- ESEMPIO PRODOTTO-->
						<img src="${pageContext.request.contextPath}/imageProdotto/1/1.jpg" class="ImageProduct">
						<div class="DivPrezzo">
							<article class="ArticlePrezzo">X.Y$</article>
						</div>
					</div>
				<% } %>
			</section>
		</div>
		
	</div>
	
	<%@include file="footer.jsp" %>
</body>

</html>