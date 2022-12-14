<%@ page import="com.google.gson.Gson"%>
<%@ page import="bean.ProdottoBean"%>
<%@ page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sessione.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="implementazione.ProdottoImplementazioneDAO" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>3GTech-Header</title>
		<link rel=stylesheet href="${pageContext.request.contextPath}/header_footer/header.css">
		<script src="${pageContext.request.contextPath}/jquery.js"></script>
	</head>

	<body>
		<header>
			<div class=sloganDiv><label class=slogan><b>3GTech: World of Technology</b></label></div>
				<div class=divH id=header>
				<a href="index"><img class=logoH src="${pageContext.request.contextPath}/images/newLogo.png"></a>
				  <form class="formH" action="">
		                 <input autocomplete=off class=inputH id=f1 type="text" placeholder="Cosa stai cercando?" style=width:250px;>
		          </form>
		          <table id=hiddenDiv>
		                 <%	ProdottoImplementazioneDAO dao = new ProdottoImplementazioneDAO();
		                 	JSONArray arr = dao.leggiProdotto();
		                 	ProdottoBean pr;
		                 	Gson gson = new Gson();
		                 	
		                 	for(int j = 0; j < arr.length(); j++){
		                 		pr = gson.fromJson(arr.getString(j), ProdottoBean.class);
	                 		%>
		               			<tr><td><a href="DispatcherProdottoSearchBar?name=<%=pr.getNome()%>"><%=pr.getNome()%></a></td></tr>
		               	 <%} %>
		          </table>
		          <% if(session.getAttribute("utente") == null){ %> 
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
		          		<tr><td><a class=menuA href="LogoutServlet">Logout</a></td></tr>
		          	</table>
		          </div>
		         <% } %>
			</div>
		</header>
		<script>
		  	$("#hiddenDiv tr").hide();
			$(document).ready(function(){
		  		$("#f1").on("keyup", function() {
		    		var value = $(this).val().toLowerCase();
		    		$("#hiddenDiv tr").filter(function() {
		    			if(value.length>1)
		      				$(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
		      			else $(this).hide($(this).text().toLowerCase().indexOf(value)>-1)
		    		});
		  		});
			});
		</script>
		<script src="${pageContext.request.contextPath}/header_footer/header.js"></script>
	</body>
</html>