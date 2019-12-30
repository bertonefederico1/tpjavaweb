<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reparaciones por cliente</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	ControladorReparacion cr = new ControladorReparacion();
	ArrayList<Reparacion> misReparaciones = new ArrayList<Reparacion>();
	try {
		misReparaciones = cr.reparacionesPorCliente(request.getParameter("dni"));
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
	if (request.getParameter("tipo").equalsIgnoreCase("reparacion")) {
		request.getSession().setAttribute("tipo", "reparacion");
	} else {
		request.getSession().setAttribute("tipo", "factura");
	}
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<h2><b>LISTADO DE REPARACIONES POR CLIENTE</b></h2>
</div>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">NRO REPARACIÓN</th>
							<th scope="col">FECHA DE INGRESO</th>
							<th scope="col">CLIENTE</th>
							<th scope="col">PATENTE</th>
							<th scope="col">VEHÍCULO</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Reparacion rep : misReparaciones) {
						%>
						<tr>
							<td>
				                 <div class="radio">
				                     <label><input type="radio" onclick=<%if (request.getParameter("tipo").equalsIgnoreCase("reparacion")) {%>"location='NuevaReparacion.jsp?dni=<%=request.getParameter("dni")%>&nro_reparacion=<%=rep.getNroReparacion()%>'"<%} else {%>"location='Facturar.jsp?dni=<%=request.getParameter("dni")%>&nombre=<%=request.getParameter("nombre")%>&nro_reparacion=<%=rep.getNroReparacion()%>'"<%}%> id='express' name="optradio"></label>
				                </div>
	             			</td>
							<td><%=rep.getNroReparacion()%></td>
							<td><%=rep.getFechaIngreso()%></td>
							<td><%=rep.getAuto().getCli().getNombre_y_apellido()%></td>
							<td><%=rep.getAuto().getPatente()%> </td>
							<td><%=rep.getAuto().getMarca()%> <%=rep.getAuto().getModelo()%> <%=rep.getAuto().getAnio()%> </td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href=<%if(request.getParameter("tipo").equalsIgnoreCase("reparacion")) {%>"NuevaReparacion.jsp"<%} else {%>"Facturar.jsp"<%}%>><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>