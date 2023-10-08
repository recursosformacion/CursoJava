<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.lineaForm {
	height: 2em;
	}
.lineaForm label {
	width: 10em; display : inline-block;
	display: inline-block;
}
</style>
</head>
<body>
	<%@ include file="/trozos/cabecera.jsp"%>

	<c:url value="Categorias" var="insertar">
		<c:param name="op" value="${modo }" />
	</c:url>


	<form method="POST" action="${insertar}">
		<div class="lineaForm">
			<label for="if_categoria">Numero Categoria</label> 
			<input type="text"
				value="${objCate.id_categoria}" name="id_categoria" readonly />
		</div>
		<div class="lineaForm">
			<label for="cat_nombre">Nombre Categoria</label> <input type="text"
				value="${objCate.cat_nombre}" name="cat_nombre"
				<c:out default="none" value="${Visibilidad ? 'ReadOnly' : '' }"/> />
		</div>
		<div class="lineaForm">
			<label for="cat_descripcion">Descripcion Categoria</label>
			<textarea name="cat_descripcion" cols=40 rows=10
				<c:out default="none" value="${Visibilidad ? 'ReadOnly' : '' }"/>>
			${objCate.cat_descripcion}
		</textarea>
		</div>
		<div class="lineaForm">
			<input type="submit" value="${Letrero}" />
		</div>
	</form>

</body>
</html>