<%@page import="bean.LoginDao"%>
<jsp:useBean id="obj" class="bean.LoginBean" />

<jsp:setProperty property="*" name="obj" />

<%
	boolean status = LoginDao.validate(obj);
	if (status) {
		out.println("Conexionconseguida");
		session.setAttribute("session", "TRUE");
	} else {
		out.print(status);
		out.print("*** Se ha encontrado algun error");
%>
<jsp:include page="login.jsp"></jsp:include>
<%
	}
%>
