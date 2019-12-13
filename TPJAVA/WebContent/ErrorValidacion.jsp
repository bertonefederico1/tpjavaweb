<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="alert alert-danger" role="alert">Los datos ingresados son inválidos
  		<a href=<%if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaCliente")) {%>"Clientes.jsp"<%} 
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaMecanico")){%>"Mecanicos.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaRepuesto")){%>"Repuestos.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaProveedor")){%>"Proveedores.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaNuevoIngreso")){%>"Principal.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaNuevaReparacion")){%>"Principal.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaVehiculo")){%>"MostrarVehiculosPorCliente.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaFechaFactura")){%>"ConsultarFactura.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaRepuestosEntreFechas")){%>"RepuestosUsadosEntreFechas.jsp"<%}
  		else if (request.getSession().getAttribute("error").toString().equalsIgnoreCase("validaNuevoTurno")) {%>"Principal.jsp"<%}%> class="alert-link"> VOLVER</a>
</div>
</body>
</html>
