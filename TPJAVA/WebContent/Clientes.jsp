<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion de usuarios</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table class="table table-responsive">
     <thead>
         <tr>
             <th>Nombre y Apellido</th>
             <th>Dni</th>
             <th>Direccion</th>
             <th>Telefono</th>
             <th>Email</th>
         </tr>
     </thead>
     <tbody>
     <form>
         <tr>
             <td>
                 <div class="radio">
                     <label><input type="radio" id='regular' name="optradio">TIKI</label>
                 </div>
             </td>
             <td>
             <div class="radiotext">
                 <label for='regular'>Regular Shipping</label>
             </div>
             </td>
         </tr>
         <tr>
             <td>
                 <div class="radio">
                     <label><input type="radio" id='express' name="optradio">JNE</label>
                </div>
             </td>
             <td>
                 <div class="radiotext">
                     <label for='express'>Express Shipping</label>
                 </div>
             </td>
         </tr>
         </form>
         </tbody>
</table>
</body>
</html>