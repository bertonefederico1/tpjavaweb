<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehiculos</title>
</head>
<% 
	ControladorCliente cc = new ControladorCliente();
	ArrayList<Auto> misVehiculos = new ArrayList<Auto>();
	misVehiculos= cc.vehiculosPorCliente(request.getParameter("dni"));
%>
</head>
<div id=titulo>
	<label><b>VEHICULOS DEL CLIENTE: <%=request.getParameter("nombre_y_apellido")%></b></label>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">PATENTE</th>
							<th scope="col">MARCA Y MODELO</th>
							<th scope="col">AÑO</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Auto auto : misVehiculos) {
						%>
						<tr>
						<td>
								<div class="radio">
									<label><input type="radio" onclick="location='Ingreso.jsp?patente=<%=auto.getPatente()%>&dni=<%=request.getParameter("dni")%>'" id='express' name="optradio"></label>
								</div>
							</td>
							<td><%=auto.getPatente()%></td>
							<td><%=auto.getMarca()%> <%=auto.getModelo()%></td>
							<td><%=auto.getAnio()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href="Ingreso.jsp"><< Volver atrás</a>
			</div>
		</div>
	</div>
</body>
</html>