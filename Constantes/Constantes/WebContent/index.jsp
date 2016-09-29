Mi root : <%=request.getContextPath()%> <br/>
o: ${pageContext.request.contextPath} <br/>

Mas exactamente
<%
 ServletContext contexto=request.getServletContext();
 out.println(contexto.getRealPath("."));
 %>
 <br>Que es lo mismo que <%= application.getRealPath("/") %>
 <br/>Ruta:
 <%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>