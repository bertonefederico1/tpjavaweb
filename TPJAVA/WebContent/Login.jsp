<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id="cuadro">
		<div id= "cabeza">Login</div>
		<div id= "cuerpo">
			<form>
  				<div class="form-group">
    				<label for="">Usuario</label>
    				<input type="text" class="form-control" id="usuario" placeholder="Usuario">
  				</div>
  				<div class="form-group">
    				<label for="">Contraseña</label>
    				<input type="password" class="form-control" id="password" placeholder="Password">
  				</div>
  				<button type="submit" class="btn btn-success">Ingresar</button>
			</form>
		</div>
	</div>	
</body>
</html>