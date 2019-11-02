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
<title>Editar Reparacion</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaHoy = formatter.format(fecha);
		ControladorReparacion cr = new ControladorReparacion();
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		request.getSession().setAttribute("tipo", "editar_reparacion");
		Reparacion rep = new Reparacion();
		boolean estaModificado = true;
		if (request.getParameter("nro_reparacion") != null) {
			request.getSession().setAttribute("nro_reparacion", request.getParameter("nro_reparacion"));
			estaModificado = false;
		}
		String nro_reparacion_string = request.getSession().getAttribute("nro_reparacion").toString();	
		int nro_reparacion = Integer.parseInt(nro_reparacion_string);
		rep = cr.traerReparacionPorNro(nro_reparacion);
		ArrayList <LineaDeRepuesto> misLineas = null;
 		if (estaModificado) { 
 			misLineas = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionados");
 		} else {
 			request.getSession().setAttribute("repuestosSeleccionados", cldr.traerRepuestosReparacion(nro_reparacion));
 			request.getSession().setAttribute("repuestosSeleccionadosOriginal", cldr.traerRepuestosReparacion(nro_reparacion));
 			misLineas = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionados");
 		}
			
	%>
	<div class="container">
		<form method="POST" action="CargarReparacion">
			<input type="hidden" class="form-control" name="tipo" value="editar_reparacion">
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
							value="<%=rep.getAuto().getCli().getNombre_y_apellido()%>"
							readonly="readonly"></input>
					</div></label>
			</p>
			
			<label>
				<div id=vehiculo class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Numero de
							reparacion</span>
					</div>
					<input type="text" class="form-control" name="cod_reparacion"
						aria-label="reparacion" aria-describedby="basic-addon1"
						value="<%=rep.getNroReparacion()%>"
						readonly="readonly"></input>
				</div></label> 
				
				<label><div id=observaciones class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Reparaciones
							Realizadas</span>
					</div>
					<textarea name="reparaciones_realizadas" rows="5" cols="61" ><%if (rep.getDescFinal() != null) {%><%=rep.getDescFinal()%><%}%><%else {%><%}%></textarea>
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
								for (LineaDeRepuesto ldr : misLineas) {
									%>
									<tr>
										<td><%=ldr.getRepuesto().getCodigo()%></td>
										<td><%=ldr.getRepuesto().getDescripcion()%></td>
										<td><%=ldr.getRepuesto().getPrecio()%></td>
										<td><%=ldr.getCantidad()%></td>
										<td><a
											href="EliminarRepuestoModificar?cod_repuesto=<%=ldr.getRepuesto().getCodigo()%>&nro_reparacion=<%=request.getParameter("nro_reparacion")%>"
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
  						<input type="text" class="form-control" name="mano_de_obra" value="<%if (rep.getPrecioManoDeObra() != 0) {%><%=rep.getPrecioManoDeObra()%><%}%><%else {%><%=0.0%><%}%>">
					</div>
				</div>
			</div>


			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_reparacion" value="guardarReparacionModificada"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='CancelarIngresoDeDatos.html'"
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