<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<title>Nuevo Repuesto</title>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<jsp:include page="ValidaNivelUsuario5.jsp"></jsp:include>
	<div id=plantillaAgregar>
		<form method="POST" action="NuevoRepuesto">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="descripcion"><b>Descripcion</b></label> <input
						type="text" class="form-control" name="descripcion" maxlenght="100" 
						id="descripcion" placeholder="Foco Delantero" required
						value="<%if (request.getSession().getAttribute("descripcion") != null) {%><%=request.getSession().getAttribute("descripcion")%><%}%><%else {%><%}%>">
				</div>
				<div class="form-group col-md-2">
					<label for="cantidad"><b>Cantidad</b></label> <input type="number"
						class="form-control" name="cantidad" id="cantidad" min="1" placeholder="4" required
						value="<%if (request.getSession().getAttribute("cantidad") != null) {%><%=request.getSession().getAttribute("cantidad")%><%}%><%else {%><%}%>">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telefono"><b>Precio por unidad ($)</b></label> <input
						type="number" step="any" class="form-control" name="precio" id="precio" placeholder="24.80" required 
						value="<%if (request.getSession().getAttribute("precio") != null) {%><%=request.getSession().getAttribute("precio")%><%}%><%else {%><%}%>">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="cuit"><b>Proveedor</b></label> 
					<input class="form-control" readonly="readonly" name="cuit" id="cuit" required
					value=<%if (request.getParameter("cuit") != null) {%><%=request.getParameter("cuit")%><%} else {%><%}%>>
				</div>
				<div id="botonAgregar">
					<button type="submit" name="btn_guardar_nuevoCliente" value="agregar_proveedor" style="position: relative; top: 32px" class="btn btn-success">+ Agregar</button>
				</div>
			</div>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_guardar_nuevoCliente" value="guardar"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='Principal.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>
</body>
</html>
