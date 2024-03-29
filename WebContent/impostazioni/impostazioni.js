$(function(){
	$('#optEmail').click(
		function(){
		$('#email').slideToggle('slow');
		});
})

$(function(){
	$('#optPassword').click(
		function(){
		$('#password').slideToggle('slow');
		});
})

$(function(){
	$('#optIndirizzo').click(
		function(){
		$('#indirizzo').slideToggle('slow');
		});
})

function validatePassword(){
	var password=document.getElementById("newPassword");
	var errore=document.getElementById("errorPassword");
	
	if(password.value==""){
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci password!";
		return false;
	}
	
	if(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/.test(password.value)==false){
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserire una password valida!";
		console.log("Sono caduto in errore 3");
		return false;
	}
}

function validateIndirizzo(){
	var indirizzo=document.getElementById("newIndirizzo");
	var errore=document.getElementById("errorIndirizzo");
	
	if(indirizzo.value.length==0){
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci indirizzo!";
		return false;
	}
	
	if(!(indirizzo.value.match(/^[A-z]+ [A-z]+ \d{1,3}$/))){
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci indirizzo valido!";
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