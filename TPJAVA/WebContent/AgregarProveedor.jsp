<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Nuevo Proveedor</title>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div id=plantillaAgregar>
		<form method="POST" action="NuevoProveedor">
			<label><b>Cuit</b></label>
			<div class="form-row">
				<div class="form-group col-md-1">
					<input type="number"
						class="form-control" name="cuit_prefijo" id="cuit_prefijo" maxlength="2"
						placeholder="21">
				</div>
				<b>-</b>
				<div class="form-group col-md-3">
					<input type="number" class="form-control" id="cuit_mitad" name="cuit_mitad" maxlength="8"
						placeholder="40192313">
				</div>
				<b>-</b>
				<div class="form-group col-md-1">
					<input type="number" class="form-control" id="cuit_sufijo" name="cuit_sufijo" maxlength="1"
						placeholder="5">
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="razon_social"><b>Razon Social</b></label> <input
					type="text" class="form-control" id="razon_social" maxlength="500"
					name="razon_social" placeholder="Ejemplo S.A" required>
			</div>

			<div class="form-group">
				<label for="direccion"><b>Direccion</b></label> <input type="text"
					class="form-control" id="direccion" name="direccion" maxlength="100"
					placeholder="Entre Rios 1243" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Telefono</b></label> <input type="number"
						class="form-control" name="telefono" id="telefono" maxlength="12"
						placeholder="420222">
				</div>
				<div class="form-group col-md-6">
					<label for="mail"><b>Mail</b></label> <input type="email"
						class="form-control" id="mail" name="mail" maxlength="100"
						placeholder="ejemplo@gmail.com">
				</div>
			</div>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_guardar_nuevoCliente"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='Principal.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>

</body>
</html>