<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
	<title>MyForum</title>
</head>
<body>
	<h1>MyForum</h1>
	<nav id="loginBar">
		<ul class="login">
			<li><a href="<%=request.getContextPath() %>/register.jsp">Register</a></li>
			<li><a href="<%=request.getContextPath() %>/login.jsp">Login</a></li>
		</ul>
	</nav>
	<nav class="form">
		<form action="<%=request.getContextPath() %>/Register" method="post">
			<fieldset id="register">
				<legend>Login</legend>
				<p><label>Username :</label><input type="text" name="username" value="" autofocus required/></p>
				<p><label>Password :</label><input type="password" name="pwd" value="" required /></p>
				<p><label>Firstname :</label><input type="text" name="firstname" value="" required /></p>
				<p><label>Lastname :</label><input type="text" name="lastname" value="" required /></p>
				<p><label>E-mail :</label><input type="text" name="email" value="" required /></p>
				<p><input type="submit" value="Connect"/>
			</fieldset>
		</form>
	</nav>
</body>
</html>