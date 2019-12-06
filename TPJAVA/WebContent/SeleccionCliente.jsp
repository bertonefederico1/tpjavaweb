<%@page import="logica.ControladorLineaDeRepuesto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="datos.*"%>
<%@page import="logica.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de clientes</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	DatosCliente dp = new DatosCliente();
	ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
	ArrayList<Cliente> misClientes = dp.traerClientes();
	if(request.getParameter("tipo").equalsIgnoreCase("ingreso")){
		request.getSession().setAttribute("tipo", "Ingreso");
	}else if (request.getParameter("tipo").equalsIgnoreCase("reparacion")){
		request.getSession().setAttribute("tipo", "Reparacion");
 	} else if (request.getParameter("tipo").equalsIgnoreCase("factura")){
 		request.getSession().setAttribute("tipo","Factura");
 		request.getSession().removeAttribute("repuestosFactura");
 		request.getSession().removeAttribute("manoDeObra");
 		request.getSession().setAttribute("repuestosFactura",cldr.inicializarLineas());
 		request.getSession().setAttribute("manoDeObra", 0.0);
 		request.getSession().setAttribute("precio_total", 0);
 	} else if (request.getParameter("tipo").equalsIgnoreCase("turno")) {
 		request.getSession().setAttribute("tipo", "Turno");
 	}
	request.getSession().removeAttribute("reparacion_seleccionada");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css" />
</head>
<div id=titulo>
	<label><b>ADMINISTRACION DE CLIENTES</b></label>
</div>
<div class="container buscar">
	<form class="form" method="GET" action="ClienteFiltro">
		<input type="text" class="form-control" name="txtbuscar" placeholder="Nombre y Apellido"></input>
		<input class="btn btn-secondary" type="submit" value="Buscar"></input>
	</form>
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
							<th scope="col">DNI</th>
							<th scope="col">NOMBRE Y APELLIDO</th>
							<th scope="col">DIRECCION</th>
							<th scope="col">TELEFONO</th>
							<th scope="col">MAIL</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Cliente cl : misClientes) {
						%>
						<tr>
							<td>
								<div class="radio">
 									<label><input type="radio" onclick=<% if (request.getParameter("tipo").equalsIgnoreCase("ingreso")) {%>"location='Ingreso.jsp?dni=<%=cl.getDni()%>'"<%} else if (request.getParameter("tipo").equalsIgnoreCase("reparacion")) {%>"location='NuevaReparacion.jsp?dni=<%=cl.getDni()%>'"<%} else if(request.getParameter("tipo").equalsIgnoreCase("factura")) {%>"location='Facturar.jsp?dni=<%=cl.getDni()%>&nombre=<%=cl.getNombre_y_apellido()%>'"<%} else if (request.getParameter("tipo").equalsIgnoreCase("turno")) {%>"location='NuevoTurno.jsp?dni=<%=cl.getDni()%>'"<%}%> 
 									id='express' name="optradio"></label>
								</div>
							</td>
							<td><%=cl.getDni()%></td>
							<td><%=cl.getNombre_y_apellido()%></td>
							<td><%=cl.getDireccion()%></td>
							<td><%=cl.getTelefono()%></td>
							<td><%=cl.getMail()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<a href=<%if (request.getParameter("tipo").equalsIgnoreCase("ingreso")) {%>"Ingreso.jsp"<%} else if (request.getParameter("tipo").equalsIgnoreCase("reparacion")) {%>"NuevaReparacion.jsp"<%} else if (request.getParameter("tipo").equalsIgnoreCase("factura")) {%>"Facturar.jsp"<%} else if (request.getParameter("tipo").equalsIgnoreCase("turno")) {%>"NuevoTurno.jsp"<%}%>><< Volver</a>
			</div>
		</div>
	</div>
</body>
</html>
