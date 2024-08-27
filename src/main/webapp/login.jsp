<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <script>
        function validateForm() {
        	
            var username = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;
            
            if (username == "" || password == "") {
                alert("Username and password must be filled out");
                return false;
                
            } else if (username.length < 5 || username.length > 15) {
                alert("Please enter username with minimum 5 and maximum 15 characters");
                return false;
                
            } else if (!(/^[a-z0-9]+$/i.test(username))) {
                alert("Please enter only letters and numbers");
                return false;
                
            } else if (/^\d/.test(username)) {
                alert("Do not start username with digit");
                return false;
                
            } else {
            	return passwordValidation(password);
            }
            
            
           
        }
        
        function passwordValidation(password) {
        	
            const specialCharacterSet = "!@#$%^&*()-_=+";
            let hasSpecialChar = false;
 
            for (const char of specialCharacterSet) {
                if (password.includes(char)) {
                    hasSpecialChar = true;
                    break;
                }
            }
 
            if (password.length < 7) {
                alert("Enter at least 7 digit password");
                return false;
            } else if (password === password.toLowerCase()) {
                alert("Enter at least one uppercase letter");
                return false;
            } else if (password === password.toUpperCase()) {
                alert("Enter at least one lowercase letter");
                return false;
            } else if (!/\d/.test(password)) {
                alert("Enter at least one digit in your password");
                return false;
            } else if (!hasSpecialChar) {
                alert("Your password must contain one special character");
                return false;
            } else {
            	submitForm();
            	return true;
            }
        }
        
        function submitForm() {
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
 
            document.loginForm.action = "LoginController?action=login";
            document.loginForm.method = "post";
            document.loginForm.submit();
            
            
            
        }
    	
        
    </script>
</head>

<body>
<h2>Login To Your Account</h2>
 
<form name="loginForm" onSubmit="return validateForm()">
    <label for="username">User name:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="Login">
</form>
 
</body>
</html>
