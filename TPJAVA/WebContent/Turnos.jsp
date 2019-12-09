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
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	ControladorTurno ct = new ControladorTurno();
	request.getSession().setAttribute("misTurnos", ct.traerTurnos());
	ArrayList<Turno> misTurnos = (ArrayList<Turno>)request.getSession().getAttribute("misTurnos");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<div id=titulo>
	<h1><b>LISTADO DE TURNOS</b></h1>
</div>
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
				<a href="Principal.jsp"><< Ir a la pagina principal</a>
			</div>
		</div>
	</div>
</body>
</html>