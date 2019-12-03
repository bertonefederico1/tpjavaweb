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
	ArrayList<Repuesto> misRepuestos = cr.traerRepuestosBajoStock();
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<div id=titulo>
	<label><b>REPUESTOS CON BAJO STOCK</b></label>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">CODIGO</th>
							<th scope="col">DESCRIPCION</th>
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
				<a href="Principal.jsp"><< Ir a la pagina principal</a>
			</div>
		</div>
	</div>
</body>
</html>