<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="loginServlet" method="post">
		<label for="email">Email:</label> <input type="text" id="email"
			name="email" required><br>
		<br> <label for="password">Password:</label> <input
			type="password" id="password" name="password" required><br>
		<br> <input type="submit" value="Login">
	</form>
	<p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>