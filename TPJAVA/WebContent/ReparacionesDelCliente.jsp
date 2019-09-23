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
	ArrayList<Reparacion> misReparaciones = cr.reparacionesPorCliente(request.getParameter("dni"));
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>LISTADO DE REPARACIONES DEL CLIENTE: <%=request.getParameter("nombre_y_apellido") %></b></label>
</div>
<div class="container buscar">
	<form class="form" method="POST" action="ReparacionFiltro">
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
							<th scope="col">NRO REPARACION</th>
							<th scope="col">FECHA DE INGRESO</th>
							<th scope="col">CLIENTE</th>
							<th scope="col">VEHICULO</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Reparacion rep : misReparaciones) {
						%>
						<tr>
						<td>
                 <div class="radio">
                     <label><input type="radio" onclick="location='NuevaReparacion.jsp?dni=<%=request.getParameter("dni")%>&nro_reparacion=<%=rep.getNroReparacion()%>'" id='express' name="optradio"></label>
                </div>
             </td>
							<td><%=rep.getNroReparacion()%></td>
							<td><%=rep.getFechaIngreso()%></td>
							<td><%=rep.getAuto().getCli().getNombre_y_apellido()%></td>
							<td><%=rep.getAuto().getMarca()%> <%=rep.getAuto().getModelo()%> <%=rep.getAuto().getAnio()%> </td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="NuevaReparacion.jsp"><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>