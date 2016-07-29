<%@page contentType="text/html" pageEncoding="UTF-8"
	errorPage="Error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenida Usuario</title>
</head>
<body>
	<p>&nbsp;</p>
	
		<h2>
			<%
				String a = session.getAttribute("usuario").toString();
				out.println("Hola " + a);
			%>
		</h2>
		<p>&nbsp;</p>
		<br /> <a href="logout.jsp">Salir</a>
	
</body>
</html>

