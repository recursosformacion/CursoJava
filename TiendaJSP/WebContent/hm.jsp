<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*"
	import="pruebas.servlets.UserMio"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="poraqui">
		Nombre <input type="text" name="nombreUsuario" /> <input
			type="submit" value="Enviar" />


	</form>
	<% %>if (session.getAttribute("lista")!=null) { %>
	<table>
		<tr>
			<th colspan="2"><h1>Lista de usuarios</h1></th>
		</tr>
	</table>
	<h1>Lista de usuarios</h1>
	<% 
	UserMio ele; 
		ArrayList<UserMio> lista = (ArrayList<UserMio>) session.getAttribute("lista");
		for (ele : lista) {
		}
	%>
	<tr>
		<td><%=ele,getNombre() %></td>
		<td><%=ele.gerHora() %></td>
	</tr>
	<%}	%>
	</table>
	<%} %>
</body>
</html>