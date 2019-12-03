<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Repuestos utilizados entre fechas</title>
</head>
<h1><b>REPUESTOS UTILIZADOS ENTRE FECHAS </b></h1>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div id=plantillaAgregar>
		<form method="POST" action="RepuestosUsadosEntreFechas">
		<h4><b>FECHA INICIO:</b></h4>
			<div class="form-row">
				<div class="form-group col-md-1">
					<label for="dia"><b>Dia</b></label> 
					<input type="number" class="form-control" min="1" max="31" name="dia_inicio" id="dia" placeholder="01" required>
				</div>
				<div class="form-group col-md-1">
					<label for="mes"><b>Mes</b></label> 
					<input type="number" class="form-control" min="1" max="12" name="mes_inicio" id="mes" placeholder="12" required>
				</div>
				<div class="form-group col-md-1">
					<label for="anio"><b>Año</b></label> 
					<input type="number" class="form-control" name="anio_inicio" id="anio" placeholder="2019" required>
				</div>
			</div>
			
		<h4><b>FECHA FIN:</b></h4>
		<div class="form-row">
				<div class="form-group col-md-1">
					<label for="dia"><b>Dia</b></label> 
					<input type="number" class="form-control" min="1" max="31" name="dia_fin" id="dia" placeholder="03" required>
				</div>
				<div class="form-group col-md-1">
					<label for="mes"><b>Mes</b></label> 
					<input type="number" class="form-control" min="1" max="12" name="mes_fin" id="mes" placeholder="12" required>
				</div>
				<div class="form-group col-md-1">
					<label for="anio"><b>Año</b></label> 
					<input type="number" class="form-control" name="anio_fin" id="anio" placeholder="2019" required>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Consultar</button>
		</form>
	</div>
<p><a href="Principal.jsp"><< Ir a la pagina principal</a></p>
</body>
</html>