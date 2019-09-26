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
<title>Administracion de repuestos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>ADMINISTRACION DE REPUESTOS</b></label>
</div>
<body>
	<%
		ArrayList<Repuesto> misRepuestos = (ArrayList<Repuesto>) request
				.getSession().getAttribute("misRepuestos");
	%>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">CODIGO</th>
							<th scope="col">DESCRIPCION</th>
							<th scope="col">PRECIO</th>
							<th scope="col">STOCK</th>
							<th scope="col">ACCION</th>
						</tr>
					</thead>
					<tbody>

						<%
							for (Repuesto r : misRepuestos) {
						%>
						<tr>
							<td><%=r.getCodigo()%></td>
							<td><%=r.getDescripcion()%></td>
							<td><%=r.getPrecio()%></td>
							<td><%=r.getStock()%></td>
							<td><div class="container seleccionRepuesto">
									<form class="seleccion" method="POST" action="RepuestoReparacion">
										<input type="text" class="form-control" placeholder="Cantidad" name="cantidad">
										 <input class="btn btn-success btn-sm" type="submit" value="+ Agregar">
									</form>
								</div></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="SeleccionRepuesto.jsp"><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>