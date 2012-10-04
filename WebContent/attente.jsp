<!doctype html>
<jsp:root>

<%@page import="be.technobel.domain.datamodel.ConnectedUser"%>
<%@page import="be.technobel.domain.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="be.technobel.domain.datamodel.GameLoop"%>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styleattente.css">
</head>
<% 
	GameLoop gameloop = (GameLoop) getServletContext().getAttribute("gameloop");
	
	List<ConnectedUser> users = gameloop.getConnectedUsers();
	
%>

<body>
<div class="general">
	<section class="attente">
		<div class="attente1">
		<img id="joueur1" src="<%=users.size()>0?request.getContextPath()+users.get(0).getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur1"><%=users.get(0)!=null?users.get(0).getUsername():"Player 1" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<div class="attente2">
		<img id="joueur2" src="<%=users.size()>1?request.getContextPath()+users.get(1).getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur2"><%=users.get(1)!=null?users.get(1).getUsername():"Player 2" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<div class="attente3">
		<img id="joueur3" src="<%=users.size()>2?request.getContextPath()+users.get(2).getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur3"><%=users.get(2)!=null?users.get(2).getUsername():"Player 3" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<div class="attente4">
		<img id="joueur4" src="<%=users.size()>3?request.getContextPath()+users.get(3).getAvatar():request.getContextPath()+"/images/imgavabase.jpg" %>" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur2"><%=users.get(3)!=null?users.get(3).getUsername():"Player 4" %></dd>
				</dl>
			</li>
		</ul>
		</div>
		<nav>
			<% if (gameloop.isPoolPlayerFull()){ %>
			<form method="get" action="plateau.jsp">
				<input type="button" value="Start Game" />
			</form>
			<%} %>
		</nav>
	</section>


</div>
</body>
</html>
</jsp:root>