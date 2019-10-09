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
<title>Administración de repuestos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	ControladorRepuesto cr = new ControladorRepuesto();
	request.getSession().setAttribute("misRepuestos", cr.traerRepuestos());
	ArrayList<Repuesto> misRepuestos = (ArrayList<Repuesto>)request.getSession().getAttribute("misRepuestos");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>ADMINISTRACIÓN DE REPUESTOS</b></label>
</div>
<div class="container buscar">
	<button type="button" onclick="location='AgregarRepuesto.jsp'"
		class="btn btn-success">+ Nuevo</button>
	<form class="form" method="POST" action="RepuestoFiltro">
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
							<th scope="col">CÓDIGO</th>
							<th scope="col">DESCRIPCIÓN</th>
							<th scope="col">PRECIO</th>
							<th scope="col">STOCK</th>
							<th scope="col">ACCIÓN</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Repuesto r : misRepuestos) {
						%>
						<tr>
							<td><%=r.getCodigo()%></td>
							<td><%=r.getDescripcion()%></td>
							<td>$ <%=r.getPrecio()%></td>
							<td><%=r.getStock()%></td>
							<td><div>
									<a href="EditarRepuesto.jsp?codigo=<%=r.getCodigo()%>&descripcion=<%=r.getDescripcion()%>&precio=<%=r.getPrecio()%>&stock=<%=r.getStock()%>" class="btn btn-warning btn-sm">Modificar</a>
									<a href="ConfirmacionEliminarRepuesto.jsp?codigo=<%=r.getCodigo()%>&descripcion=<%=r.getDescripcion()%>" class="btn btn-danger btn-sm">Eliminar</a>
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