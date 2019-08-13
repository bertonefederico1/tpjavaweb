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
	String matri_buscar = request.getParameter("txtbuscar");
	ResultSet rs= null;
 	PreparedStatement pstmt= null;
 	String query= "SELECT matricula, nombre_y_apellido, direccion, telefono, mail FROM mecanicos WHERE matricula = ?";
	if (matri_buscar != null){
		pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setString(1, matri_buscar);
		rs= pstmt.executeQuery();
	 	}
%>
		
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
          	<th scope="col"></th>
            <th scope="col">MATRICULA</th>
            <th scope="col">NOMBRE Y APELLIDO</th>
            <th scope="col">DIRECCION</th>
            <th scope="col">TELEFONO</th>
            <th scope="col">MAIL</th>
            <th scope="col">ACCION</th>
          </tr>
        </thead>
        <tbody>
         <% while (rs.next()) {%>
		      <tr>
		      	<td><input class="form-check-input" type="radio" name="seleccionMecanico" id="exampleRadios1" value="<%=rs.getString("matricula")%>" checked></td>
		        <td><%=rs.getInt("matricula")%></td>
		        <td><%=rs.getString("nombre_y_apellido")%></td>
		        <td><%=rs.getString("direccion")%></td>
		        <td><%=rs.getString("telefono")%></td>
		        <td><%=rs.getString("mail")%></td>
		        <td><div><button type="button" class="btn btn-warning btn-sm">Modificar</button>
		        <button type="button" class="btn btn-danger btn-sm">Eliminar</button></div></td>
		      </tr>
		      <%}
					rs.close();
					pstmt.close();
					Conexion.getInstancia().releaseConn();
			  %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>