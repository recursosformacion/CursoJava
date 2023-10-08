<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="cDAO" class="es.rf.tienda.objetos.daos.UsuarioDAOH"></jsp:useBean>

<%
String nombre = request.getParameter("nombre");
String pass = request.getParameter("pass");
if (usuarioOK(nombre,pass)){
	session.setAttribute("usuario",nombre);
	%>
	<jsp:forward page="interno.jsp"></jsp:forward>
	<% } else {%>
	<jsp:forward page="externo.jsp"></jsp:forward>
	<%} %>
<%!

public boolean usuarioOK(String nombre, String pass){
	
	
	return nombre.equals("miguel") && pass.equals("mg");
}



%>