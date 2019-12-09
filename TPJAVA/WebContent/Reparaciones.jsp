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
	ControladorReparacion cr = new ControladorReparacion();
	ArrayList<Reparacion> misReparaciones = cr.traerReparaciones();
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<h2><b>LISTADO DE REPARACIONES</b></h2>
</div>
<div class="container buscar">
	<form class="form" method="POST" action="ReparacionFiltro">
		<input type="text" class="form-control" name="txtbuscar" placeholder="Cliente o Patente"> 
		<input class="btn btn-secondary" type="submit" value="Buscar">
	</form>
</div>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
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
							<th scope="col">PATENTE</th>
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
							<td><%=rep.getAuto().getMarca()%> <%=rep.getAuto().getModelo()%> <%=rep.getAuto().getAnio()%></td>
							<td><%=rep.getAuto().getPatente()%></td>
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
				<a href="Principal.jsp"><< Ir a la pagina principal</a>
			</div>
		</div>
	</div>
</body>
</html>