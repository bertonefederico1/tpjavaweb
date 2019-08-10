<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo ingreso</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form method="POST" action="NuevaReparacion">

		<label><div id=fecha class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Fecha</span>
				</div>
				<input type="text" class="form-control" value="asasdasdas"
					disabled="disabled" form style="width: 200px">
			</div></label> <label><div id=cliente class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Cliente</span>
				</div>
				<input type="text" class="form-control" placeholder="Cliente"
					aria-label="cliente" aria-describedby="basic-addon1"
					value="Cliente" disabled="disabled" form style="width: 600px">
				<div id= "botonAgregar">
					<button type="button" onclick = "location='Clientes.jsp'" class="btn btn-success">+ Agregar</button>
				</div>
			</div></label>

		<div id=vehiculo class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">Vehiculo</span>
			</div>
			<input type="text" class="form-control" placeholder="Vehiculo"
				aria-label="username" aria-describedby="basic-addon1">
		</div>

	</form>
</body>
</html>