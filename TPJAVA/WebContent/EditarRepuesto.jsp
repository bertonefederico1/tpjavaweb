<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Modificar Repuesto</title>
<%
	String codigo = request.getParameter("codigo");
	String descripcion = request.getParameter("descripcion");
	String precio = request.getParameter("precio");
	String stock = request.getParameter("stock");
%>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<jsp:include page="ValidaNivelUsuario5.jsp"></jsp:include>
	<div id=plantillaAgregar>
		<form method="POST" action="ModificarRepuesto">
		<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>C�digo</b></label> <input
						type="number" readonly="readonly" class="form-control" name="codigo" id="codigo"
						placeholder="1111" value="<%=codigo%>" required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="descripcion"><b>Descripci�n</b></label> <input
						type="text" class="form-control" name="descripcion" maxlength="100"
						id="descripcion" placeholder="Foco Delantero" value="<%=descripcion%>" required>
				</div>
				<div class="form-group col-md-2">
					<label for="cantidad"><b>Stock</b></label> <input type="number"
						class="form-control" name="stock" id="stock" min="1" placeholder="4" value="<%=stock%>" required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Precio por unidad ($)</b></label> <input
						type="number" step="any" class="form-control" name="precio" id="precio" value="<%=precio%>"
						placeholder="24.80" required>
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