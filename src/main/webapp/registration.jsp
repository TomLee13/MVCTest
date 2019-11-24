<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
</head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register A New User</title>
</head>
<body>
<h2 style = "color:blue">
	Enter the following information
</h2>

<form action = "RegisterServlet" method = "post">
	First Name : <input type = "text" name = "fn"><br>
	Last Name : <input type = "text" name = "ln"><br>
	User Name : <input type = "text" name = "un"><br>
	Password : <input type = "password" name = "pwd"><br>
	Confirm Password : <input type = "password" name = "cpwd"><br>
	<input type = "submit" name = "action" value = "Register">
</form>
</body>
</html>