<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList , model.OrdineBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/login/LoginCSS.css">
</head>
<body>
<%ArrayList<OrdineBean> list=(ArrayList<OrdineBean>)request.getAttribute("list");
request.getSession().setAttribute("list",list);%>
	<div class=page>
        <div class="login-page">
        	<form action="DispatcherConfermaPagamento" method="post">
        		<h2>Inserisci dati della carta</h2>
            	<input class=form-input id=email name=email type=text placeholder="Nome titolare della carta" autofocus/>
                <input class=form-input id=password name=password type="password" placeholder="Numero della carta"/>
                <input class=form-input id=email name=email type=text placeholder="Scadenza" autofocus/>
                <input class=form-input id=email name=email type=text placeholder="CVC" autofocus/>
                <input class=submit type=submit value=CONFERMA>
            </form>
            <p id=error></p>
        </div>
     </div>
</body>
</html>