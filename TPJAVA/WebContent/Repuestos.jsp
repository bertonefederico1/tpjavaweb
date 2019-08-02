<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*" %>
<%@page import="java.sql.*" %>
<%@page import="datos.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administraci�n de repuestos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
	<% 
    	Usuario u= (Usuario)session.getAttribute("usuario");
    	ArrayList<Repuesto> misRepuestos=(ArrayList<Repuesto>)session.getAttribute("repuestos");
	%>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>ADMINISTRACI�N DE REPUESTOS</b></label></div>
<div class= "container buscar">
	<button type="button" class="btn btn-success">+ Nuevo</button>
	<form class="form" action="BusquedaFiltradaRepuestos.jsp">
		<input type="text" class="form-control"name="txtbuscar">
		<input class="btn btn-secondary" type="submit" value="Buscar">
	</form>
</div>
<body>
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">C�DIGO</th>
            <th scope="col">DESCRIPCI�N</th>
            <th scope="col">PRECIO</th>
            <th scope="col">STOCK</th>
            <th scope="col">ACCI�N</th>
          </tr>
        </thead>
        <tbody>
         <% for (Repuesto r : misRepuestos) {%>
		      <tr>
		        <td><%=r.getCodigo()%></td>
		        <td><%=r.getDescripcion()%></td>
		        <td><%=r.getPrecio()%></td>
		        <td><%=r.getStock()%></td>
		        <td><div><button type="button" class="btn btn-warning btn-sm">Modificar</button>
		        <button type="button" class="btn btn-danger btn-sm">Eliminar</button></div></td>
		      </tr>
		      <%} 
		      %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>