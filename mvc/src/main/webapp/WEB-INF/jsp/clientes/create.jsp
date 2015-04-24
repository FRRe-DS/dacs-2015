<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<title>Ejemplo Spring MVC :: Crear Cliente</title>
  	<style>
    	.error {
    		color: red;
    	}
  	</style> 
    </head>
  <body>
    <h2>Datos del Cliente</h2>
	<table>
		<form:form commandName="cliente" method="post">
		<tbody>
		<tr>
			<td>Nombre:</td>
			<td><form:input title="Nombre" path="nombre"/></td>
			<td><form:errors path="nombre" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Apellido:</td>
			<td><form:input title="Apellido" path="apellido"/></td>
			<td><form:errors path="apellido" cssClass="error"/></td>
		</tr>
		<tr>
			<td>DNI:</td>
			<td><form:input title="DNI" path="dni"/></td>
			<td><form:errors path="dni" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Telefono:</td>
			<td><form:input title="Teléfono" path="telefono"/></td>
			<td><form:errors path="telefono" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Domicilio:</td>
			<td><form:input title="Domicilio" path="domicilio"/></td>
			<td><form:errors path="domicilio" cssClass="error"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Enviar Datos"></td>
			<td></td>
		</tr>
		</tbody>
		</form:form>
	</table>		
  </body>
</html>