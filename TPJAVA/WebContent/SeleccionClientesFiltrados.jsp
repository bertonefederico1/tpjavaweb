<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de clientes</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
<%
	ArrayList<Cliente> misClientes= (ArrayList<Cliente>)request.getSession().getAttribute("misClientes");
%>
</head>
<div id=titulo><label><b>ADMINISTRACIÓN DE CLIENTES</b></label></div>
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
            <th scope="col">DIRECCIÓN</th>
            <th scope="col">TELÉFONO</th>
            <th scope="col">MAIL</th>
          </tr>
        </thead>
        <tbody>
         <% for (Cliente cl : misClientes) {%>
		      <tr>
		      	<td>
                 <div class="radio">
                     <label><input type="radio" onclick=<% if (request.getSession().getAttribute("tipo") == "Ingreso") {%>"location='Ingreso.jsp?dni=<%=cl.getDni()%>'"<%}%><%else if (request.getSession().getAttribute("tipo") == "Reparacion"){%>"location='NuevaReparacion.jsp?dni=<%=cl.getDni()%>'"<%}%><%else if (request.getSession().getAttribute("tipo") == "Factura"){%>"location='Facturar.jsp?dni=<%=cl.getDni()%>&nombre=<%=cl.getNombre_y_apellido()%>'"<%} else if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("turno")) {%>"location='NuevoTurno.jsp?dni=<%=cl.getDni()%>'"<%}%>  id='express' name="optradio"></label>
                </div>
             </td>
		        <td><%=cl.getDni()%></td>
		        <td><%=cl.getNombre_y_apellido()%></td>
		        <td><%=cl.getDireccion()%></td>
		       	<td><%if (cl.getTelefono() != null) {%><%=cl.getTelefono()%><%}%></td>
				<td><%if (cl.getMail() != null) {%><%=cl.getMail()%><%}%></td>
		      </tr>
		      <%}%>
        </tbody>
      </table>
      <a href=<% if (request.getSession().getAttribute("tipo") == "Ingreso") {%>"Ingreso.jsp"<%}%><%else if (request.getSession().getAttribute("tipo") == "Reparacion"){%>"NuevaReparacion.jsp"<%}%><%else if (request.getSession().getAttribute("tipo") == "Factura"){%>"Facturar.jsp"<%} else if (request.getSession().getAttribute("tipo").toString().equalsIgnoreCase("turno")) {%>"NuevoTurno.jsp"<%}%>><< Volver</a>
    </div>
  </div>
</div>
</body>
</html>