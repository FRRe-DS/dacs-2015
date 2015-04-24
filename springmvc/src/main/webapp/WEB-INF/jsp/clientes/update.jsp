<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
  	<title>Ejemplo Spring MVC :: Modificar Cliente</title>
  	<style>
    	.error {
    		color: red;
    	}
  	</style> 
    </head>
  <body>
    <h2>Editar Datos del Cliente</h2>
	<table>
		<form:form commandName="cliente" method="put">
		<tbody>
		<tr>
			<td>Id:</td>
			<td>${cliente.id}</td>
			<td></td>
		</tr>
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