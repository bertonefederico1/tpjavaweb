<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo ingreso</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	String fechaHoy = formatter.format(fecha);
%>
		<label><div id=fecha class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Fecha</span>
				</div>
				<input type="text" class="form-control" value="<%=fechaHoy%>"
					disabled="disabled" form style="width: 200px">
			</div></label> <label><div id=cliente class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Cliente</span>
				</div>
				<input type="text" class="form-control" placeholder="Cliente"
					aria-label="cliente" aria-describedby="basic-addon1"
					value="Cliente" disabled="disabled" form style="width: 600px">
				<div id= "botonAgregar">
					<button type="button" onclick = "location='Clientes.jsp'" class="btn btn-success">Seleccionar</button>
				</div>
			</div></label>

		<label><div id=vehiculo class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Vehiculo</span>
				</div>
				<input type="text" class="form-control" placeholder="Vehiculo"
					aria-label="cliente" aria-describedby="basic-addon1"
					value="Vehiculo" disabled="disabled" form style="width: 589px">
				<div id= "botonAgregar">
					<button type="button" onclick = "location='VehiculosDelCliente.jsp'" class="btn btn-success">Seleccionar</button>
				</div>
			</div></label>
			
			<label><div id=reparacionesARealizar class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Reparaciones a realizar</span>
				</div>
				<textarea name="reparacionesARealizar" rows="5" cols="54"></textarea>
			</div></label>
			
			<label><div id=observaciones class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Observaciones</span>
				</div>
				<textarea name="observaciones" rows="5" cols="61"></textarea>
			</div></label>

</body>
</html>