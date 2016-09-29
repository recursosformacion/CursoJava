<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	padding: 0px;
	margin: 0px;
}

label {
	width: 6em;
	display: inline-block;
}

form {
	width: 300px;
	height: 300px;
	margin: 100px auto;
	background-color: aqua;
	padding: 5px 0 0 5px;
}

#cabecera {
	background-color: red;
	height: 200px;
}

#izquierda {
	background-color: yellow;
	width: 30%;
	float: left;
	height: 600px;
}

#derecha {
	background-color: green;
	width: 65%;
	float: right;
	height: 600px;
}

body {
	background-color: green;
}
</style>
</head>
<body>
	<div id="cabecera">&nbsp; Cabecera</div>
	<div id="izquierda">

		<ul>

			<li><a href="http://www.google.com" target="new">Google</a></li>
			<li>Aplicacion</li>

		</ul>
	</div>
	<div id="derecha">
		<%
		String userName = null;
		//**********************************por session
		userName= (String) session.getAttribute("user");
		if(session.getAttribute("user") == null){
			response.getWriter().println("<h2>por sesion no esta logonado</h2>");
		} else {
			response.getWriter().println("<h2>por sesion  esta logonado</h2>");
		}
		//***************por cookie
			
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("user"))
						userName = cookie.getValue();
				}
			}
			//*************************************************************comun
			if (userName == null) {
		%>
		
		<!--  <form action="Login" method=POST>-->
		<form action="LoginCDAO" method=POST>
			<h2>Identificacion</h2>
			<label for="usuario">Usuario</label> <input name="usuario"
				type="text" /> <br /> <label for="password">Contraseña</label> <input
				name="password" type="password" /> <br /> <input type=submit
				value="Enviar" />

		</form>
		<%
			} else {
		%>
		<h1>
			Bienvenido
			<%=userName%></h1>
		<%
			}
		%>
	</div>
</body>
</html>