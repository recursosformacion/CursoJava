<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/trozos/cabecera.jsp" %>
<h2>Listado Categorias</h2>
<body>
<c:if test="${not empty Mensajes}">
<h1>Errores:</h1>
<h2><c:out value="${Mensajes}"/></h2>
</c:if>
<table>
<c:forEach var="categoria" items="${lisCategoria}">

<c:url value="Categorias" var="editar" >
	<c:param name="op" value="editar"/>
	<c:param name="id_categoria" value="${categoria.id_categoria}"/>
</c:url>

<c:url value="Categorias" var="borrar">
	<c:param name="op" value="borrar"/>
	<c:param name="id_categoria" value="${categoria.id_categoria}"/>
</c:url>

<tr>
<td><c:out value="${categoria.id_categoria}"/></td>
<td><c:out value="${categoria.cat_nombre}"/></td>
<td><c:out value="${categoria.cat_descripcion}"/></td>
<td><a href='<c:out value="${editar}"/>'>Edit</a> </td>
<td><a href='<c:out value="${borrar}"/>'>Borrar</a> </td>

</tr>
</c:forEach>
</table> 
<c:url value="Categorias" var="insertar">
	<c:param name="op" value="insertar"/>
	
</c:url>
<a href='<c:out value="${insertar}"/>'>Insertar</a>
<a href="<%=urlBase %>/index.jsp">Volver</a>
</body>
</html>