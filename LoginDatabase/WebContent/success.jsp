<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
No est� logonado<br/>
<a href="index.jsp">Por favor, identifiquese</a>
<%} else {
%>
Bienvenido <%=session.getAttribute("userid")%>
<a href='logout.jsp'>Desconectar</a>
<%
    }
%>