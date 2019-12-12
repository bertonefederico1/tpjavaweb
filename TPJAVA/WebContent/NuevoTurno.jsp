<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Turno</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	request.getSession().setAttribute("tipo", "nuevo_turno");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<h1><b>NUEVO TURNO</b></h1>
</div>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="container">
		<form method="POST" action="GenerarTurno">
			<h4><b>Fecha Turno:</b></h4>
				<div class="form-row">
					<div class="form-group col-md-1">
						<label for="dia"><b>Día</b></label> 
						<input type="number" class="form-control" value="<%if (request.getSession().getAttribute("dia_turno") != null) {%><%=request.getSession().getAttribute("dia_turno")%><%}%>" min="1" max="31" name="dia_turno" id="dia" placeholder="01">
					</div>
					<div class="form-group col-md-1">
						<label for="mes"><b>Mes</b></label> 
						<input type="number" class="form-control" value="<%if (request.getSession().getAttribute("mes_turno") != null) {%><%=request.getSession().getAttribute("mes_turno")%><%}%>" min="1" max="12" name="mes_turno" id="mes" placeholder="12">
					</div>
					<div class="form-group col-md-1">
						<label for="anio"><b>Año</b></label> 
						<input type="number" class="form-control" value="<%if (request.getSession().getAttribute("anio_turno") != null) {%><%=request.getSession().getAttribute("anio_turno")%><%}%>" name="anio_turno" id="anio" placeholder="2019">
					</div>
			</div>
			<label><div id=cliente class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Cliente</span>
				</div>
				<input type="text" class="form-control" name="dni_cliente"
					aria-label="cliente" aria-describedby="basic-addon1"
					value="<% if (request.getParameter("dni") != null) {%><%=request.getParameter("dni")%><%}%><%else {%>Cliente<%}%>"
					readonly="readonly" required></input>
				<input type="hidden" class="form-control" name="tipo" value="turno"></input>
				<div id="botonAgregar">
					<button type="submit" name="btn_turno" value="agregar" class="btn btn-success">+ Agregar</button>
				</div>
			</div></label>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success" name="btn_turno" value="guardar"
					style="position: relative; top: 10px; left: 20px">Guardar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='CancelarIngresoDeDatos.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>	
		</form>
	</div>
</body>
</html>