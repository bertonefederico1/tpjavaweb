<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de mecánicos</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>ADMINISTRACIÓN DE MECÁNICOS</b></label></div>
<div class= "container buscar">
	<button type="button" onclick = "location='AgregarMecanico.jsp'" class="btn btn-success">+ Nuevo</button>
</div>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<%
	ArrayList<Mecanico> misMecanicos= (ArrayList<Mecanico>)request.getSession().getAttribute("misMecanicos");
%>
		
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">MATRÍCULA</th>
            <th scope="col">NOMBRE Y APELLIDO</th>
            <th scope="col">DIRECCIÓN</th>
            <th scope="col">TELÉFONO</th>
            <th scope="col">MAIL</th>
            <th scope="col">ACCIÓN</th>
          </tr>
        </thead>
        <tbody>
         <% for (Mecanico me : misMecanicos)  {%>
		      <tr>
		        <td><%=me.getMatricula()%></td>
		        <td><%=me.getNombre_y_apellido()%></td>
		        <td><%=me.getDireccion()%></td>
		        <td><%=me.getTelefono()%></td>
		        <td><%=me.getMail()%></td>
		        <td><div>
		        <a href="EditarMecanico.jsp?matricula=<%=me.getMatricula()%>&nombre_y_apellido=<%=me.getNombre_y_apellido()%>&direccion=<%=me.getDireccion()%>&telefono=<%=me.getTelefono()%>&mail=<%=me.getMail()%>" class="btn btn-warning btn-sm">Modificar</a>
				<a href="EliminarMecanico?matricula=<%=me.getMatricula()%>" class="btn btn-danger btn-sm">Eliminar</a>
		        </div></td>
		      </tr>
		      <%}%>
        </tbody>
      </table>
      <a href="Mecanicos.jsp"><< Volver</a>
    </div>
  </div>
</div>
</body>
</html>