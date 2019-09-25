<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="logica.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Reparacion</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaHoy = formatter.format(fecha);
		
		/* int cod_repuesto = Integer.parseInt(request.getParameter("cod_repuesto"));
		int cantidad;
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		cldr.traerRepuestoSeleccionado(cod_repuesto, cantidad); */
	%>
	<div class="container">
		<form method="POST" action="NuevaReparacion">
			<label><div id=fecha class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Fecha</span>
					</div>
					<input type="text" class="form-control" name="fecha"
						value="<%=fechaHoy%>" readonly="readonly" style="width: 200px">
				</div></label>
			<p>
				<label><div id=cliente class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Cliente</span>
						</div>
						<input type="text" class="form-control" name="dni_cliente"
							aria-label="cliente" aria-describedby="basic-addon1"
							value="<%if (request.getParameter("dni") != null) {%><%=request.getParameter("dni")%><%}%><%else {%>Cliente<%}%>"
							readonly="readonly"></input>
						<div id="botonAgregar">
							<button type="button"
								onclick="location='SeleccionCliente.jsp?tipo=reparacion'"
								class="btn btn-success">+ Agregar</button>
						</div>
					</div></label>
			</p>
			<label>
				<div id=vehiculo class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Numero de
							reparacion</span>
					</div>
					<input type="text" class="form-control" name="reparacion"
						aria-label="reparacion" aria-describedby="basic-addon1"
						value="<%if (request.getParameter("nro_reparacion") != null) {%><%=request.getParameter("nro_reparacion")%><%}%><%else {%>Reparacion<%}%>"
						readonly="readonly" form style="width: 490px">
					<div id="botonAgregar">
						<button type="button"
							onclick="location='ReparacionesDelCliente.jsp?dni=<%=request.getParameter("dni")%>&nombre_y_apellido=<%=request.getParameter("nombre_y_apellido")%>'"
							class="btn btn-success">+ Agregar</button>
					</div>
				</div>
			</label>


			<div class="container buscar">
				<button type="button" class="btn btn-success" onclick="location='SeleccionRepuesto.jsp?nro_reparacion=<%=request.getParameter("nro_reparacion")%>&dni=<%=request.getParameter("dni")%>'">+ Agregar</button>
			</div>
			<div class="row">
				<div class="col-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">CODIGO</th>
								<th scope="col">DESCRIPCION</th>
								<th scope="col">PRECIO X UNIDAD</th>
								<th scope="col">CANTIDAD</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < 10; i++) {
							%>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><a href="#" class="btn btn-danger btn-sm">Eliminar</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>


			<div id="botonGuardar">
				<button type="submit" class="btn btn-success"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='Cancelar.html'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>
</body>
</html>