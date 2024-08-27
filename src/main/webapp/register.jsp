<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<script>
	function registerForm() {
		var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;

        document.registrationForm.action = "LoginController?action=register";
        document.registrationForm.method = "post";
        document.registrationForm.submit();
	}
</script>
</head>
<body>
<h2>You are not registered on web site please register first</h2>
<form name="registrationForm" onSubmit="return registerForm()">
    <label for="username">User name:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="register">
</form>
</body>
</html>
