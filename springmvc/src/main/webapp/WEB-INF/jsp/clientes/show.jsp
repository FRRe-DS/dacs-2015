<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
  	<title>Sistema de Turismo :: Clientes</title>
  </head>
  <body>
    <h1>Administrar Cliente</h1>
	<table>
		<tbody>
		<tr>
			<td>Nombre:</td><td>${cliente.nombre}</td>
		</tr>
		<tr>
			<td>Apellido:</td><td>${cliente.apellido}</td>
		</tr>
		<tr>
			<td>DNI:</td><td>${cliente.dni}</td>
		</tr>
		<tr>
			<td>Telefono:</td><td>${cliente.telefono}</td>
		</tr>
		<tr>
			<td>Domicilio:</td><td>${cliente.domicilio}</td>
		</tr>
		</tbody>
	</table>		
  </body>
  <p>
  <spring:url value="/" var="root_url" />
  <a href="${fn:escapeXml(root_url)}">Inicio</a>
</html>