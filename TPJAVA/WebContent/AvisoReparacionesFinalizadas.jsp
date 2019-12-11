<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aviso reparaciones finalizadas</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<div id=titulo>
	<h2><b>AVISO REPARACION FINALIZADA</b></h2>
</div>

<div class="container">
		<form method="POST" action="EnviarMail">
			<label>
				<div id=vehiculo class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">Asunto </span>
					<input type="text" class="form-control" name="asunto"
						aria-label="cliente" aria-describedby="basic-addon1"></input>
				</div>
			</label> <label><div id=reparacionesARealizar class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Mensaje </span>
					</div>
					<textarea name="mensaje" rows="9" cols="102" maxlength="1000"></textarea>
				</div></label>
			<div id="botonGuardar">
				<button type="submit" class="btn btn-success"
					style="position: relative; top: 10px; left: 20px">Enviar</button>
				<button type="button" class="btn btn-danger"
					onclick="location='Principal.jsp'"
					style="position: relative; top: 10px; left: 40px">Cancelar</button>
			</div>
		</form>
	</div>

</body>
</html>