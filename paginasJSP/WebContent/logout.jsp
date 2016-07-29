<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>

<title>Saliendo</title>
</head>
<body>
	<%
		session.removeAttribute("usuario");
		
		session.invalidate();
	%>
	<h1>Gracias,y hasta la vista.</h1>
</body>
</html>
