<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.sql.*"%>
<%@page import="datos.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion de mecanicos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>ADMINISTRACION DE MECANICOS</b></label></div>
<div class= "container buscar">
	<button type="button" class="btn btn-success">+ Nuevo</button>
</div>
<body>
<%
	int matri_buscar = Integer.parseInt(request.getParameter("txtbuscar"));
	Statement stmt= null;
	ResultSet rs= null;
	if (matri_buscar != 0){
		stmt= Conexion.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("SELECT * FROM mecanicos WHERE matricula="+matri_buscar);
	 	}else{
			System.err.print("ERROR");
		} 
%>
		
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">MATRICULA</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">APELLIDO</th>
            <th scope="col">DIRECCION</th>
            <th scope="col">TELEFONO</th>
            <th scope="col">MAIL</th>
            <th scope="col">ACCION</th>
          </tr>
        </thead>
        <tbody>
         <% while (rs.next()) {%>
		      <tr>
		        <td><%=rs.getInt("matricula")%></td>
		        <td><%=rs.getString("nombre")%></td>
		        <td><%=rs.getString("apellido")%></td>
		        <td><%=rs.getString("direccion")%></td>
		        <td><%=rs.getString("telefono")%></td>
		        <td><%=rs.getString("mail")%></td>
		        <td><div><button type="button" class="btn btn-warning btn-sm">Modificar</button>
		        <button type="button" class="btn btn-danger btn-sm">Eliminar</button></div></td>
		      </tr>
		      <%}
					rs.close();
					stmt.close();
					Conexion.getInstancia().releaseConn();
			  %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>