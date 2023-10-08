<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1 style="margin: 20px auto; width: 50%;">
<tr><th>Cuenta</th><th>Titular</th></tr>

<c:forEach var="cuenta"
           items="${listado}">
  <tr>
  <td>
  ${cuenta.mNumero }
  </td>
  <td>
  ${cuenta.mTitular }
  </td>
  <td><a href="edicion/${cuenta.mNumero }">Modificar</a></td>
  <td><a href="borrar/${cuenta.mNumero }">Eliminar</a></td>
  </tr>
  </c:forEach>

</table>
<a href="../indice">Volver</a>
</body>
</html>