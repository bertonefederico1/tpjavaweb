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
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<%
		String dni = request.getParameter("dni");
		String nombre_y_apellido = request
				.getParameter("nombre_y_apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
	%>
	<div id=plantillaAgregar>
		<form method="POST" action="ModificarCliente">

			<div class="form-group">
				<label for="dni"><b>Dni</b></label> <input type="number"
					class="form-control" id="dni" name="dni" readonly="readonly"
					maxlength="8" placeholder="40121453" value="<%=dni%>" required>
			</div>

			<div class="form-group">
				<label for="nombre_y_apellido"><b>Nombre y Apellido</b></label> <input
					type="text" class="form-control" id="nombre_y_apellido" maxlength="100"
					name="nombre_y_apellido" value="<%=nombre_y_apellido%>" required>
			</div>
			<div class="form-group">
				<label for="direccion"><b>Direccion</b></label> <input type="text"
					class="form-control" id="direccion" name="direccion" maxlength="100"
					placeholder="Entre Rios 1243" value="<%=direccion%>" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Telefono</b></label> <input type="number"
						class="form-control" name="telefono" id="telefono" maxlength="12"
						placeholder="420222" value="<%=telefono%>">
				</div>
				<div class="form-group col-md-6">
					<label for="mail"><b>Mail</b></label> <input type="email"
						class="form-control" id="mail" name="mail" maxlength="100"
						placeholder="ejemplo@gmail.com" value="<%=mail%>">
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