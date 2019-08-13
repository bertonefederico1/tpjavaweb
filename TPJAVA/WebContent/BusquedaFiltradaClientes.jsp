<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.sql.*"%>
<%@page import="datos.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion de usuarios</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>ADMINISTRACION DE CLIENTES</b></label></div>
<div class= "container buscar">
	<button type="button" class="btn btn-success">+ Nuevo</button>
</div>
<body>
<%
	String nombuscar = request.getParameter("txtbuscar");
	PreparedStatement pstmt = null;
	ResultSet rs= null;
	String query = "SELECT * FROM clientes WHERE nombre_y_apellido LIKE ?";
	if (nombuscar != null){
		pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setString(1, "%"+nombuscar+"%");
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
            <th scope="col">DNI</th>
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
		      	<td><input class="form-check-input" type="radio" name="seleccionCliente" id="exampleRadios1" value="<%=rs.getString("dni")%>" checked></td>
		        <td><%=rs.getString("dni")%></td>
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