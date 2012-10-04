<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		<c:if test="${false}">
		${gameloop.connectedUsers.get(1).username}
		</c:if>
		
	
	
	</section>
	


</div>
</body>
</html>
