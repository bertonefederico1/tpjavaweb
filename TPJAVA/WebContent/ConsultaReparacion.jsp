<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.sql.*"%>
<%@page import="datos.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar una Reparacion</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	DatosPersona dp = new DatosPersona();
	ArrayList<Cliente> misClientes = dp.traerClientes();
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>ADMINISTRACION DE CLIENTES</b></label>
</div>
<div class="container buscar">
	<button type="button" class="btn btn-success"
		onclick="location='AgregarCliente.jsp'">+ Nuevo</button>
	<form class="form" action="BusquedaFiltradaClientes.jsp">
		<input type="text" class="form-control" name="txtbuscar"> <input
			class="btn btn-secondary" type="submit" value="Buscar">
	</form>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">DNI</th>
							<th scope="col">NOMBRE Y APELLIDO</th>
							<th scope="col">DIRECCION</th>
							<th scope="col">TELEFONO</th>
							<th scope="col">MAIL</th>
							<th scope="col">ACCION</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Cliente cl : misClientes) {
						%>
						<tr>
							<td>
								<div class="radio">
									<label><input type="radio" id='express' name="optradio"></label>
								</div>
							</td>
							<td><%=cl.getDni()%></td>
							<td><%=cl.getNombre_y_apellido()%></td>
							<td><%=cl.getDireccion()%></td>
							<td><%=cl.getTelefono()%></td>
							<td><%=cl.getMail()%></td>
							<td><div>
									<button type="button" class="btn btn-warning btn-sm">Modificar</button>
									<button type="button" class="btn btn-danger btn-sm">Eliminar</button>
								</div></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>