<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facturas por fecha</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	ArrayList<Reparacion> misReparaciones = (ArrayList<Reparacion>)request.getSession().getAttribute("facturasPorFecha");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>REPARACIONES POR FECHA</b></label>
</div>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">NRO REPARACIÓN</th>
							<th scope="col">CLIENTE</th>
							<th scope="col">VEHÍCULO</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Reparacion rep : misReparaciones) {
						%>
						<tr>
							<td><%=rep.getNroReparacion()%></td>
							<td><%=rep.getAuto().getCli().getNombre_y_apellido()%></td>
							<td><%=rep.getAuto().getMarca()%> <%=rep.getAuto().getModelo()%> <%=rep.getAuto().getAnio()%> </td>
							<td><div>
									<a href="Factura.jsp?nro_reparacion=<%=rep.getNroReparacion()%>" class="btn btn-primary">Ver factura</a>
							</div></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="ConsultarFactura.jsp"><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>