<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmar eliminación</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><b>SEGURO QUE DESEA ELIMINAR EL REPUESTO: <%=request.getParameter("descripcion")%></b></h2>
<div id=botonesConfirmarEliminacion>
<a href="EliminarRepuesto?codigo=<%=request.getParameter("codigo")%>" class="btn btn-danger">Eliminar</a>
<a href="Repuestos.jsp" class="btn btn-secondary">Cancelar</a>
</div>
</body>
</html>