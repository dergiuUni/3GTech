<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAGINA ADMIN</title>
<link rel=stylesheet href="${pageContext.request.contextPath}/gestione/gestione.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-3.6.0.js"></script>
</head>
<body>
	<div class=page>
    	<div class="logo"><a href="index"><img src="${pageContext.request.contextPath}/images/newLogo.png" alt=logo width=110px></a></div>
        <div class="scelta">
        	<label class=opt id="insert">INSERISCI PRODOTTO</label>
        		<form action="InserisciProdotto" class=ins id="ins">
        			<input type=text placeholder="Nome Prodotto" id=nome name=nome>
        			<label for=categoria class=categoriaLabel>Categoria:</label>
        			<select id=categoria name=categoria><optgroup>
        				<option id=computer value=Computer>Computer</option>
						<option id=console value=Console>Console</option>
						<option id=elettrodomestici value=Elettrodomestici>Elettrodomestici</option>
						<option id=videogames value=Videogames>Videogames</option>
						<option id=altro value=Altro>Altro</option>
					</optgroup></select>
					<textarea name=descrizione id=descrizione style="resize:none;" class=desc cols=35 rows=8 name=desc placeholder="Inscerisci descrizione"></textarea>
					<input type=number step=0.01 placeholder="Prezzo" id=prezzo name=prezzo><br><br>
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
        		<form action="ModificaProdotto" class=mod id=mod>
        			<input type=number placeholder="Codice" id=codice name=codice style="margin-bottom:8px;" required>
        			<textarea name=descrizione id=descrizione style="resize:none;" class=desc cols=35 rows=8 name=desc placeholder="Inscerisci descrizione"></textarea>
        			<label for=prezzo>Prezzo: </label><input type=number step=0.01 style="margin-bottom:8px;" placeholder="Prezzo" min=0 id=prezzo name=prezzo value=0>
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
     </div>
	<script src="${pageContext.request.contextPath}/gestione/gestione.js"></script>
</body>
</html>