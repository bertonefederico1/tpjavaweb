<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<title>Cacelar</title>
</head>
<body>
<%
	request.getSession().removeAttribute("repuestosSeleccionados");
%>
	<div class="alert alert-danger" role="alert">
 		 Se ha cancelado el ingreso de los datos.
 		 <a href="Principal.jsp" class="alert-link">IR AL INICIO</a>
 	</div>
</body>
</html>