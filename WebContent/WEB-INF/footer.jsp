<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>3GTech-Footer</title>
		<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/footer.css">
	</head>
	<body>
		<div class=divF>
			<div class=mydivF>
				<table class=who>
					<tr><td class=title width=200px>Chi siamo<hr></td></tr>
					<tr><td><a class=foo href="">Cos'� 3GTech<br><br></a></td>
					<tr><td><a class=foo href="">Il Team</a></td></tr>
				</table>
		
				<table class=where>
					<tr><td class=title width=200px>Dove ci troviamo<hr></td></tr>
					<tr><td><a class=foo href="DispatcherWhereServlet">La nostra sede</a></td></tr>
				</table>
			</div>
		
			<label class=social>Seguici sui social<br>
			<img src="${pageContext.request.contextPath}/images/fb.png" width=35px>
			<img src="${pageContext.request.contextPath}/images/ig.png" width=35px>
			<img src="${pageContext.request.contextPath}/images/tg.png" width=35px></label>
		
			<br><br><label>&copy; 2022 - 3GTech</label>
		</div>
	</body>
</html>