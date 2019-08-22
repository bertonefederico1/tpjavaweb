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
	<%
		String codigo = request.getParameter("codigo");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("stock");
	%>
	<div id=plantillaAgregar>
		<form method="POST" action="ModificarRepuesto">
		<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Código</b></label> <input
						type="text" readonly="readonly" class="form-control" name="codigo" id="codigo"
						placeholder="1111" value="<%=codigo%>">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="descripcion"><b>Descripcion</b></label> <input
						type="text" class="form-control" name="descripcion"
						id="descripcion" placeholder="Foco Delantero" value="<%=descripcion%>">
				</div>
				<div class="form-group col-md-2">
					<label for="cantidad"><b>Stock</b></label> <input type="text"
						class="form-control" name="stock" id="stock" placeholder="4" value="<%=stock%>">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Precio por unidad ($)</b></label> <input
						type="text" class="form-control" name="precio" id="precio" value="<%=precio%>"
						placeholder="24.80">
				</div>
			</div>
			<button type="submit" class="btn btn-success">Guardar</button>
		</form>
	</div>

</body>
</html>