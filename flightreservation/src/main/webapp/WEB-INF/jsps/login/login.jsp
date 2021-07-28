<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<h2>Login Page</h2>
<form action="login" method="post">
<pre>
Username: <input type="text" name="email"/><br>
Password: <input type="password" name="password"/><br>
<input type="submit" value="login">
${msg}
</pre>
</form>
</body>
</html>