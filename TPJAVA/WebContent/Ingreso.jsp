<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo ingreso</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	request.getSession().setAttribute("tipo", "ingreso");
	Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	String fechaHoy= formatter.format(fecha);
%>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="container">
		<form method="POST" action="NuevoIngreso">
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
							aria-label="cliente"
							aria-describedby="basic-addon1"
							value="<% if (request.getParameter("dni") != null) {%><%=request.getParameter("dni")%><%}%><%else {%>Cliente<%}%>"
							readonly="readonly" required></input>
						<div id="botonAgregar">
							<button type="button" onclick="location='SeleccionCliente.jsp?tipo=ingreso'"
								class="btn btn-success">+ Agregar</button>
						</div>
					</div></label>
			</p>
			<label>
				<div id=vehiculo class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Vehículo</span>
					</div>
					<input type="text" class="form-control" name="patente"
						aria-label="cliente" aria-describedby="basic-addon1"
						value="<%if (request.getParameter("patente") != null) {%><%=request.getParameter("patente")%><%}%><%else {%>Vehiculo<%}%>" 
						readonly="readonly" required></input>
					<div id="botonAgregar">
						<button type="button" onclick="location='VehiculosDelCliente.jsp?dni=<%=request.getParameter("dni")%>&nombre_y_apellido=<%=request.getParameter("nombre_y_apellido")%>'"
							class="btn btn-success">+ Agregar</button>
					</div>
				</div>
			</label> <label><div id=reparacionesARealizar class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Reparaciones a realizar</span>
					</div>
					<textarea name="reparacionesARealizar" rows="9" cols="102" maxlength="1000"></textarea>
				</div></label>
				 <label><div id=observaciones class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Observaciones</span>
					</div>
					<textarea name="observaciones" rows="9" cols="109" maxlength="1000"></textarea>
				</div></label>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='CancelarIngresoDeDatos.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>
</body>
</html>
