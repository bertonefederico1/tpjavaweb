<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>No hay stock suficiente</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="alert alert-danger" role="alert">No hay stock suficiente
  		<a href=<%if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("nueva_reparacion")) {%>"NuevaReparacion.jsp"<%} 
  		else {%>"EditarReparacion.jsp"<%}%> class="alert-link"> VOLVER</a>
</div>
</body>
</html>
