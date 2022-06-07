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
			<li><a href="ComputerServlet">Computer</a></li>
	    	<li><a href="ConsoleServlet">Console</a></li>
	    	<li><a href="VideogameServlet">Videogames</a></li>
	    	<li><a href="ElettrodomesticiServlet">Elettrodomestici</a></li>
	    	<li><a href="AltroServlet">Altro</a></li>
		</ul></nav>
		</div>
</body>
</html>