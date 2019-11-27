<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facturar Reparación</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<%
	request.getSession().setAttribute("tipo", "facturar");
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaHoy = formatter.format(fecha);
		ArrayList<LineaDeRepuesto> repuestosFactura = (ArrayList<LineaDeRepuesto>) request.getSession().getAttribute("repuestosFactura");
		if (request.getParameter("dni") != null || request.getParameter("nro_reparacion") != null) {
			request.getSession().setAttribute("cliente_seleccionado",request.getParameter("nombre"));
			request.getSession().setAttribute("reparacion_seleccionada",request.getParameter("nro_reparacion"));
		}
	%>
	<div class="container">
		<form method="POST" action="FacturarReparacion">
			<label><div id=fecha class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Fecha</span>
					</div>
					<input type="text" class="form-control" name="fecha_factura"
						value="<%=fechaHoy%>" readonly="readonly" style="width: 200px">
				</div></label>
			<p>
				<label><div id=cliente class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Cliente</span>
						</div>
						<input type="text" class="form-control" name="nombre_cliente"
							aria-label="cliente" aria-describedby="basic-addon1"
							value="<%if (request.getSession().getAttribute("cliente_seleccionado") != null) {%><%=request.getSession().getAttribute("cliente_seleccionado")%><%}%><%else {%>Cliente<%}%>"
							readonly="readonly"></input> 
						<input type="hidden" name="dni_cliente"
							value="<%if (request.getSession().getAttribute("cliente_seleccionado") != null) {%><%=request.getParameter("dni")%><%}%><%else {%>Cliente<%}%>"></input>
						<div id="botonAgregar">
							<button type="button"
								onclick="location='SeleccionCliente.jsp?tipo=Factura'"
								class="btn btn-success">+ Agregar</button>
						</div>
					</div> </label>
			</p>
			<label>
				<div id=vehiculo class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Numero de reparacion</span>
					</div>
					<input type="text" class="form-control" name="cod_reparacion"
						aria-label="reparacion" aria-describedby="basic-addon1"
						value="<%if (request.getSession().getAttribute("reparacion_seleccionada") != null) {%><%=request.getSession().getAttribute("reparacion_seleccionada")%><%}%><%else {%>Reparacion<%}%>"
						readonly="readonly" form style="width: 490px"></input>
					<div id="botonAgregar">
						<button type="button"
							onclick="location='ReparacionesFinalizadasPorCliente.jsp?dni=<%=request.getParameter("dni")%>&nombre=<%=request.getParameter("nombre")%>&tipo=factura'"
							class="btn btn-success">+ Agregar</button>
					</div>
				</div>
			</label>
			<div id="titulo">
				<h3>
					<b>REPUESTOS UTILIZADOS</b>
				</h3>
			</div>
			<div class="container buscar">
				<button type="submit" name="btn_facturar" value="traer"
					class="btn btn-warning">>>Traer</button>
			</div>
			<div class="row">
				<div class="col-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">CODIGO</th>
								<th scope="col">DESCRIPCION</th>
								<th scope="col">CANTIDAD</th>
								<th scope="col">PRECIO X UNIDAD</th>
								<th scope="col">SUBTOTAL</th>
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
								<td><%=ldr.getRepuesto().getPrecio()%></td>
								<td><%=ldr.getCantidad() * ldr.getRepuesto().getPrecio()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<h3>MANO DE OBRA: $ <%=request.getSession().getAttribute("manoDeObra")%></h3>
					<h2>
						<b>TOTAL: $ <%=request.getSession().getAttribute("precio_total")%> </b>
					</h2>
				</div>
			</div>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_facturar"
					value="facturar" style="position: relative; top: 10px; left: 20px">Facturar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='CancelarIngresoDeDatos.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>
</body>
</html>