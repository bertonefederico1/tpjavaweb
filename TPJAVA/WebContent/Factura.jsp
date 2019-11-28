<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Factura</title>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<%
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		ControladorReparacion cr = new ControladorReparacion();
		ArrayList<Reparacion> misReparaciones = (ArrayList<Reparacion>) request.getSession().getAttribute("facturasPorFecha");
		int nro_reparacion = Integer.parseInt(request
				.getParameter("nro_reparacion"));
		int indice = cr.buscarIndiceArreglomisReparaciones(misReparaciones, nro_reparacion);
	%>
	<div id=factura>
		<h1>CLIENTE: <%=misReparaciones.get(indice).getAuto().getCli().getNombre_y_apellido()%></h1>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">REPUESTO</th>
					<th scope="col">CANTIDAD</th>
					<th scope="col">PRECIO POR UNIDAD</th>
					<th scope="col">SUBTOTAL</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (LineaDeRepuesto miLinea : misReparaciones.get(indice).getMisLineas()) {
				%>
				<tr>
					<td><%=miLinea.getRepuesto().getDescripcion()%></td>
					<td><%=miLinea.getCantidad()%></td>
					<td><%=miLinea.getRepuesto().getPrecio()%></td>
					<td><%=miLinea.getRepuesto().getPrecio() * miLinea.getCantidad()%></td>
				<%
					}
				%>
			</tbody>
		</table>
		<h3>MANO DE OBRA: <%=cr.precioManoDeObra(misReparaciones.get(indice).getNroReparacion())%></h3>
		<h2><b>TOTAL: <%=cldr.getPrecioTotal(misReparaciones.get(indice).getNroReparacion())%></b></h2>
	</div>
	<a href="ConsultarFactura.jsp"><< Volver</a>
</body>
</html>