<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAGINA ADMIN</title>
<link rel=stylesheet href="${pageContext.request.contextPath}/gestione/gestione.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"></script>
</head>
<body>
	<script src="${pageContext.request.contextPath}/gestione/gestione.js"></script>
	<script>
	function validateProduct(){
		var nome=document.getElementById("nome");
		var descrizione=document.getElementById("descrizione");
		var prezzo=document.getElementById("prezzo");
		var errore=document.getElementById("error");
		
		if(nome.value.length<1 || nome.value.length>100){
			css(errore);
			errore.innerHTML="<b>ERRORE:</b>Inserisci nome correttamente!";
			console.log("Sono caduto in errore nome");
			return false;
		}
		
		if(descrizione.value.length>300){
			css(errore);
			errore.innerHTML="<b>ERRORE:</b>Inserisci descrizione correttamente!";
			console.log("Sono caduto in errore descrizione");
			return false;
		}
		
		if(prezzo.value < 0.01){
			css(errore);
			errore.innerHTML="<b>ERRORE:</b>Inserisci prezzo correttamente!";
			console.log("Sono caduto in errore prezzo");
			return false;
		}
		return true;
	}
	
	function validateModifica(){
		var descrizione=document.getElementById("descrizioneModifica");
		var prezzo=document.getElementById("prezzoModifica");
		var errore=document.getElementById("error");
		
		if(descrizione.value.length>300 || descrizione.value.length==0){
			css(errore);
			errore.innerHTML="<b>ERRORE:</b>Inserisci descrizione correttamente!";
			console.log("Sono caduto in errore descrizione");
			return false;
		}
		
		if(prezzo.value < 0.01){
			css(errore);
			errore.innerHTML="<b>ERRORE:</b>Inserisci prezzo correttamente!";
			console.log("Sono caduto in errore prezzo");
			return false;
		}
		return true;
	}
	
	function css(errore){
		errore.style.textAlign="center";
	    errore.style.padding="4% 0 0 2%";
		errore.style.backgroundColor="#fcdde8";
		errore.style.fontFamily="Roboto";
		errore.style.height="35px";
	  	errore.style.outlineWidth="3px";
	    errore.style.outlineColor="#663344";
	 	errore.style.outlineStyle="solid";
	 	errore.style.fontSize="15px";
	}
	</script>
	<div class=page>
    	<div class="logo"><a href="index"><img src="${pageContext.request.contextPath}/images/newLogo.png" alt=logo width=110px></a></div>
        <div class="scelta">
        	<label class=opt id="insert">INSERISCI PRODOTTO</label>
        		<form action="InserisciProdotto" class=ins id="ins" onSubmit="return validateProduct();">
        			<input type=text placeholder="Nome Prodotto" id=nome name=nome>
        			<label for=categoria class=categoriaLabel>Categoria:</label>
        			<select id=categoria name=categoria><optgroup>
        				<option id=computer value=Computer>Computer</option>
						<option id=console value=Console>Console</option>
						<option id=elettrodomestici value=Elettrodomestici>Elettrodomestici</option>
						<option id=videogames value=Videogames>Videogames</option>
						<option id=altro value=Altro>Altro</option>
					</optgroup></select>
					<textarea name=descrizione id=descrizione style="resize:none;" class=desc cols=35 rows=8 name=desc placeholder="Inscerisci descrizione" ></textarea>
					<input type=number step=0.01 placeholder="Prezzo" id=prezzo name=prezzo required ><br><br>
					<label style="margin-bottom:8px;" class=file>Foto prodotto:</label>
					<input accept=".jpg" style="margin-bottom:8px;" id=file type="file" name="file" size="50" multiple />
        			<input type=submit value="INSERISCI">
        		</form>
        	<label class=opt id=remove>RIMUOVI PRODOTTO</label>
        		<form action="RimuoviProdotto" class=rem id=rem>
        			<label class=visualizza><a href="DispatcherElenco" target=_blank>Vai a 'Elenco Prodotti'</a></label>
        			<input style="margin-bottom:8px; margin-top:8px;" type="number" size=3 min=0 placeholder="Codice prodotto" id=codice name=codice>
        			<input type=submit value="RIMUOVI">
        		</form>
        	<label class=opt id=modifica>MODIFICA PRODOTTO</label>
        		<form action="ModificaProdotto" class=mod id=mod onSubmit="return validateModifica();">
        			<input type=number placeholder="Codice" id=codiceModifica name=codice style="margin-bottom:8px;" required>
        			<textarea name=descrizione id=descrizioneModifica style="resize:none;" class=desc cols=35 rows=8 name=desc placeholder="Inscerisci descrizione"></textarea>
        			<label for=prezzo>Prezzo: </label><input type=number step=0.01 style="margin-bottom:8px;" placeholder="Prezzo" min=0 id=prezzoModifica name=prezzo>
        			<input type=submit value="MODIFICA">
        		</form>
        	<label class=opt id=ordini>VISUALIZZA ORDINI DEGLI UTENTI</label>
        		<label class=opt id=scegli1>Visualizza ordini di un utente</label>
        		<form action="OrdiniUtente" class=oUt id=oUt>
        			<input style="margin-bottom:8px; margin-top:8px;" type=text placeholder="Email utente" id=perEmail name=perEmail>
        			<input type=submit value="VAI A ORDINI">
        		</form>
        		<label class=opt id=scegli2>Visualizza ordini in una data</label>
        		<form action="OrdiniData" class=oDate id=oDate>
        			<label class=opt for=perData1>Data inizio</label><input style="margin-bottom:8px; margin-top:8px;" type=date placeholder="Data inizio" id=perData1 name=perData1><br>
        			<label class=opt for=perData2>Data fine</label><input style="margin-bottom:8px; margin-top:8px;" type=date placeholder="Data inizio" id=perData2 name=perData2>
        			<input type=submit value="VAI A ORDINI">
        		</form>
        </div>
        <p id=error></p>
     </div>
	
	
</body>
</html>