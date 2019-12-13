<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="logica.*"%>
<%@page import="entidades.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<%
		Ingreso ingreso = new Ingreso();
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		try {
			int nivel = ingreso.traerNivel(Integer.parseInt(u.getUser()));
			if (nivel < 5) {
				request.getRequestDispatcher("ErrorNivel.html").forward(request,response);	
			}
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request,response);
		}
	%>
</body>
</html>