<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="logica.*"%>
<%@page import="entidades.*"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Página Principal</title>	
<%	
	try {
		ControladorRepuesto cr = new ControladorRepuesto();
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		request.getSession().removeAttribute("fecha_inicio");
		request.getSession().removeAttribute("fecha_inicio");
		request.getSession().removeAttribute("tipo");
		request.getSession().removeAttribute("repuestosSeleccionados");
		request.getSession().removeAttribute("reparaciones_realizadas");
		request.getSession().removeAttribute("cliente_seleccionado");
		request.getSession().removeAttribute("fecha_hoy");
		request.getSession().removeAttribute("manoDeObra");
		request.getSession().removeAttribute("mano_de_obra");
		request.getSession().removeAttribute("reparacion_seleccionada");
		request.getSession().removeAttribute("repuestosFactura");
		request.getSession().removeAttribute("repuestosSeleccionadosOriginal");
		request.getSession().removeAttribute("dia_turno");
		request.getSession().removeAttribute("mes_turno");
		request.getSession().removeAttribute("anio_turno");
		request.getSession().setAttribute("manoDeObra", 0.0);
		request.getSession().setAttribute("precio_total", 0.0);
		request.getSession().setAttribute("misRepuestos", cr.traerRepuestos());
		request.getSession().setAttribute("repuestosSeleccionados", cldr.inicializarLineas());
		request.getSession().setAttribute("repuestosFactura", cldr.inicializarLineas());
		request.getSession().setAttribute("repuestosSeleccionadosOriginal", cldr.inicializarLineas());
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>
</head>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
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
				<li class="nav-item"><a class="nav-link" href="Mecanicos.jsp">Mecánicos</a></li>
				<li class="nav-item"><a class="nav-link" href="Repuestos.jsp">Repuestos</a></li>
				<li class="nav-item"><a class="nav-link" href="Proveedores.jsp">Proveedores</a></li>
				<li class="nav-item"><a class="nav-link" href="MostrarVehiculosPorCliente.jsp">Vehículos por cliente</a></li>
				<li class="nav-item"><a class="nav-link" href="Turnos.jsp">Turnos</a></li>
				<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          		Reparaciones
        		</a>
        		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
          		<a class="dropdown-item" href="ModificarReparacion.jsp">Modificar</a>
          		</div>
      			</li>
				<li class="nav-item"><a class="nav-link" href="Facturar.jsp">Facturar</a></li>
				<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          		Consultas
        		</a>
        		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
          		<a class="dropdown-item" href="Reparaciones.jsp">Reparaciones</a>
          		<a class="dropdown-item" href="ConsultarFactura.jsp">Facturas</a>
          		<a class="dropdown-item" href="RepuestosBajoStock.jsp">Repuestos con bajo stock</a>
          		<a class="dropdown-item" href="RepuestosUsadosEntreFechas.jsp">Repuestos utilizados entre fechas</a>
          		</div>
      			</li>
      			<li class="nav-item"><a class="nav-link" href="AvisoReparacionesFinalizadas.jsp">Avisar reparaciones finalizadas</a></li>
			</ul>
		</div>
		<a style="color: black" class="nav-link" href="Login.jsp">Cerrar Sesión</a> </nav>
	</div>
</body>
	<a href= "Ingreso.jsp">
		<img src="icons/nuevo ingreso.jpg" alt= "NUEVO INGRESO" title= "NUEVO INGRESO" style= "position:relative; top:110px; left:80px" width="200" height="220">
	</a>
	<a href= "NuevaReparacion.jsp">
		<img src="icons/nueva reparacion.jpg" alt= "NUEVA REPARACION" title= "NUEVA REPARACIÓN" style= "position:relative; top:110px; left:370px" width="200" height="220">
	</a>
	<a href= "NuevoTurno.jsp">
		<img src="icons/nuevo turno.jpg" alt= "NUEVO TURNO" title= "NUEVO TURNO"style= "position:relative; top:110px; left:690px" width="200" height="220">
	</a>
</html>