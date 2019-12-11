<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de usuarios</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />

<%
	ControladorCliente cc = new ControladorCliente();
	ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
	try {
		misClientes = cc.traerClientes();	
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>

</head>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<div id=titulo>
	<h2><b>ADMINISTRACIÓN DE CLIENTES</b></h2>
</div>
<div class="container buscar">
	<button type="button" class="btn btn-success"
		onclick="location='AgregarCliente.jsp'">+ Nuevo</button>
	<form class="form" method="POST" action="ClienteFiltro">
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
							<th scope="col">DIRECCIÓN</th>
							<th scope="col">TELÉFONO</th>
							<th scope="col">MAIL</th>
							<th scope="col">ACCIÓN</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Cliente cl : misClientes) {
						%>
						<tr>
							<td><%=cl.getDni()%></td>
							<td><%=cl.getNombre_y_apellido()%></td>
							<td><%=cl.getDireccion()%></td>
							<td><%=cl.getTelefono()%></td>
							<td><%=cl.getMail()%></td>
							<td><div>
									<a href="EditarCliente.jsp?dni=<%=cl.getDni()%>&nombre_y_apellido=<%=cl.getNombre_y_apellido()%>&direccion=<%=cl.getDireccion()%>&telefono=<%=cl.getTelefono()%>&mail=<%=cl.getMail()%>" class="btn btn-warning btn-sm">Modificar</a>
									<a href="ConfirmacionEliminarCliente.jsp?dni=<%=cl.getDni()%>&nombre_y_apellido=<%=cl.getNombre_y_apellido()%>" class="btn btn-danger btn-sm">Eliminar</a>
									<a href="NuevoVehiculo.jsp?dni=<%=cl.getDni()%>" class="btn btn-outline-info">Agregar Vehículo</a>						
								</div></td>
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
