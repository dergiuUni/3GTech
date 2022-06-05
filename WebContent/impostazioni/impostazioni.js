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

function validateEmail(){
	var email=document.getElementById("newEmail");
	var errore=document.getElementById("errorEmail")
	
	if(email.value==""){
		css(errore);
		errore.innerHTML="<b>ERRORE:</b>Inserisci email!";
		return false;
	}
	
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)(\.\w{2,9})+$/.test(email.value)==false){
	   css(errore);
	   errore.innerHTML="<b>ERRORE:</b>Inserire una email valida!";
	   return false;
    }
    return true;
}

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