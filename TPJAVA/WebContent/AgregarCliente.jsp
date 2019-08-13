<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Nuevo Cliente</title>
</head>
<body>
	
		<div id=plantillaAgregar>
		<form method="POST" action= "NuevoCliente">
			<div class="form-group">
				<label for="NombreYApellido"><b>Nombre y Apellido</b></label> <input type="text"
					class="form-control" id="nombreYApellido" name="nombreYApellido"
					placeholder="Juan Perez">
			</div>
			<div class="form-group">
				<label for="dni"><b>Dni</b></label> <input type="text"
					class="form-control" id="dni" name="dni"
					placeholder="40121453">
			</div>
			<div class="form-group">
				<label for="direccion"><b>Direccion</b></label> <input type="text"
					class="form-control" id="direccion" name="direccion"
					placeholder="Entre Rios 1243">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Telefono</b></label> <input type="telefono"
						class="form-control" name="telefono" id="telefono"
						placeholder="420222">
				</div>
				<div class="form-group col-md-6">
					<label for="mail"><b>Mail</b></label> <input type="mail"
						class="form-control" id="mail" name="mail"
						placeholder="ejemplo@gmail.com">
				</div>
			</div>
			<button type="submit" class="btn btn-success">Guardar</button>
			</form>
		</div>
	
</body>
</html>