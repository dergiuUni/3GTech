<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Session" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>3GTech-Header</title>
<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/header.css">
</head>

<body>
	<header>
	<div class=sloganDiv><label class=slogan><b>3GTech: World of Technology</b></label></div>
		<div class=divH id=header>
		<a href="index"><img class=logoH src="${pageContext.request.contextPath}/images/newLogo.png"></a>
		  <form class="formH" action="">
		  	<div class=optDiv onMouseOver="openOptions();" onMouseOut="closeOptions();">
		  		 <img class=options src="${pageContext.request.contextPath}/images//options.png">
		  		 <div id=optionsMenu>
		  		 	<div class=categorie>
		  		 		<label>Categorie:</label><hr>
						<input id=computer type=checkbox value=Computer><label for=computer>Computer</label><br>
						<input id=tv type=checkbox value=TV><label for=tv>TV</label><br>
						<input id=cellulari type=checkbox value=Cellulari><label for=cellulari>Cellulari</label><br>
						<input id=componenti type=checkbox value=Componenti><label for=componenti>Componenti</label><br>
						<input id=videogames type=checkbox value=Videogames><label for=videogames>Videogames</label><br>
						<input id=elettrodomestici type=checkbox value=Elettrodomestici><label for=elettrodomestici>Elettrodomestici</label><br><hr>
					</div>
					<label>Prezzo massimo:</label><br>
						<input id=sliderPrezzo type=range step=1 min=0 max=999 value=0 oninput="show(this.value)"><label id=max>0$</label>
						<script>
            				function show(prezzo) {
                			document.getElementById("max").innerHTML=prezzo +'$';
            			}
        				</script>
		  		 </div>
		  	</div>
                 <input class=inputH id=f1 type="text" placeholder="Cosa stai cercando?" style=width:250px;> 
                 <input class=search type="image" src="${pageContext.request.contextPath}/images//search2.png" alt="Cerca" width=30px>
              </form>
          <% if(session.getAttribute("utente")==null){ %> 
          <div class=userDiv onMouseOver="openMenu();" onMouseOut="closeMenu();">
          	<a class=logoLogin><img class=loginH src="${pageContext.request.contextPath}/images/account.png" width=50px></a>
          	<table id=userMenu class=userMenu>
          		<tr><td><a class=menuA href=DispatcherLoginServlet>Login</a></td></tr>
          		<tr><td><a class=menuA href=DispatcherRegistrazioneServlet>Registrati</a></td></tr>
          	</table>
          </div>
          <% }else{ %>
         	<div class=userDiv onMouseOver="openMenu();" onMouseOut="closeMenu();">
          	<a class=logoLogin><img class=loginH src="${pageContext.request.contextPath}/images/account.png" width=50px></a>
          	<table id=userMenu class=userMenu>
          		<% Session s=new Session();
	    		if(s.isSessionAdmin(request)){%>
	    				<tr><td><a class=menuA href="DispatcherGestisciCatalogo">Gestisci Catalogo</a></td></tr>
	    		<%}else{ %>
	    				<tr><td><a class=menuA href="DispatcherCarrelloServlet">Carrello</a></td></tr>
	    		<% } %>
          		<tr><td><a class=menuA href="DispatcherImpostazioni">Impostazioni</a></td></tr>
          		<tr><td><a class=menuA href=LogoutServlet>Logout</a></td></tr>
          	</table>
          </div>
         <% } %>
	</div>
	</header>
	
	 <script src="${pageContext.request.contextPath}/header_footer/header.js"></script>
</body>
</html>