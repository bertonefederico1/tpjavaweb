<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion de usuarios</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>VEHICULOS POR CLIENTE</b></label></div>
<body>
<%
	ArrayList<Auto> misVehiculos= (ArrayList<Auto>)request.getSession().getAttribute("misAutos");
	
%>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">DNI</th>
							<th scope="col">NOMBRE Y APELLIDO</th>
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
							<td><%=auto.getCli().getDni()%></td>
							<td><%=auto.getCli().getNombre_y_apellido()%></td>
							<td><%=auto.getPatente()%></td>
							<td><%=auto.getMarca()%> <%=auto.getModelo()%></td>
							<td><%=auto.getAnio()%></td>
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