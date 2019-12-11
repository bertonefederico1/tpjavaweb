<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Envío Mails</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="alert alert-danger" role="alert">
 		 Hubo un error en el envío del/los email/s
 		 <a href="Principal.jsp" class="alert-link">IR AL INICIO</a>
 	</div>
</body>
</html>