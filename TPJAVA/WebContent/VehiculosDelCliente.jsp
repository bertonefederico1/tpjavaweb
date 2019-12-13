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
<title>Vehículos del cliente</title>
</head>
<% 
	request.getSession().setAttribute("NuevoVehiculoIngreso","ingreso");
	ControladorVehiculo cv = new ControladorVehiculo();
	ArrayList<Auto> misVehiculos = new ArrayList<Auto>();
	try {
		misVehiculos= cv.vehiculosPorCliente(request.getParameter("dni"));	
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>
</head>
<div id=titulo>
	<label><b>VEHICULOS POR CLIENTE</b></label>
</div>
<div class="container buscar">
	<button type="button" class="btn btn-success"
	onclick="location='NuevoVehiculo.jsp?dni=<%=request.getParameter("dni")%>'">+ Nuevo</button>
</div>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
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
				<a href="Ingreso.jsp"><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>