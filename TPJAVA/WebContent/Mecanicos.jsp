<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.sql.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de Mecanicos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	ControladorMecanico cm = new ControladorMecanico();
	ArrayList<Mecanico> misMecanicos = cm.traerMecanicos();
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>ADMINISTRACION DE MECANICOS</b></label>
</div>
<div class="container buscar">
	<button type="button" class="btn btn-success"
		onclick="location='AgregarMecanico.jsp'">+ Nuevo</button>
	<form class="form" method= "POST" action="MecanicoFiltro">
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
							<th scope="col">MATRICULA</th>
							<th scope="col">NOMBRE Y APELLIDO</th>
							<th scope="col">DIRECCION</th>
							<th scope="col">TELEFONO</th>
							<th scope="col">MAIL</th>
							<th scope="col">ACCION</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Mecanico me : misMecanicos) {
						%>
						<tr>
							<td><%=me.getMatricula()%></td>
							<td><%=me.getNombre_y_apellido()%></td>
							<td><%=me.getDireccion()%></td>
							<td><%=me.getTelefono()%></td>
							<td><%=me.getMail()%></td>
							<td><div>
									<a href="EditarMecanico.jsp?matricula=<%=me.getMatricula()%>&nombre_y_apellido=<%=me.getNombre_y_apellido()%>&direccion=<%=me.getDireccion()%>&telefono=<%=me.getTelefono()%>&mail=<%=me.getMail()%>" class="btn btn-warning btn-sm">Modificar</a>
									<a href="ConfirmacionEliminarMecanico.jsp?matricula=<%=me.getMatricula()%>&nombre_y_apellido=<%=me.getNombre_y_apellido()%>" class="btn btn-danger btn-sm">Eliminar</a>
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