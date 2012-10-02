<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
	<title>Register</title>
	
    <script src="stylesheet" href="<%=request.getContextPath() %>/js/jquery-1.5.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>
    <script src="<%=request.getContextPath() %>/js/script.js"></script>
	
</head>
<body>
<div class="generale">
<header>
		<img src="./hattari.png">
</header>		
		<div class="formregister">
			<form id ="annonce"  action="<%=request.getContextPath() %>/Register" method="post" >	
				
			<TABLE class='inscription'>
			<tr><th>INSCRIPTION</th></tr>
			 
			<TR><TD class='label' for="name">Username :<TD>
			<input type="text" name="username" value="" size="10" autofocus required></TD></TR>

			<TR><TD class='label' for="password">Password :<TD>
			<input type="password" name="password" value="" required></TD></TR>
			
			<TR><TD class='label' for="checkPassword" >Verify Password : <TD>
			<input type="password" name="checkPassword" value="" required></TD></TR>

			<TR><TD class='label' for="firstname">Firstname :<TD>
			<input type="text" name="firstname" size="10" required></TD></TR>

			<TR><TD class='label' for="lastname">Lastname :<TD>
			<input type="text" name="lastname" size="10" required></TD></TR>
			
			<TR><TD class='label' for="email">E-mail :<TD>
			<input type="text" name="email" size="10" required></TD></TR>

			<TR><td>Avatar :</td>
			<TD class='label'><input type="radio" name="imageava" value="nompj0"> <img src="./andre.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj1"> <img src="./images/fred.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj2"> <img src="./images/jess.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj3"> <img src="./images/johna.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj4"> <img src="./images/johnm.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj5"> <img src="./images/xavier.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj6"> <img src="./images/imgavabase.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj7"> <img src="./images/imgavabase.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj8"> <img src="./images/imgavabase.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj9"> <img src="./images/imgavabase.jpg" alt="nom">
			<input type="radio" name="imageava" value="nompj10"> <img src="./images/imgavabase.jpg" alt="nom">
		
			  
			<TR><TD class='label' ><input class="css3button"type="submit" value="Send"></TD></TR> 

			</table>
			</form>
		<div>
</div>
</body>
</html>
