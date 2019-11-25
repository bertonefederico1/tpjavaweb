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
<title>Vehiculos</title>
</head>
<%
	ControladorVehiculo cv = new ControladorVehiculo();
	ArrayList<Auto> misVehiculos = new ArrayList<Auto>();
	misVehiculos = cv.vehiculosyClientes();
%>
</head>
<div id=titulo>
	<label><b>VEHICULOS POR CLIENTE</b></label>
</div>
<div class="container buscar">
	<form class="form" method="POST" action="VehiculosPorClienteFiltro">
		<input type="text" class="form-control" name="txtbuscar" placeholder="Nombre y Apellido"> 
		<input class="btn btn-secondary" type="submit" value="Buscar">
	</form>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">DNI</th>
							<th scope="col">NOMBRE Y APELLIDO</th>
							<th scope="col">PATENTE</th>
							<th scope="col">MARCA Y MODELO</th>
							<th scope="col">AÑO</th>
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
							<td><%=auto.getAnio()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="Principal.jsp"><< Ir a la página principal</a>
			</div>
		</div>
	</div>
</body>
</html>