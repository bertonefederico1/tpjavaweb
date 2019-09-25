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
	ArrayList<Repuesto> misRepuestos = cr.traerRepuestos();
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>SELECCIÓN DE REPUESTOS</b></label>
</div>
<div class="container buscar">
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
							<th scope="col"></th>
							<th scope="col">CÓDIGO</th>
							<th scope="col">DESCRIPCIÓN</th>
							<th scope="col">PRECIO</th>
							<th scope="col">STOCK</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Repuesto r : misRepuestos) {
						%>
						<tr>
						<td>
								<div class="radio">
 									<label><input type="radio" onclick="location='NuevaReparacion.jsp?nro_reparacion=<%=request.getParameter("nro_reparacion")%>&dni=<%=request.getParameter("dni")%>&cod_repuesto=<%=r.getCodigo()%>'" id='express' name="optradio"></label>
								</div>
							</td>
							<td><%=r.getCodigo()%></td>
							<td><%=r.getDescripcion()%></td>
							<td><%=r.getPrecio()%></td>
							<td><%=r.getStock()%></td>
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