<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Crear Cliente</title>
	</head>
	<body>
		<s:form action="create-cliente" >
			<s:textfield name="nombre" label="Nombre: " />
			<s:textfield name="apellido" label="Apellido" />
			<s:textfield name="dni" label="DNI: " />
			<s:textfield name="telefono" label="Teféfono: " />
			
			<s:submit />
		</s:form>
	</body>
</html>