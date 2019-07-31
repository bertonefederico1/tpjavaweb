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
<body>
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">DNI</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">APELLIDO</th>
            <th scope="col">DIRECCION</th>
            <th scope="col">TELEFONO</th>
            <th scope="col">MAIL</th>
          </tr>
        </thead>
        <tbody>
         
         <%
        	Statement stmt = null;
 			ResultSet rs = null;
         	stmt= Conexion.getInstancia().getConn().createStatement();
         	rs = stmt.executeQuery("select * from clientes");
         	while (rs.next()){
         		Cliente cli = new Cliente();
         		cli.setDni(rs.getString("dni"));
         		cli.setNombre(rs.getString("nombre"));
         		cli.setApellido(rs.getString("apellido"));
         		cli.setDireccion(rs.getString("direccion"));
         		cli.setMail(rs.getString("mail"));
         		cli.setTelefono(rs.getString("telefono"));
         		//ArrayList<Persona> pers= new ArrayList<>();
         	}
         	
         %> 
          <tr>
            <td>
                 <div class="radio">
                     <label><input type="radio" id='regular' name="optradio"></label>
                 </div>
            </td>
            <td>BSDFSDF</td>
            <td>Cristina</td>
            <td>913</td>
            <td>2.846</td>
          </tr>
          
          
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>