<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Consulta Factura</title>
</head>
<h1><b>CONSULTAR FACTURAS POR FECHA: </b></h1>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<jsp:include page="ValidaNivelUsuario5.jsp"></jsp:include>
	<div id=plantillaAgregar>
		<form method="POST" action="ConsultaFactura">
			<div class="form-row">
				<div class="form-group col-md-1">
					<label for="dia"><b>Día</b></label> 
					<input type="number" class="form-control" min="1" max="31" maxlength="2" name="dia" id="dia" placeholder="01" required>
				</div>
				<div class="form-group col-md-1">
					<label for="mes"><b>Mes</b></label> 
					<input type="number" class="form-control" min="1" max="12" maxlength="2" name="mes" id="mes" placeholder="12" required>
				</div>
				<div class="form-group col-md-1">
					<label for="anio"><b>Año</b></label> 
					<input type="number" class="form-control" maxlength="4" name="anio" id="anio" placeholder="2019" required>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Consultar</button>
		</form>
	</div>
<p><a href="Principal.jsp"><< Ir a la página principal</a></p>
</body>
</html>