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
        	<form action="DispatcherConfermaPagamento" method="post">
        		<h2>Inserisci dati della carta</h2>
            	<input class=form-input id=email name=email type=text placeholder="Nome titolare della carta" autofocus/>
                <input class=form-input id=numero name=numero type="password" placeholder="Numero della carta"/>
                <input class=form-input id=scadenza name=scadenza type=text placeholder="Scadenza" autofocus/>
                <input class=form-input id=cvc name=cvc type=text placeholder="CVC" autofocus/>
                <input class=submit type=submit value=CONFERMA>
            </form>
            <p id=error></p>
        </div>
     </div>
</body>
</html>