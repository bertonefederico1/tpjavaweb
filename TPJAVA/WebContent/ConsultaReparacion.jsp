<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Consulta Reparación</title>

<%
	ControladorReparacion cr = new ControladorReparacion();
	ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
	Reparacion rep = new Reparacion();
	ArrayList<LineaDeRepuesto> repuestosFactura = new ArrayList<LineaDeRepuesto>();
	try {
		rep = cr.traerReparacionPorNro(Integer.parseInt(request.getParameter("nro_reparacion")));
		repuestosFactura = cldr.traerRepuestosUtilizados(Integer.parseInt(request.getParameter("nro_reparacion")));
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div id=titulo>
		<h2>CLIENTE</h2>
	</div>
	<div id=consultaReparacion>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Dni</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getCli().getDni()%>">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Nombre y Apellido</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getCli().getNombre_y_apellido()%>">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Dirección</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getCli().getDireccion()%>">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Teléfono</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%if (rep.getAuto().getCli().getTelefono() != null) {%><%=rep.getAuto().getCli().getTelefono()%><%}%><%else {%> <%}%>">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Email</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%if (rep.getAuto().getCli().getMail() != null) {%><%=rep.getAuto().getCli().getMail()%><%}%><%else {%> <%}%>">
			</div>
		</div>
	</div>

	<div id=titulo>
		<p>
		<h2>VEHICULO</h2>
		</p>
	</div>

	<div id=consultaReparacion>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Patente</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getPatente()%>">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Marca</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getMarca()%>">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Modelo</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getModelo()%>">
			</div>
			<div class="form-group col-md-3.8">
				<b><label for="">Año</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getAuto().getAnio()%>">
			</div>
		</div>
	</div>

	<div id=titulo>
		<p>
		<h2>REPARACIÓN</h2>
		</p>
	</div>

	<div id=consultaReparacion>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Número De Reparación</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getNroReparacion()%>">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Fecha de ingreso</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%=rep.getFechaIngreso()%>">
			</div>
			<div class="form-group col-md-3.8">
				<b><label for="">Fecha de inicio</label></b> <input type="text"
					class="form-control" readonly="readonly"
					value="<%if (rep.getFechaInicio() != null) {%><%=rep.getFechaInicio()%><%}%><%else {%>No iniciada<%}%>">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Fecha de finalización</label></b> <input
					type="text" class="form-control" readonly="readonly"
					value="<%if (rep.getFechaFin() != null) {%><%=rep.getFechaFin()%><%}%><%else {%>No finalizada<%}%>">
			</div>
		</div>

		<div class="row">
			<div id="mecanico">
				<h3>
					<b><label>MECÁNICO: <% if (rep.getMecanico().getNombre_y_apellido() != null) {%>
												<%=rep.getMecanico().getNombre_y_apellido()%> <%
 											} else { %>
 												No Asignado
 										 <% } %>
					</label></b>
				</h3>
			</div>
		</div>
		<div class="row">
			<label><div id=reparacionesARealizar class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Motivo de Ingreso</span>
					</div>
					<textarea name="motivoIngreso" rows="5" cols="55"
						readonly="readonly"><%=rep.getDetalleInicial()%></textarea>
				</div></label>
		</div>
		<div class="row">
			<label><div id=reparacionesARealizar class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Detalles del vehiculo</span>
					</div>
					<textarea name="detallesVehiculo" rows="5" cols="53"
						readonly="readonly">
						<% if (rep.getObservaciones() != null) { %>
							<%=rep.getObservaciones()%> <%
						} else { %> 
						<% } %>
					</textarea>
				</div></label>
		</div>
		<div class="row">
			<label><div id=reparacionesARealizar class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Reparaciones realizadas</span>
					</div>
					<textarea name="reparacionesRealizadas" rows="5" cols="51"
						readonly="readonly">
						<% if (rep.getDescFinal() != null) { %>
							<%=rep.getDescFinal()%>
						<%} else { %> 
						<% } %>
					</textarea>
				</div></label>
		</div>
		<div class="row">

			<h3>
				<b><label>REPUESTOS UTILIZADOS</label></b>
			</h3>
		</div>
		<div class="row">
			<div class="col-10">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">CÓDIGO</th>
							<th scope="col">DESCRIPCIÓN</th>
							<th scope="col">CANTIDAD</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (LineaDeRepuesto ldr : repuestosFactura) {
						%>
						<tr>
							<td><%=ldr.getRepuesto().getCodigo()%></td>
							<td><%=ldr.getRepuesto().getDescripcion()%></td>
							<td><%=ldr.getCantidad()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<button type="button" class="btn btn-primary btn-lg btn-block"
		onclick="location='Reparaciones.jsp'"
		style="position: relative; top: 10px">Volver</button>
</body>
</html>