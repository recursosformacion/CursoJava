<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 


<x:parse xml = "${valorCuenta}" var="doc" />

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Datos:
<P>${valorCuenta}</p>
<c:out value ="${valorCuenta}" escapeXml="true"/>

<p>Numero: <x:out select="$doc/CUENTA/NUMERO"/></p>
<p>Titular: <x:out select="$doc/CUENTA/TITULAR"/></p>

<table>
<x:forEach var="trozo" select="$doc/CUENTA/MOVIMIENTOS/MOVIMIENTO">
<tr>
<td><x:out select="$trozo/CONCEPTO"/></td>
<td><x:out select="$trozo/FECHA"/></td>
<td><x:out select="$trozo/IMPORTE"/></td>
</tr>
</x:forEach>
</table>
</body>
</html>