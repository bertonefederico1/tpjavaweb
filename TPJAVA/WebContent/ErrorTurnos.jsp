<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Turnos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="alert alert-danger" role="alert"> 
	<%if (request.getSession().getAttribute("errorTurno").toString().equalsIgnoreCase("turnoExistente")) {%>
	Ya existe un turno para esa fecha y cliente<%} else {%>Se superó la cantidad máxima de turnos para ese día<%}%>
  		<a href="NuevoTurno.jsp" class="alert-link"> VOLVER</a>
</body>
</html>