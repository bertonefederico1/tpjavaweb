<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Modificar Proveedor</title>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<%
		String cuit = request.getParameter("cuit");
		String razon_social = request.getParameter("razon_social");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
	%>
	<div id=plantillaAgregar>
		<form method="POST" action="ModificarProveedor">
			<div class="form-group">
				<label for="cuit"><b>Cuit</b></label> <input type="text"
					class="form-control" readonly="readonly" id="cuit" name="cuit" value="<%=cuit%>"
					maxlength="13" placeholder="20-37312212-5" required>
			</div>
			<div class="form-group">
				<label for="razon_social"><b>Razon Social</b></label> <input
					type="text" class="form-control" id="razon_social" maxlength="500"
					name="razon_social" value="<%=razon_social%>" placeholder="Ejemplo S.A" required>
			</div>

			<div class="form-group">
				<label for="direccion"><b>Direccion</b></label> <input type="text"
					class="form-control" id="direccion"  name="direccion" value="<%=direccion%>"
					maxlength="100" placeholder="Entre Rios 1243" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Telefono</b></label> <input type="number"
						class="form-control"  name="telefono" id="telefono" value="<%=telefono%>"
						maxlength="12" placeholder="420222">
				</div>
				<div class="form-group col-md-6">
					<label for="mail"><b>Mail</b></label> <input type="email"
						class="form-control" id="mail" name="mail" value="<%=mail%>"
						maxlength="100" placeholder="ejemplo@gmail.com">
				</div>
			</div>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_guardar_nuevoCliente"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='Cancelar.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>

</body>
</html>