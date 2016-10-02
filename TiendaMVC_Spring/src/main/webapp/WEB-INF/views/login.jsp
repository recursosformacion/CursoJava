<%@include file="_cabecera0.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Conectar</title>
	</head>
	<body>
		<form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">

			<form:label path="username">Nombre de usuario</form:label>
			<form:input id="username" name="username" path="username" /><br>
			<form:label path="username">Contraseña</form:label>
			<form:password id="password" name="password" path="password" /><br>
			<input type="submit" value="Conectar" />
		</form:form>
	</body>
</html>