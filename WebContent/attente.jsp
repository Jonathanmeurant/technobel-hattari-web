<!doctype html>

<%@page import="be.technobel.domain.entity.User"%>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styleattente.css">
</head>

<% User loggedUser = (User)request.getSession().getAttribute("loggedUser");%>
<% User  otherLoggedUser2 = (User)request.getAttribute("otherLoggedUser2"); %>
<% User  otherLoggedUser3 = (User)request.getAttribute("otherLoggedUser3"); %>
<% User  otherLoggedUser4 = (User)request.getAttribute("otherLoggedUser4"); %>

<body>
<div class="general">
	<section class="attente">
		<div class="attente1">
		<img id="joueur1" src="<%=loggedUser!=null?request.getContextPath()+loggedUser.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur1"><%=loggedUser!=null?loggedUser.getUsername():"Player 1" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<div class="attente2">
		<img id="joueur2" src="<%=otherLoggedUser2!=null?request.getContextPath()+otherLoggedUser2.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur2"><%=otherLoggedUser2!=null?otherLoggedUser2.getUsername():"Player 2" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<div class="attente3">
		<img id="joueur3" src="<%=otherLoggedUser3!=null?request.getContextPath()+otherLoggedUser3.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur3"><%=otherLoggedUser3!=null?otherLoggedUser3.getUsername():"Player 3" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<div class="attente4">
		<img id="joueur4" src="<%=otherLoggedUser4!=null?request.getContextPath()+otherLoggedUser4.getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur2"><%=otherLoggedUser4!=null?otherLoggedUser4.getUsername():"Player 4" %></dd>
				</dl>
			</li>
		</ul>
		</div>
	</section>


</div>
</body>
</html>