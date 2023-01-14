<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/LoginCSS.css">
        <title>LoginErrore</title>
    </head>
	
    <body>
    <div class=page>
    	<div class="logoLogin"><a href="index"><img src="${pageContext.request.contextPath}/images/newLogo.png" alt=logo width=110px></a></div>
        <div class="login-page">
        	<form action="LoginServlet" method="post" onSubmit="return validateLogin();">
            	<input class=form-input id=email name=email type=text placeholder="e-mail" autofocus/>
                <input class=form-input id=password name=password type="password" placeholder="password"/>
                <input class=submit type=submit value=login>
                <p class="message">Non sei ancora registrato? <a href="DispatcherRegistrazioneServlet">Crea un account</a></p>
            </form>
            <p id=error></p>
        </div>
        <p id=error style="color:red; text-align:center">ERRORE: Inserisci correttamente i dati</p>
     </div>
     
     <script src="${pageContext.request.contextPath}/login/login.js"></script>
    </body>
</html>