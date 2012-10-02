<%@page import="be.technobel.domain.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
  
  <script src="<%=request.getContextPath() %>/js/script.js"></script>
  <script type="text/javascript"><!--//--><![CDATA[//><!--
sfHover = function() {
   var sfEls = document.getElementById("nav").getElementsByTagName("li");
   for (var i=0; i<sfEls.length; i++) {
      sfEls[i].onmouseover=function() {
         this.className+=" sfhover";
      }
      sfEls[i].onmouseout=function() {
      this.className=this.className.replace(new RegExp(" sfhover\b"), "");
      }
   }
}
if (window.attachEvent) window.attachEvent("onload", sfHover);
//--><!]]></script>

</head>
<body>
<% User loggedUser = (User)request.getSession().getAttribute("loggedUser"); %>
 <div class="generale">
	
		<header>
		<img src="<%=request.getContextPath() %>/images/hattari.png">
</header>
		
		
			<table class='topmenu'>
	<TR>
		<TD><a href="accueil.jsp">Accueil</a></TD>
		<TD><a href="register.jsp">Mon compte</a></TD>
	<TD><a href="score.jsp">Score</a></TD>
	<TD><a href="index.jsp?">Déconection</a></TD>
		
	<td><ul id="nav">
      <li><a href="#">jouer</a>
         <ul>
            <li><a href="#nogo">duel</a></li>
            <li><a href="#nogo">3 joueurs</a></li>
            <li><a href="#nogo">4 joueurs</a></li>
         </ul>
      </li>
      <li>Bonjour <%=loggedUser.getUsername() %></li>
   </ul></td></TR>
</table>	

   
</div>	
		
		

</body>
</html>