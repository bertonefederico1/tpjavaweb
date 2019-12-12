<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repuestos con bajo stock</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	ControladorRepuesto cr = new ControladorRepuesto();
	ArrayList<Repuesto> misRepuestos = new ArrayList<Repuesto>();  
	try {
		misRepuestos = cr.traerRepuestosBajoStock();
	} catch (Exception e) {
		response.sendRedirect("ErrorGeneral.html");
	}
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<h2><b>REPUESTOS CON BAJO STOCK</b></h2>
</div>
<body>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">CÓDIGO</th>
							<th scope="col">DESCRIPCIÓN</th>
							<th scope="col">STOCK</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Repuesto rep : misRepuestos) {
						%>
						<tr>
							<td><%=rep.getCodigo()%></td>
							<td><%=rep.getDescripcion()%></td>
							<td><%=rep.getStock()%></td>
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