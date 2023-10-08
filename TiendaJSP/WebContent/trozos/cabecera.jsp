<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String urlBase = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();

	String userName = null;
	//**********************************por session
	userName = (String) session.getAttribute("user");
	if (session.getAttribute("user") == null) {
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
%>


<style>
* {
	margin: 0;
	padding: 0
}

#Cabecera {
	width: 100%;
	background-color: aqua;
	padding: 2em;
}

#menCabe {
	width: 18em;
	margin: 0 auto;
}

#lastLine {
	width: 35em;
	background-color: red;
	margin: 0 ;
	padding: 0;
}
</style>

	<header id="Cabecera">
	<h1 id="menCabe">Bienvenidos a la tienda de incienso</h1>
	<hr>
	<div id="lastLine">
	<% if (userName == null) { %>
		<form action="Login" method=POST>
			<label for="usuario">Usuario</label> <input name="usuario" type="text" />
		  <label for="password">Contraseņa</label> <input name="password" type="password" />
		  <input type="submit" value="Enviar" />

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

	</header>
