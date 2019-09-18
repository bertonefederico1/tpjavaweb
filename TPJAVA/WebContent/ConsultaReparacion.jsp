<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Modificar Cliente</title>
<div id=titulo>
	<h2>CLIENTE</h2>
</div>
</head>
<body>

	<div id=consultaReparacion>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Dni</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Nombre y Apellido</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Direccion</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Telefono</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Email</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
		</div>
	</div>
	
	<div id=titulo>
		<p><h2>VEHICULO</h2></p>
	</div>
	
	<div id=consultaReparacion>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Patente</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Marca</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Modelo</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
			<div class="form-group col-md-3.8">
				<b><label for="">Año</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
		</div>
	</div>
	
	<div id=titulo>
		<p><h2>REPARACIÓN</h2></p>
	</div>
	
	<div id=consultaReparacion>
		<div class="row">
			<div class="form-group col-md-4">
				<b><label for="">Fecha de ingreso</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
			<div class="form-group col-md-4">
				<b><label for="">Fecha de finalización</label></b> <input type="text"
					class="form-control" readonly="readonly" value="">
			</div>
		</div>
		<div class="row">
			
			<label><div id=reparacionesARealizar class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Motivo de Ingreso</span>
				</div>
				<textarea name="motivoIngreso" rows="5" cols="55" readonly="readonly"></textarea>
			</div></label>
		</div>
		<div class="row">
		<label><div id=reparacionesARealizar class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Detalles del vehiculo</span>
				</div>
				<textarea name="detallesVehiculo" rows="5" cols="53" readonly="readonly"></textarea>
			</div></label>
	</div>
	<div class="row">
		<label><div id=reparacionesARealizar class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Reparaciones realizadas</span>
				</div>
				<textarea name="reparacionesRealizadas" rows="5" cols="51" readonly="readonly"></textarea>
			</div></label>
	</div>
	</div>
	
		<div id= "contenedor"><a href="Factura.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">Ver factura</button></a></div>
	

</body>
</html>