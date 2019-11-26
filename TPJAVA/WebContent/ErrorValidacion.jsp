<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="alert alert-danger" role="alert">Los datos ingresados son inválidos
  		<a href=<% if (request.getSession().getAttribute("error").equals("modificarCliente")) {response.sendRedirect("Clientes.jsp");}else if (request.getSession().getAttribute("error").equals("modificarMecanico")){response.sendRedirect("Mecanicos.jsp");}%> class="alert-link">VOLVER</a>
	</div>
</body>
</html>