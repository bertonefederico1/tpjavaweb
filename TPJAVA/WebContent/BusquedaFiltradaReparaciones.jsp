<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reparaciones</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	ArrayList<Reparacion> misReparaciones = (ArrayList<Reparacion>)request.getSession().getAttribute("misReparaciones");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>LISTADO DE REPARACIONES</b></label>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">NRO REPARACION</th>
							<th scope="col">FECHA DE INGRESO</th>
							<th scope="col">ESTADO</th>
							<th scope="col">CLIENTE</th>
							<th scope="col">VEHICULO</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Reparacion rep : misReparaciones) {
						%>
						<tr>
							<td><%=rep.getNroReparacion()%></td>
							<td><%=rep.getFechaIngreso()%></td>
							<td><%=rep.getEstado()%></td>
							<td><%=rep.getAuto().getCli().getNombre_y_apellido()%></td>
							<td><%=rep.getAuto().getMarca()%> <%=rep.getAuto().getModelo()%> <%=rep.getAuto().getAnio()%> </td>
							<td><div>
									<a href="ConsultaReparacion.jsp?nro_reparacion=<%=rep.getNroReparacion()%>" class="btn btn-outline-info">Ver más</a>
									<a href="ConfirmarEliminarReparacion.jsp?nro_reparacion=<%=rep.getNroReparacion()%>" class="btn btn-danger btn-sm">Eliminar</a>
							</div></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="Reparaciones.jsp"><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>