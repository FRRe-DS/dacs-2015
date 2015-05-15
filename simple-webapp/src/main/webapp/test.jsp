<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Desarrollo de Aplicaciones Cliente-Servidor</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Campo</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
<%	
	for(String key: request.getParameterMap().keySet()) {
		String value = request.getParameter(key);
%>
			<tr>
				<td><%=key%></td>
				<td><%=value%></td>
			</tr>
<%
	}
%>
		</tbody>
	</table>
</body>
</html>