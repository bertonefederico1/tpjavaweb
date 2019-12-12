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
<%
	String patente = request.getParameter("patente");
	String marca = request.getParameter("marca");
	String modelo = request.getParameter("modelo");
	String anio = request.getParameter("anio");
	String cantidad_km = request.getParameter("cantidad_km");
%>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div id=plantillaAgregar>
		<form method="POST" action= "ModificarVehiculo">
			<input type="hidden" name="patente_original" value="<%=request.getParameter("patente")%>">
			<div class="form-group">
				<label for="patente"><b>Patente</b></label> <input type="text"
					class="form-control" id="patente" name="patente" value="<%=patente%>" maxlength="9" required>
			</div>
			<div class="form-group">
				<label for="marca"><b>Marca</b></label> <input type="text"
					class="form-control" id="marca" name="marca" maxlength="100" value="<%=marca%>" required>
			</div>
			<div class="form-group">
				<label for="modelo"><b>Modelo</b></label> <input type="text"
					class="form-control" id="modelo" name="modelo" value="<%=modelo%>" maxlength="100" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="anio"><b>Año</b></label> <input type="number"
						class="form-control" name="anio" value="<%if (!(anio.equals("0"))) {%><%=anio%><%}%>" id="anio" maxlength="4">
				</div>
				<div class="form-group col-md-6">
					<label for="cant_kml"><b>Cantidad de Kms</b></label> <input type="number"
						class="form-control" id="cantidad_km" name="cantidad_km" value="<%=cantidad_km%>">
				</div>
			</div>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='Principal.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>
</body>
</html>