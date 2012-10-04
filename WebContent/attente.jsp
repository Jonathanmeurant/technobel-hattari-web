<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="refresh" content="5;url=http://10.10.6.50:8080/TechnobelHattariWeb/gameaction?gameAction=<%=(String)request.getAttribute("gameAction")%>">
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
		<c:set var="testvar" value="${fn:length(gameloop.connectedUsers)}" />
		
		<c:if test="${testvar>1}">
		<div class="attente2">
		<c:url value="${gameloop.connectedUsers.get(1).avatar}"  var="urlimageavatarj2"/>
		<img id="joueur2" src="${urlimageavatarj2}" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur2">${gameloop.connectedUsers.get(1).username}</dd>
				</dl>
			</li>
		</ul>
		</div>
		</c:if>
		
		<c:if test="${testvar>2}">
		<div class="attente3">
		<c:url value="${gameloop.connectedUsers.get(2).avatar}"  var="urlimageavatarj3"/>
		<img id="joueur3" src="${urlimageavatarj3}" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur3">${gameloop.connectedUsers.get(2).username}</dd>
				</dl>
			</li>
		</ul>
		</div>
		</c:if>
		
		<c:if test="${testvar>3}">
		<div class="attente4">
		<c:url value="${gameloop.connectedUsers.get(3).avatar}"  var="urlimageavatarj4"/>
		<img id="joueur4" src="${urlimageavatarj4}" alt="nom"><br/>
		<ul class="joueur">
			<li class="icon">
				<dl>
					<dd class="joueur4">${gameloop.connectedUsers.get(3).username}</dd>
				</dl>
			</li>
		</ul>
		</div>
		</c:if>
		
		
	
		
	
	
	</section>
	


</div>
</body>
</html>
