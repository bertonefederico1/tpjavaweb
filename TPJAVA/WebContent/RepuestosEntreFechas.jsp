<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repuestos utilizados entre fechas</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	ArrayList<LineaDeRepuesto> misLineas = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosEntreFechas");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<div id=titulo>
	<label><b>REPUESTOS UTILIZADOS ENTRE LAS FECHAS: </b></label>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">CÓDIGO</th>
							<th scope="col">DESCRIPCIÓN</th>
							<th scope="col">CANTIDAD</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (LineaDeRepuesto ldr : misLineas) {
						%>
						<tr>
							<td><%=ldr.getRepuesto().getCodigo()%></td>
							<td><%=ldr.getRepuesto().getDescripcion()%></td>
							<td><%=ldr.getCantidad()%></td>
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