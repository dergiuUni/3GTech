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

function validateReg(){
	var email=document.getElementById("email");
	var password=document.getElementById("password");
	var nome=document.getElementById("nome");
	var cognome=document.getElementById("cognome");
	var indirizzo=document.getElementById("indirizzo");
	var telefono=document.getElementById("telefono");
	
	if(nome.value.length<3){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci nome!";
		console.log("Sono caduto in errore nome1");
		return false;
	}
	
	if(!(nome.value.match(/^[A-Za-z]+$/))){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Il nome pu&ograve contenere solo lettere!";
		console.log("Sono caduto in errore nome2");
		return false;
	}
	
	if(cognome.value.length<2){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci cognome!";
		console.log("Sono caduto in errore cognome1");
		return false;
	}
	
	if(!(cognome.value.match(/^[A-Za-z]+$/))){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Il cognome pu&ograve contenere solo lettere!";
		console.log("Sono caduto in errore cognome2");
		return false;
	}
	
	if(indirizzo.value.length==0){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci indirizzo!";
		console.log("Sono caduto in errore indirizzo1");
		return false;
	}
	
	if(!(indirizzo.value.match(/^[A-z]+ [A-z]+ [A-z0-9]+$/))){
		var errore=document.getElementById("error");
		css(errore);
		errore.style.height="40px";
		errore.innerHTML="<b>ERRORE:</b>L'indirizzo deve essere:<br>&#60Via/Piazza/...&#62 &#60Nome&#62 &#60Civico&#62!";
		console.log("Sono caduto in errore indirizzo2");
		return false;
	}
	
	if(!(telefono.value.match(/^\d{10}$/))){
		var errore=document.getElementById("error");
		css(errore);
		errore.style.height="40px";
		errore.innerHTML="<b>ERRORE:</b>Inserire un numero di telefono valido!";
		console.log("Sono caduto in errore telefono");
		return false;
	}
	
	if(email.value==""){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci email!";
		console.log("Sono caduto in errore email");
		return false;
	}
	
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)(\.\w{2,9})+$/.test(email.value)==false){
       var errore=document.getElementById("error");
       css(errore);
	   errore.innerHTML="<b>ERRORE:</b>Inserisci un'email valida!";
	   console.log("Sono caduto in errore email");
	   return false;
    }
    
    if(password.value==""){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci password!";
		console.log("Sono caduto in errore 2");
		return false;
	}
	
	if(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/.test(password.value)==false){
		var errore=document.getElementById("error");
		css(errore);
		errore.style.width="400px";
		errore.style.height="90px";
		errore.innerHTML="<b>ERRORE:</b>La password deve contenere:<br>- Almeno una lettera<br>- Almeno un numero<br>- Almeno un carattere speciale<br>- Essere lunga almeno 8 caratteri";
		console.log("Sono caduto in errore 3");
		return false;
	}
	console.log("Nessun errore rilevato");
	return true;
}

function validateName(){
	var nome=document.getElementById("nome");
	
	if(nome.value.length<3){
		console.log("Sono caduto in errore nome1");
		return false;
	}
	
	if(!(nome.value.match(/^[A-Za-z]+$/))){
		console.log("Sono caduto in errore nome2");
		return false;
	}
	return true;
}

function validateSurname(){
	var cognome=document.getElementById("cognome");

	if(cognome.value.length<2){
		console.log("Sono caduto in errore cognome1");
		return false;
	}
	
	if(!(cognome.value.match(/^[A-Za-z]+$/))){
		console.log("Sono caduto in errore cognome2");
		return false;
	}
	return true;
}

function validateAddress(){
	var indirizzo=document.getElementById("indirizzo");
	
	if(indirizzo.value.length==0){
		console.log("Sono caduto in errore indirizzo1");
		return false;
	}
	
	if(!(indirizzo.value.match(/^[A-z]+ [A-z]+ [A-z0-9]+$/))){
		console.log("Sono caduto in errore indirizzo2");
		return false;
	}
	return true;
}

function validatePhone(){
	var telefono=document.getElementById("telefono");
	
	
	if(!(telefono.value.match(/^\d{10}$/))){
		console.log("Sono caduto in errore telefono");
		return false;
	}
	return true;
}

function validateEmail(){
	var email=document.getElementById("email");
	
	if(email.value==""){
		console.log("Sono caduto in errore email");
		return false;
	}
	
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)(\.\w{2,9})+$/.test(email.value)==false){
	   console.log("Sono caduto in errore email");
	   return false;
    }
    return true;
}

function validatePassword(){
	var password=document.getElementById("password");
	
    if(password.value==""){
		console.log("Sono caduto in errore 2");
		return 0;
	}
	
	if(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/.test(password.value)==false){
		var errore=document.getElementById("error");
		console.log("Sono caduto in errore 3");
		return 0;
	}
	
	var level;
	if(password.value.length<10) level=1;
	else if(password.value.length<13) level=2;
	else level=3;
	
	console.log("Nessun errore rilevato");
	return level;
}