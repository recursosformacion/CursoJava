<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "java.util.Vector" %>
<center><h1>Listado de usurios</h1></center>
<center><h2>Que han pasado por aqui</h2></center>
<table>
<%
Vector<String> listado = (Vector<String>)request.getSession().getAttribute("listado");
int contador=0;
for ( int i = 0 ; i < listado.size() ; i++ )
{
%>
     <tr>
     <td>
     <a href="salida.jsp?indice=<%= contador++ %>">
     <%= listado.elementAt(i) %>
     </a>
     </td>
     </tr>
     <%
} %>
</table>
<center><a href="index.html">volver</a></center>

</body>
</html>