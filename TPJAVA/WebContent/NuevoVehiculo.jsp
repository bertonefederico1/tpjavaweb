<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Nuevo Vehículo</title>
</head>
<body>
	
		<div id=plantillaAgregar>
		<form method="POST" action= "NuevoVehiculo">
			<div class="form-group">
				<label for="NombreYApellido"><b>Patente</b></label> <input type="text"
					class="form-control" id="patente" name="patente"
					placeholder="ABC 135">
			</div>
			<div class="form-group">
				<label for="dni"><b>Marca</b></label> <input type="text"
					class="form-control" id="marca" name="marca"
					placeholder="Honda">
			</div>
			<div class="form-group">
				<label for="direccion"><b>Modelo</b></label> <input type="text"
					class="form-control" id="modelo" name="modelo"
					placeholder="Civic">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Año</b></label> <input type="text"
						class="form-control" name="anio_fabricacion" id="anio_fabricacion"
						placeholder="2015">
				</div>
				<div class="form-group col-md-6">
					<label for="mail"><b>Cantidad de Kms</b></label> <input type="text"
						class="form-control" id="cantidad_km" name="cantidad_km"
						placeholder="135000">
				</div>
			</div>
			<button type="submit" class="btn btn-success">Guardar</button>
			</form>
		</div>
	
</body>
</html>