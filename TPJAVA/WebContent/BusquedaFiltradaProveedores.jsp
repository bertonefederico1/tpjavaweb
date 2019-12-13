<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de proveedores</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<div id=titulo><label><b>ADMINISTRACIÓN DE PROVEEDORES</b></label></div>
<div class= "container buscar">
	<button type="button" onclick = "location='AgregarProveedor.jsp'" class="btn btn-success">+ Nuevo</button>
</div>
<body>
	<jsp:include page="ControlarUsuario.jsp"></jsp:include>
<%
	ArrayList<Proveedor> misProveedores = (ArrayList<Proveedor>)request.getSession().getAttribute("misProveedores");
%>
		
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">CUIT</th>
            <th scope="col">RAZÓN SOCIAL</th>
            <th scope="col">DIRECCIÓN</th>
            <th scope="col">TELÉFONO</th>
            <th scope="col">MAIL</th>
            <th scope="col">ACCIÓN</th>
          </tr>
        </thead>
        <tbody>
        
         <% for (Proveedor prov : misProveedores) {%>
		      <tr>
		        <td><%=prov.getCuit()%></td>
		        <td><%=prov.getRazonSocial()%></td>
		        <td><%=prov.getDireccion()%></td>
		        <td><%if (prov.getTelefono() != null) {%><%=prov.getTelefono()%><%}%></td>
		        <td><%if (prov.getMail() != null) {%><%=prov.getMail()%><%}%></td>
		        <td><div>
		        <a href="EditarProveedor.jsp?cuit=<%=prov.getCuit()%>&razon_social=<%=prov.getRazonSocial()%>&direccion=<%=prov.getDireccion()%>&telefono=<%=prov.getTelefono()%>&mail=<%=prov.getMail()%>" class="btn btn-warning btn-sm">Modificar</a>
				<a href="ConfirmarEliminarProveedor.jsp?cuit=<%=prov.getCuit()%>&razon_social=<%=prov.getRazonSocial()%>" class="btn btn-danger btn-sm">Eliminar</a>
		        </div></td>
		      </tr>
		      <%}%>
        </tbody>
      </table>
      <a href="Proveedores.jsp"><< Volver</a>
    </div>
  </div>
</div>
</body>
</html>