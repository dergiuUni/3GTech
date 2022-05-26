function css(errore){
	errore.style.textAlign="center";
    errore.style.padding="4% 0 4% 2%";
	errore.style.backgroundColor="#fcdde8";
	errore.style.fontFamily="Roboto";
	errore.style.height="20px";
  	errore.style.outlineWidth="3px";
    errore.style.outlineColor="#663344";
 	errore.style.outlineStyle="solid";
 	errore.style.fontSize="medium";
}

function validateLogin(){
	var email=document.getElementById("email");
	var password=document.getElementById("password");
	
	if(email.value==""){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci email!";
		return false;
	}
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)(\.\w{2,9})+$/.test(email.value)==false){
       var errore=document.getElementById("error");
       css(errore);
	   errore.innerHTML="<b>ERRORE:</b>Inserisci un'email valida!";
	   return false;
    }
    
    if(password.value==""){
		var errore=document.getElementById("error");
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci password!";
		return false;
	}
	
	return true;
}