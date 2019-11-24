<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<h2 style = "color:blue">
	Login
</h2>

<form action = "LoginServlet" method = "post">
	User Name : <input type = "text" name = "un"><br>
	Password : <input type = "password" name = "pwd"><br>
	<input type = "submit" name = "action" value = "Login">	
</form>
<form action = "registration.jsp" method = "post">
	<input type = "submit" name = "action" value = "Register">
</form>
</body>
</html>
