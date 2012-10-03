<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="be.technobel.domain.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
	<title>Register</title>
	
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>
    <script src="<%=request.getContextPath() %>/js/script.js"></script>
	
</head>
<body>
<% User loggedUser = (User)request.getSession().getAttribute("loggedUser"); %>
<div class="generale">
<header>
		<img src="<%=request.getContextPath() %>/images/hattari.png">
</header>		
		<div class="formregister">
			<form id ="annonce"  action="<%=request.getContextPath() %>/Register" method="post" >	
				
			<table class='inscription'>
			<tr><th>INSCRIPTION</th></tr>
			 
			<tr><td class='label'>Username :</td>
			<td><input type="text" name="username" value="<%=loggedUser!=null?loggedUser.getUsername():"" %>" <% if (loggedUser!=null){%>disabled<%} %> autofocus required></td></tr>

			<tr><td class='label'>Password :</td>
			<td><input type="password" id="password" name="password" value="<%=loggedUser!=null?loggedUser.getPassword():"" %>" required></td></tr>
			
			<tr><td class='label'>Verify Password : </td>
			<td><input type="password" name="checkPassword" value="<%=loggedUser!=null?loggedUser.getPassword():"" %>" required></td></tr>

			<tr><td class='label'>Firstname :</td>
			<td><input type="text" name="firstname" value="<%=loggedUser!=null?loggedUser.getFirstName():"" %>" size="10" required></td></tr>

			<tr><td class='label'>Lastname :</td>
			<td><input type="text" name="lastname" value="<%=loggedUser!=null?loggedUser.getLastName():"" %>" size="10" required></td></tr>
			
			<tr><td class='label'>E-mail :</td>
			<td><input type="text" name="email" value="<%=loggedUser!=null?loggedUser.getEmail():"" %>" size="10" required></td></tr>
			
 			<tr>
 				<td>Avatar :</td>
				<td class='label'>
					<input <% if (loggedUser != null && "/images/andre.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/andre.jpg" /> <img src="<%=request.getContextPath() %>/images/andre.jpg" alt="nom" />
					<input <% if (loggedUser != null && "/images/fred.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/fred.jpg" /> <img src="<%=request.getContextPath() %>/images/fred.jpg" alt="nom" />
					<input <% if (loggedUser != null && "/images/jess.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/jess.jpg" /> <img src="<%=request.getContextPath() %>/images/jess.jpg" alt="nom" />
					<input <% if (loggedUser != null && "/images/johna.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/johna.jpg" /> <img src="<%=request.getContextPath() %>/images/johna.jpg" alt="nom" />
					<input <% if (loggedUser != null && "/images/johnm.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/johnm.jpg" /> <img src="<%=request.getContextPath() %>/images/johnm.jpg" alt="nom" />
					<input <% if (loggedUser != null && "/images/xavier.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/xavier.jpg" /> <img src="<%=request.getContextPath() %>/images/xavier.jpg" alt="nom" />
					<input type="radio" name="image" value="/images/imgavabase.jpg" /> <img src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom" />
					<input type="radio" name="image" value="/images/imgavabase.jpg" /> <img src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom" />
					<input type="radio" name="image" value="/images/imgavabase.jpg" /> <img src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom" />
					<input type="radio"  name="image" value="/images/imgavabase.jpg" /> <img src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom" />
					<input <% if (loggedUser != null && "/images/imgavabase.jpg".equals(loggedUser.getAvatar())){%>checked<%} %> type="radio" name="image" value="/images/imgavabase.jpg" /> <img src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom" />
				</td>			 	
			</tr>
			<tr>
				<td class='label' ><input class="css3button"type="submit" value="Send" /></td>
			</tr> 
			<% if (loggedUser!=null) {%>
			<tr>
				<td class='label' ><input class="css3button"type="button" value="Return" ONCLICK="history.go(-1)" /></td>
			</tr> 
			<%} %>
			</table>
			</form>
		</div>
</div>
</body>
</html>
