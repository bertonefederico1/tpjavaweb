<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmar salida</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><b>¿SEGURO QUE DESEA CANCELAR?</b></h2>
<div id=botonesConfirmarEliminacion>
<a href="Principal.jsp" class="btn btn-danger">Salir</a>
<a href=<%if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("ingreso")) {%>"Ingreso.jsp"<%} 
  		else if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("nueva_reparacion")){%>"NuevaReparacion.jsp"<%}
  		else if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("facturar")){%>"Facturar.jsp"<%}
  		else if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("editar_reparacion")){%>"EditarReparacion.jsp"<%}
  		else if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("nuevo_turno")) {%>"NuevoTurno.jsp"<%}%> class="btn btn-secondary">Cancelar</a>
</div>
</body>
</html>