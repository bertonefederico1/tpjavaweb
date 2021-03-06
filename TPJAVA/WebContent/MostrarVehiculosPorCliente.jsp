<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veh�culos</title>
<%
	ControladorVehiculo cv = new ControladorVehiculo();
	ArrayList<Auto> misVehiculos = new ArrayList<Auto>();
	try {
		misVehiculos = cv.vehiculosyClientes();	
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>
</head>
<div id=titulo>
	<h2><b>ADMINISTRACI�N DE VEH�CULOS</b></h2>
</div>
<div class="container buscar">
	<form class="form" method="POST" action="VehiculosPorClienteFiltro">
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
							<th scope="col">DNI</th>
							<th scope="col">CLIENTE</th>
							<th scope="col">PATENTE</th>
							<th scope="col">MARCA Y MODELO</th>
							<th scope="col">A�O</th>
							<th scope="col">CANT KM</th>
							<th scope="col">ACCI�N</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Auto auto : misVehiculos) {
						%>
						<tr>
							<td><%=auto.getCli().getDni()%></td>
							<td><%=auto.getCli().getNombre_y_apellido()%></td>
							<td><%=auto.getPatente()%></td>
							<td><%=auto.getMarca()%> <%=auto.getModelo()%></td>
							<td><%if(auto.getAnio() != 0) {%><%=auto.getAnio()%><%}%></td>
							<td><%=auto.getCantKM()%></td>
							<td>
								<div>
								<a href="EditarVehiculo.jsp?patente=<%=auto.getPatente()%>&marca=<%=auto.getMarca()%>&modelo=<%=auto.getModelo()%>&anio=<%=auto.getAnio()%>&cantidad_km=<%=auto.getCantKM()%>" class="btn btn-warning btn-sm">Modificar</a>
								<a href="ConfirmacionEliminarVehiculo.jsp?patente=<%=auto.getPatente()%>&marca=<%=auto.getMarca()%>&modelo=<%=auto.getModelo()%>&nombre_y_apellido=<%=auto.getCli().getNombre_y_apellido()%>" class="btn btn-danger btn-sm">Eliminar</a>
								</div>							
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="Principal.jsp"><< Ir a la p�gina principal</a>
			</div>
		</div>
	</div>
</body>
</html>