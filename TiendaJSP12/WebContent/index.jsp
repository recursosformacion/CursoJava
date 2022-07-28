<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="fecha" class="java.util.Date" />
 ${fecha}
 <form method="POST" action="control.jsp">
 <table>
 <tr>
 <td colspan=2><h2>Login</h2></td>
 </tr>
 
 <tr>
 <td>Nombre</td>
 <td><input type="text" name="nombre"/></td>
 </tr>
 <tr>
 <td>Contraeña></td>
 <td><input type="password" name="pass"/></td>
 </tr>
 <tr>
 <td></td><td>
 <input type="submit" value="Enviar"/>
 </td>
 </tr>
 </table>
 </form>
</body>
</html>