<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="logica.*"%>
<%@page import="entidades.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Reparación</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<%
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaHoy = formatter.format(fecha);
		request.getSession().setAttribute("tipo", "nueva_reparacion");
		Reparacion rep = new Reparacion ();
		ControladorReparacion cr = new ControladorReparacion();
		ArrayList<LineaDeRepuesto> repuestosSeleccionados = (ArrayList<LineaDeRepuesto>) request.getSession().getAttribute("repuestosSeleccionados");
		if (request.getParameter("dni") != null){
			request.getSession().setAttribute("cliente_seleccionado", request.getParameter("dni"));
		}
		if (request.getParameter("nro_reparacion") != null){
			request.getSession().setAttribute("reparacion_seleccionada", request.getParameter("nro_reparacion"));
			request.getSession().setAttribute("reparacion", cr.traerReparacionPorNro(Integer.parseInt(request.getParameter("nro_reparacion"))));
		}
		if(request.getSession().getAttribute("reparacion") != null){
			rep = (Reparacion) request.getSession().getAttribute("reparacion");
		}
	%>
	<div class="container">
		<form method="POST" action="CargarReparacion">
			<input type="hidden" class="form-control" name="tipo" value="nueva_reparacion">
			<label><div id=fecha class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Fecha</span>
					</div>
					<input type="text" class="form-control" name="fecha_inicio"
						value="<%=fechaHoy%>" readonly="readonly" style="width: 200px">
						<input type="hidden" class="form-control" name="fecha_fin" value="<%=fechaHoy%>">
				</div></label>
			<p>
				<label><div id=cliente class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Cliente</span>
						</div>
						<input type="text" class="form-control" name="dni_cliente"
							aria-label="cliente" aria-describedby="basic-addon1"
							value="<%if (request.getSession().getAttribute("cliente_seleccionado") != null) {%><%=request.getSession().getAttribute("cliente_seleccionado")%><%}%><%else {%>Cliente<%}%>"
							readonly="readonly" required></input>
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
						<span class="input-group-text" id="basic-addon1">Numero de reparacion</span>
					</div>
					<input type="text" class="form-control" name="cod_reparacion"
						aria-label="reparacion" aria-describedby="basic-addon1"
						value="<%if (request.getSession().getAttribute("reparacion_seleccionada") != null) {%><%=request.getSession().getAttribute("reparacion_seleccionada")%><%}%><%else {%>Reparacion<%}%>"
						readonly="readonly" form style="width: 490px" required></input>
					<div id="botonAgregar">
						<button type="button"
							onclick="location='ReparacionesDelCliente.jsp?dni=<%=request.getParameter("dni")%>&tipo=reparacion'"
							class="btn btn-success">+ Agregar</button>
					</div>
				</div>
			</label> 
			<label><div id=observaciones class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Reparaciones a realizar</span>
					</div>
					<textarea name="reparaciones_a_realizar" rows="10" cols="102" readonly="readonly" maxlength="1000"><%if (request.getSession().getAttribute("reparacion_seleccionada") != null) {%><%=rep.getDetalleInicial()%><%}%><%else {%><%}%></textarea>
				</div></label>
			<label><div id=observaciones class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Reparaciones Realizadas</span>
					</div>
					<textarea name="reparaciones_realizadas" rows="10" cols="102" maxlength="1000"><%if (request.getSession().getAttribute("reparaciones_realizadas") != null) {%><%=request.getSession().getAttribute("reparaciones_realizadas")%><%}%><%else {%><%}%></textarea>
				</div></label>
			<div id="titulo">
				<h3>
					<b>REPUESTOS UTILIZADOS</b>
				</h3>
			</div>
			<div class="container buscar">
				<button type="submit" name="btn_reparacion" value="agregar" class="btn btn-warning">+ Agregar</button>
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
								<th scope="col">ACCION</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (LineaDeRepuesto ldr : repuestosSeleccionados) {
							%>
							<tr>
								<td><%=ldr.getRepuesto().getCodigo()%></td>
								<td><%=ldr.getRepuesto().getDescripcion()%></td>
								<td><%=ldr.getRepuesto().getPrecio()%></td>
								<td><%=ldr.getCantidad()%></td>
								<td><a
									href="EliminarRepuestoSeleccionado?cod_repuesto=<%=ldr.getRepuesto().getCodigo()%>&dni=<%=request.getParameter("dni")%>&nro_reparacion=<%=request.getParameter("nro_reparacion")%>"
									class="btn btn-danger btn-sm">Eliminar</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<div class="input-group mb-3">
  						<div class="input-group-prepend">
   						<span class="input-group-text" id="inputGroup-sizing-default"><b>Mano de obra $</b></span>
  						</div>
  						<input type="text" maxlength="10" class="form-control" name="mano_de_obra" value="<%if (request.getSession().getAttribute("mano_de_obra") != null) {%><%=request.getSession().getAttribute("mano_de_obra")%><%}%><% else {%><%}%>"></input>
					</div>
				</div>
			</div>


			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_reparacion" value="guardar"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='CancelarIngresoDeDatos.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
			<div>
				<button type="submit" class="btn btn-success btn-lg btn-block" name="btn_reparacion" value="finalizar"
					style="position: relative; top: 30px">Finalizar reparación</button>
			</div>
		</form>
	</div>
</body>
</html>
