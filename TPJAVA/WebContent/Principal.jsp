<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="javax.servlet.http.*"%>
<html>
<head>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<title>Pagina Principal</title>	
</head>
<body>
	<div class="shadow-lg p-3 mb-5 bg-white rounded">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="Clientes.jsp">Clientes</a></li>
				<li class="nav-item"><a class="nav-link" href="Mecanicos.jsp">Mecanicos</a></li>
				<li class="nav-item"><a class="nav-link" href="Repuestos.jsp">Repuestos</a></li>
				<li class="nav-item"><a class="nav-link" href="Proveedores.jsp">Proveedores</a></li>
				<li class="nav-item dropdown">
					<li class="nav-item"><a class="nav-link" href="Reparaciones.jsp">Reparaciones</a></li>
				<li class="nav-item"><a class="nav-link" href="Turnos.jsp">Turnos</a></li>
			</ul>
		</div>
		<a style="color: black" class="nav-link" href="Login.jsp">Cerrar Sesion</a> </nav>
	</div>
</body>
	<a href= "Ingreso.jsp">
		<img src="icons/nuevo ingreso.jpg" alt= "NUEVO INGRESO" title= "NUEVO INGRESO" style= "position:relative; top:110px; left:80px" width="200" height="220">
	</a>
	<a href= "NuevaReparacion.jsp">
		<img src="icons/nueva reparacion.jpg" alt= "NUEVA REPARACION" title= "NUEVA REPARACION" style= "position:relative; top:110px; left:370px" width="200" height="220">
	</a>
	<a href= "NuevoTurno.jsp">
		<img src="icons/nuevo turno.jpg" alt= "NUEVO TURNO" title= "NUEVO TURNO"style= "position:relative; top:110px; left:690px" width="200" height="220">
	</a>
</html>