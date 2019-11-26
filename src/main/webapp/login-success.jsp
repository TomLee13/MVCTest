<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "java.util.*" %>
<%@page import = "com.tom.model.Employee" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Logged in - Display the table</title>
	<style>
		h1 {
			text-align: center;
		}
		table, th, td {
			border: 1px solid black;
		}
		td {
			text-align: center;
		}
		p {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Employee Table</h1>
	<table style = "width : 100%">
		<tr>
			<th>Employee No.</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<% List<Employee> employees = (List) request.getAttribute("employees"); %>
		<% for (Employee e : employees) { %>
		<tr>
			<td><%= e.getEmpId() %></td>
			<td><%= e.getEmpName() %></td>
			<td><%= e.getEmpSal() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>