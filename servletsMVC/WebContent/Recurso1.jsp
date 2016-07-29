<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recurso1</title>
</head>
<body>
Recurso1<br>
<%= session.getAttribute("mensaje")%><br>
<hr/>
Recueperando usando EL : ${mensaje} <br/>
${param['nombre']} <br/>
${param.nombr}
<!-- <%= request.getAttribute("mensaje")%><br> -->
<a href="res2.do">Recurso2</a>
</body>
</html>