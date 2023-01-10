<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sessione.*" %>
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
			<li><a href="DispatcherIndexComputerServlet">Computer</a></li>
	    	<li><a href="DispatcherIndexConsoleServlet">Console</a></li>
	    	<li><a href="DispatcherIndexVideogameServlet">Videogames</a></li>
	    	<li><a href="DispatcherIndexElettrodomesticiServlet">Elettrodomestici</a></li>
	    	<li><a href="DispatcherIndexAltroServlet">Altro</a></li>
		</ul></nav>
		</div>
</body>
</html>