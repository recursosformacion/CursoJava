<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String nombre=(String)session.getAttribute("usuario");
    if (nombre==null && nombre.length()==0){%>
    	<jsp:forward page="externo.jsp"></jsp:forward>
    	<%} %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Dentro </h1>
Bienvenido <%= session.getAttribute("usuario") %>
</body>
</html>