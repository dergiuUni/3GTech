<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                 <input class=inputH id=f1 type="text" placeholder="Cosa stai cercando?" style=width:250px;> 
                  
                 <div class=min>      
                 	<label class=labelH id=f2>Prezzo minimo:</label>
                 	<input class=inputHMin id=f3 type="number" id="fname" name="min" style=width:50px; min=0>
                 </div>
                 <div class=max>
                 	<label class=labelH id=f4>Prezzo massimo: </label>
                 	<input class=inputHMax id=f5 type="number" id="fname" name="max" style=width:50px; min=0>
                 </div>
                 
                 <input class=search type="image" src="${pageContext.request.contextPath}/images//search2.png" alt="Cerca" width=30px>
              </form>
          <% if(session.getAttribute("utente")==null){ %>    
          	<a href=DispatcherLoginServlet><img class=loginH src="${pageContext.request.contextPath}/images/account.png" width=50px></a>
          <% }else{ %>
         	<a href="LogoutServlet"><img class=loginH src="${pageContext.request.contextPath}/images/account.png" width=50px></a>
         <% } %>
	</div>
	</header>
</body>
</html>