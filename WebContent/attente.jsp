<!doctype html>

<%@page import="be.technobel.domain.entity.User"%>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styleattente.css">
</head>

<% User loggedUser = (User)request.getSession().getAttribute("loggedUser");%>
<% User  otherLoggedUser1 = (User)request.getAttribute("otherLoggedUser1"); %>
<% User  otherLoggedUser2 = (User)request.getAttribute("otherLoggedUser2"); %>
<% User  otherLoggedUser3 = (User)request.getAttribute("otherLoggedUser3"); %>

<body>
<div class="general">
	<section class="attente">
		<div class="attente1">
		<img id="joueur1" src="<%=loggedUser!=null?request.getContextPath()+loggedUser.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		</div>
		<div class="attente2">
		<img id="joueur2" src="<%=otherLoggedUser1!=null?request.getContextPath()+otherLoggedUser1.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		</div>
		<div class="attente3">
		<img id="joueur3" src="<%=otherLoggedUser2!=null?request.getContextPath()+otherLoggedUser2.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		</div>
		<div class="attente4">
		<img id="joueur4" src="<%=otherLoggedUser3!=null?request.getContextPath()+otherLoggedUser3.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		</div>
	</section>


</div>
</body>
</html>