<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Reparacion> misReparaciones = (ArrayList<Reparacion>)request.getSession().getAttribute("facturasPorFecha");
	int nro_reparacion = Integer.parseInt(request.getParameter("nro_reparacion"));
	ControladorReparacion cr = new ControladorReparacion();
	int indice = cr.buscarIndiceArreglomisReparaciones(misReparaciones, nro_reparacion);
%>
<h1>CLIENTE: <%=misReparaciones.get(indice).getAuto().getCli().getNombre_y_apellido()%></h1>
</body>
</html>