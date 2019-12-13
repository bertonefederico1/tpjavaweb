<%@page import="logica.ControladorTurno"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logica.*"%>
<%@page import="java.util.*"%>
<%@page import="entidades.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Turnos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
<%
	ControladorTurno ct = new ControladorTurno();
	ArrayList<Turno> misTurnos = new ArrayList<Turno>();
	try {
		misTurnos = ct.traerTurnos();
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo>
	<h2><b>TURNOS PENDIENTES</b></h2>
</div>
<form class="form" method="POST" action="TurnoFiltro">
<div class="container buscar2">
	<div class="container buscar">
		<input type="text" class="form-control" name="buscar_por_fecha" placeholder="Fecha"> 
		<input class="btn btn-secondary" type="submit" name="buscar" value="Buscar Por Fecha">
	</div>
	<div class="container buscar">
		<input type="text" class="form-control" name="buscar_por_cliente" placeholder="Cliente"> 
		<input class="btn btn-secondary" type="submit" name="buscar" value="Buscar Por Cliente">
	</div>
</div>
</form>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">NRO TURNO</th>
							<th scope="col">FECHA TURNO</th>
							<th scope="col">CLIENTE</th>
							<th scope="col">ACCIÓN</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Turno t : misTurnos) {
						%>
						<tr>
							<td><%=t.getNroTurno()%></td>
							<td><%=t.getFechaTurno()%></td>
							<td><%=t.getCliente().getDni()%> - <%=t.getCliente().getNombre_y_apellido()%></td>
							<td><div>
									<a href="ConfirmacionCancelarTurno.jsp?nro_turno=<%=t.getNroTurno()%>&fecha_turno=<%=t.getFechaTurno()%>" class="btn btn-danger btn-sm">CANCELAR TURNO</a>
								</div>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="Principal.jsp"><< Ir a la página principal</a>
			</div>
		</div>
	</div>
</body>
</html>