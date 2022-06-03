<!DOCTYPE html>
<html>
    <head>
    	<title>Registrazione</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/registrazione/LoginCSS.css">
    </head>
	
    <body>
    <div class=page>
    	<div class="logoLogin"><a href="index"><img src="${pageContext.request.contextPath}/images/newLogo.png" alt=logo width=110px></a></div>
        <div class="login-page">
        	<form action="RegistrazioneServlet" method="post" onSubmit="return validateReg();">
            	<input class=form-input id="nome" name=nome type=text placeholder="Nome" autofocus onKeyUp="onBlurName(this);"/>
        		<input class=form-input id=cognome name=cognome type=text placeholder="Cognome" onKeyUp="onBlurSurname(this);"/>
        		<input class=form-input id=indirizzo name=indirizzo type=text placeholder="Indirizzo (&ltVia/Piazza/...&gt &ltNome&gt &ltCivico&gt)" onKeyUp="onBlurAddress(this);"/>
        		<input class=form-input id=telefono name=telefono type=text placeholder="Telefono (10 cifre)" onKeyUp="onBlurPhone(this);"/>
            	<input class=form-input id=email name=email type=text placeholder="E-mail (es. 3GTech@studenti.unisa.it)" onKeyUp="onBlurEmail(this);"/>
                <input class=form-input id=password name=password type="password" placeholder="Password (Almeno 8 caratteri)" onKeyUp="onBlurPassword(this);"/>
                <div id=strength>
                	<span id=low></span>
                	<span id=medium></span>
                	<span id=strong></span>
                </div>
                <input class=submit type=submit value=Registrati>
                <p class="message">Sei già registrato? <a href="DispatcherLoginServlet">Accedi</a></p>
            </form>
            <p id=error></p>
        </div>
     </div>
     
     <script src="${pageContext.request.contextPath}/registrazione/registrazione.js"></script>
     <script>
     	function onBlurName(x){
     		if(validateName()) x.style.background="lightGreen";
     		else{
     			if(document.getElementById("nome").value.length==0);
     			else x.style.background="lightcoral";
     		}
     	}
     	function onBlurSurname(x){
     		if(validateSurname()) x.style.background="lightGreen";
     		else{
     			if(document.getElementById("cognome").value.length==0);
     			else x.style.background="lightcoral";
     		}
     	}
     	function onBlurAddress(x){
     		if(validateAddress()) x.style.background="lightGreen";
     		else{
     			if(document.getElementById("indirizzo").value.length==0);
     			else x.style.background="lightcoral";
     		}
     	}
     	function onBlurPhone(x){
     		if(validatePhone()) x.style.background="lightGreen";
     		else{
     			if(document.getElementById("telefono").value.length==0);
     			else x.style.background="lightcoral";
     		}
     	}
     	function onBlurEmail(x){
     		if(validateEmail()) x.style.background="lightGreen";
     		else{
     			if(document.getElementById("email").value.length==0);
     			else x.style.background="lightcoral";
     		}
     	}
     	function onBlurPassword(x){
     		var level=validatePassword();
     		if(level>0){
     			x.style.background="lightGreen";
     			var low=document.getElementById("low");
     			var medium=document.getElementById("medium");
     			var strong=document.getElementById("strong");
     			if(level==1){
     				low.style.background="lightCoral";
     				medium.style.background="none";
     				strong.style.background="none";
     			}else if(level==2){
     				low.style.background="orange";
     				medium.style.background="orange";
     				strong.style.background="none";
     			}else if(level==3){
     				low.style.background="lightGreen";
     				medium.style.background="lightGreen";
     				strong.style.background="lightGreen";
     			}
     		}
     		else{
     			var low=document.getElementById("low");
     			var strong=document.getElementById("strong");
     			var medium=document.getElementById("medium");
     			x.style.background="lightcoral";
     			low.style.background="none";
     			medium.style.background="none";
     			strong.style.background="none";
     		}
     	}
 	 </script>
 	 
    </body>
</html>