<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion de usuarios</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>ADMINISTRACION DE CLIENTES</b></label></div>
<div class= "container buscar">
	<button type="button" onclick = "location='AgregarCliente.jsp'" class="btn btn-success">+ Nuevo</button>
</div>
<body>
<%
	ArrayList<Cliente> misClientes= (ArrayList<Cliente>)request.getSession().getAttribute("misClientes");
%>
		
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
            <th scope="col">ACCION</th>
          </tr>
        </thead>
        <tbody>
        
         <% for (Cliente cl : misClientes) {%>
		      <tr>
		      	<td>
                 <div class="radio">
                     <label><input type="radio" onclick=<% if (request.getSession().getAttribute("tipo") == "Ingreso") {%>"location='Ingreso.jsp?dni=<%=cl.getDni()%>&nombre_y_apellido=<%=cl.getNombre_y_apellido()%>'"<%}%><%else {%>"location='NuevaReparacion.jsp?dni=<%=cl.getDni()%>&nombre_y_apellido=<%=cl.getNombre_y_apellido()%>'"<%}%>  id='express' name="optradio"></label>
                </div>
             </td>
		        <td><%=cl.getDni()%></td>
		        <td><%=cl.getNombre_y_apellido()%></td>
		        <td><%=cl.getDireccion()%></td>
		        <td><%=cl.getTelefono()%></td>
		        <td><%=cl.getMail()%></td>
		        <td><div>
		        <a href="EditarCliente.jsp?dni=<%=cl.getDni()%>&nombre_y_apellido=<%=cl.getNombre_y_apellido()%>&direccion=<%=cl.getDireccion()%>&telefono=<%=cl.getTelefono()%>&mail=<%=cl.getMail()%>" class="btn btn-warning btn-sm">Modificar</a>
				<a href="EliminarCliente?dni=<%=cl.getDni()%>" class="btn btn-danger btn-sm">Eliminar</a>
		        </div></td>
		      </tr>
		      <%}%>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>