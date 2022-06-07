<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-3.6.0.js"></script>
		<script type="text/javascript">
		
			$(document).on("change", "#ciao", function() {  
			    $.get("AjaxRicercaProdottoServlet?cerco=" + $('input[name="ciao"]').val(), function(responseJson) {    
			        var $ul = $("<ul>").appendTo($("#stampa")); 
			        $.each(responseJson, function(index, item) { 
			            $("<li>").text(item).appendTo($ul);      
			        });
			    });
			});
		
		</script>
	</head>
	<body>
		<input name="ciao" id="ciao" type="text" placeholder="Cosa stai cercando?" style=width:250px;>
		<button id="somebutton">premimi</button>
		<p id="stampa"></p> 
	</body>
</html>