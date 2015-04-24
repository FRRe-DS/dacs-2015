<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
 <head>
  	<title>Ejemplo Spring MVC :: Listado de Clientes</title>
  </head>
  <body>
  	<h2>Listado de Clientes</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Apellido</th>
				<th>Nombre</th>
				<th>Domicilio</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="cliente" items="${clientes}">
		<tr>
			<td>${cliente.id}</td>
			<td>${cliente.apellido}</td>
			<td>${cliente.nombre}</td>
			<td>${cliente.domicilio}</td>
			<td>
            	<spring:url value="/clientes/${cliente.id}?form" var="edit_cliente_form_url" />
            	<spring:url value="/clientes/${cliente.id}?del" var="del_cliente_form_url" />
				<a href="${fn:escapeXml(edit_cliente_form_url)}">Editar</a>|
            	<a href="${fn:escapeXml(del_cliente_form_url)}">Borrar</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>		
  </body>
</html>