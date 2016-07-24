<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>interno</title>
</head>
<body>
	<%
		String usuario = request.getParameter("user");
		String pass = request.getParameter("password");
		if ((usuario.equals("miguel") && pass.equals("miguel"))) {
			session.setAttribute("usuario", usuario);
			response.sendRedirect("Inicio.jsp");
		} else
			response.sendRedirect("Error.jsp");
	%>
</body>
</html>
