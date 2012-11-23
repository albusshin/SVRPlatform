<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<font size='22'>"${message}"</font>	
	<form name="form1" action="/SVRPlatform/login" method="post">
	User name:<input type="text" name="username"/><br/>
	User name:<input type="password" name="password"/><br/>
	<input type="submit" name="method" value="sub"/>
	</form>
</body>
</html>