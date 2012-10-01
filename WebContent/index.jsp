<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="be.technobel.domain.entity.User"%>
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
	<%
	
	if(session.getAttribute("loggedUser") == null){
	%>
	<nav id="loginBar">
		<nav class="form">
			<form action="<%=request.getContextPath() %>/Login" method="post">
				<fieldset id="login">
					<legend>login</legend>
					<p><label>Username :</label><input type="text" name="username" value="" autofocus required/></p>
					<p><label>Password :</label><input type="password" name="password" value="" required /></p>
				</fieldset>
			</form>
		</nav>
		<ul class="login">
			<li><a href="<%=request.getContextPath() %>/register.jsp">Register</a></li>
		</ul>
	</nav>
	<%}
	else{
		User loggedUser = (User) session.getAttribute("loggedUser");
	%>
	<nav id="loginBar">
		<ul class="logged">
			<li>Bonjour <%=loggedUser.getUsername() %></li>
		</ul>
	</nav>
	<%}%>
	<nav id="javaForums">
		<ul class="topiclist">
			<li class="header">
				<dl class="icon">
					<dd class="dterm">
						<nav class="table-title"><h2>Java</h2></nav>
					</dd>
					<dd class="topics">Sujets</dd>
					<dd class="posts">Messages</dd>
				</dl>
			</li>
		</ul>
	</nav>
	<nav id="cForums">
		<ul class="topiclist">
			<li class="header">
				<dl class="icon">
					<dd class="dterm">
						<nav class="table-title"><h2>C++</h2></nav>
					</dd>
					<dd class="topics">Sujets</dd>
					<dd class="posts">Messages</dd>
				</dl>
			</li>
		</ul>
	</nav>
</body>
</html>