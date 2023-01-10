<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Impostazioni</title>
<link rel=stylesheet href="${pageContext.request.contextPath}/impostazioni/impostazioni.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"></script>
</head>
<body>
	<div class=page>
    	<div class="logo"><a href="index"><img src="${pageContext.request.contextPath}/images/newLogo.png" alt=logo width=110px></a></div>
        <div class="scelta">
        	<label class=opt id="optEmail">MODIFICA EMAIL</label>
        		<form action="ModificaEmail" class=email id=email onSubmit="return validateEmail();">
        			<input type=text placeholder="Nuova Email" id=newEmail name=newEmail>
        			<input type=submit value="APPLICA MODIFICHE">
        			<p id=errorEmail></p>
        		</form>
        	<label class=opt id=optPassword>MODIFICA PASSWORD</label>
        		<form action="ModificaPassword" class=password id=password onSubmit="return validatePassword();">
        			<input type="password" placeholder="Nuova Password" id=newPassword name=newPassword>
        			<input type=submit value="APPLICA MODIFICHE">
        			<p id=errorPassword></p>
        		</form>
        	<label class=opt id=optIndirizzo>MODIFICA INDIRIZZO</label>
        		<form action="ModificaIndirizzo" class=indirizzo id=indirizzo onSubmit="return validateIndirizzo();">
        			<input type=text placeholder="Nuovo Indirizzo" id=newIndirizzo name=newIndirizzo>
        			<input type=submit value="APPLICA MODIFICHE">
        			<p id=errorIndirizzo></p>
        		</form>
        	<a class=opt href="DispatcherStoricoAcquistiFattura">VISUALIZZA STORICO ACQUISTI</a>
        </div>
     </div>
	<script src="${pageContext.request.contextPath}/impostazioni/impostazioni.js"></script>
</body>
</html>