<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.sql.*"%>
<%@page import="datos.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion de usuarios</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
<% 
    	Usuario u= (Usuario)session.getAttribute("usuario");
    	ArrayList<Cliente> misClientes=(ArrayList<Cliente>)session.getAttribute("clientes");
%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
          	<th scope="col"></th>
            <th scope="col">DNI</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">APELLIDO</th>
            <th scope="col">DIRECCION</th>
            <th scope="col">TELEFONO</th>
            <th scope="col">MAIL</th>
          </tr>
        </thead>
        <tbody>
         <% for (Cliente cl : misClientes) {%>
		      <tr>
		      	<td>
                 	<div class="radio">
                    	<label><input type="radio" id='regular' name="optradio"></label>
                	</div>
            	</td>
		        <td><%=cl.getDni()%></td>
		        <td><%=cl.getNombre()%></td>
		        <td><%=cl.getApellido()%></td>
		        <td><%=cl.getDireccion()%></td>
		        <td><%=cl.getTelefono()%></td>
		        <td><%=cl.getMail()%></td>
		      </tr>
		      <%} %>
        </tbody>
      </table>
      <div id= "botones">
        	<button type="button" class="btn btn-success">Nuevo</button>
        	<a class="btn btn-primary" href="#" role="button">Modificar</a>
        	<button type="button" class="btn btn-danger">Eliminar</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>