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
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<jsp:include page="ValidaNivelUsuario5.jsp"></jsp:include>
<h2><b>SEGURO QUE DESEA ELIMINAR EL PROVEEDOR: <%=request.getParameter("razon_social")%></b></h2>
<div id=botonesConfirmarEliminacion>
<a href="EliminarProveedor?cuit=<%=request.getParameter("cuit")%>" class="btn btn-danger">Eliminar</a>
<a href="Proveedores.jsp" class="btn btn-secondary">Cancelar</a>
</div>
</body>
</html>