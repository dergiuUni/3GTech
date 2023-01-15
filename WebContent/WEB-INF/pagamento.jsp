<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList , bean.OrdineBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/login/LoginCSS.css">
</head>
<body>
	<div class=page>
        <div class="login-page">
        	<form action="index" method="post">
        		<h2>Inserisci i dati della carta</h2>
            	<input class=form-input id=email name=email type=text placeholder="Nome titolare della carta" maxlength="30" required autofocus/>
                <input class=form-input id=numero name=numero type="password" placeholder="Numero della carta" required  pattern=".{10}" type=number/>
                <input class=form-input id=scadenza name=scadenza type=text placeholder="Scadenza" autofocus required/>
                <input class=form-input id=cvc name=cvc type=text placeholder="CVC" autofocus pattern=".{3}" required type=number/>
                <input class=submit type=submit value=CONFERMA>
            </form>
            <p id=error></p>
        </div>
     </div>
</body>
</html>