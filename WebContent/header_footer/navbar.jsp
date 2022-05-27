<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Session" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>3GTech-NavBar</title>
<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/navbar.css">
</head>
<body>
	<div class=menuDiv>
		<nav><ul>
			<li><a href="">Computer</a></li>
	   		<li><a href="">TV</a></li>
        	<li><a href="">Cellulari</a></li>
        	<li><a href="">Componenti</a></li>
	    	<li><a href="">Console</a></li>
	    	<li><a href="">Videogames</a></li>
	    	<li><a href="">Elettrodomestici</a></li>
	    	<% Session s=new Session();
	    		if(s.isSessionAdmin(request)){%>
	    				<li><a href="">Gestisci Catalogo</a></li>
	    			<%} %>
		</ul></nav>
		</div>
</body>
</html>