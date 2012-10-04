<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styleattente.css">
</head>



<body>
<h1>test </h1>
<div class="general">
	<section class="attente">
		<div class="attente1">
		 <c:url value="${gameloop.connectedUsers.get(0).avatar}"  var="urlimageavatarj1"/>
		<img id="joueur1" src="${urlimageavatarj1}" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur1">${gameloop.connectedUsers.get(0).username}</dd>
				</dl>
			</li>
		</ul>
		</div>
		
		<h2>${fn:length(gameloop.connectedUsers)}</h2>
		<c:if test="fn:length(gameloop.connectedUsers)>1}">
		<div class="attente2">
		 <c:url value="${gameloop.connectedUsers.get(1).avatar}"  var="urlimageavatarj2"/>
		<img id="joueur1" src="${urlimageavatarj2}" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur1">${gameloop.connectedUsers.get(1).username}</dd>
				</dl>
			</li>
		</ul>
		</div>
		</c:if>
	
		
	
	
	</section>
	


</div>
</body>
</html>
