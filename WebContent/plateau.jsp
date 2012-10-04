<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="be.technobel.domain.entity.User"%>

<html lang="fr">
<head>
  <meta charset="utf-8">
<!-- <meta http-equiv="refresh" content="5;url=<%=request.getContextPath()%>/plateau.jsp?gameAction=<%=(String)request.getAttribute("gameAction")%>">-->
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styleplateau.css">
  <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/jquery-ui-1.8.12.custom.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/plateauScript.js"></script>
</head>

<% User loggedUser = (User)request.getSession().getAttribute("loggedUser");%>
<% User  otherLoggedUser2 = (User)request.getAttribute("otherLoggedUser2"); %>
<% User  otherLoggedUser3 = (User)request.getAttribute("otherLoggedUser3"); %>
<% User  otherLoggedUser4 = (User)request.getAttribute("otherLoggedUser4"); %>
<body>
	
	 
<div class="total">
<div class="generale">


	<section class="joueursgauche"> 
		<div class="pj1">
		
			 <c:url value="${gameState.user.get(0).avatar}"  var="urlimageavatarj1"/>
			<img id="joueur1" src="${urlimageavatarj1}" alt="nom"><br/>
			<input type="submit" value="Jouer"/><br/><br/>
			 <c:url value="${gameState.user.get(0).clue.image}"  var="urlimagecluej1"/>
			<img id="cartejoueur1" src="${urlimagecluej1}" alt="carte du joueur"><br/>
			<ul class="joueur">
				<li class="icon">
					<dl>
						<dd class="joueur1">${gameState.user.get(1).username} </dd>
					</dl>
				</li>
			</ul>
		</div>
		
	
		<div class="pj2">
			<c:url value="${gameState.user.get(1).clue.image}"  var="urlimagecluej2"/>
			<img id="cartejoueur2" src="${urlimagecluej2}"><br/><br/>
			<!-- <input type="submit" value="Jouer"/> --><br/>
			
			<c:url value="${gameState.user.get(1).avatar}"  var="urlimageavatarj2"/>
			<img id="joueur2" src="${urlimageavatarj2}" alt="nom"><br/>
			<ul class="joueur">
				<li class="icon">
					<dl>
						<dd class="joueur2">${gameState.user.get(0).username}</dd>
					</dl>
				</li>
			</ul>
		</div>
	</section>
	
	<section class="plateau">
	<div class="plateau1">
		
		
		<div class="cartes">
		
		 <c:url value="${gameState.victim.image}"  var="urlimagevic"/>
		<img class="victime" id="victime" src="${urlimagevic}" alt="nom"/><br>
		
		 <c:forEach  items="${gameState.suspects}"  var="suspect">
		 	<c:url value="${suspect.image}"  var="urlimage"/>
			<img class="suspect" src="${urlimage}" alt="nom"/>
			<c:forEach  items="${suspect.lChips}"  var="chip">
				<c:url value="${chip.imageRecto}"  var="urlimagechipCarte"/>
		 		<img class="chipCarte" src="${urlimagechipCarte}" alt="nom"/>
			</c:forEach>
	 	 </c:forEach><br>
	 	<section id="dragSuspect1" class="droppable"></section>
		<section id="dragSuspect2" class="droppable"></section>
		<section id="dragSuspect3" class="droppable"></section>
		</div>
		
		<div class="pjoueur1">
		<c:forEach  items="${gameState.user.get(0).chips}"  var="chips">
		 <c:url value="${chips.imageRecto}"  var="urlimagechip"/>
		 	<div><img  class="pj1pion1"src="${urlimagechip}" alt="nom"/></div>
	 	 </c:forEach>
		</div>
		<div class="pjoueur2">
		<c:forEach  items="${gameState.user.get(1).chips}"  var="chips">
		 <c:url value="${chips.imageRecto}"  var="urlimagechip"/>
		 	<div><img class="pj2pion1" src="${urlimagechip}" alt="nom"/></div>
	 	 </c:forEach>
		</div>
		
		<div class="pjoueur3">
		<c:forEach  items="${gameState.user.get(2).chips}"  var="chips">
		 <c:url value="${chips.imageRecto}"  var="urlimagechip"/>
		 	<div><img class="pj3pion1" src="${urlimagechip}" alt="nom"/></div>
	 	</c:forEach>
		</div>
		<div class="pjoueur4">
		<c:forEach  items="${gameState.user.get(3).chips}"  var="chips">
		 <c:url value="${chips.imageRecto}"  var="urlimagechip"/>
		 	<div><img class="pj4pion1" src="${urlimagechip}" alt="nom"/></div>
	 	</c:forEach>
		</div>
	</div>
	</section>
	
	<section class="joueursdroite">
	
		<div class="pj3">
			<c:url value="${gameState.user.get(2).clue.image}"  var="urlimagecluej3"/>
			<img id="cartejoueur3" src="${urlimagecluej3}" alt="carte du joueur"><br/><br/>
			<!-- <input type="submit" value="Jouer"/> --><br/>
			
			<c:url value="${gameState.user.get(2).avatar}"  var="urlimageavatarj3"/>
			<img id="joueur3" src="${urlimageavatarj3}" alt="nom"><br/>
			<ul class="joueur">
				<li class="icon">
					<dl>
						<dd class="joueur3">${gameState.user.get(2).username} </dd>
					</dl>
				</li>
			</ul>
		</div>
		
		<div class="pj4">
			<c:url value="${gameState.user.get(3).avatar}"  var="urlimageavatarj4"/>
			<img id="joueur4" src="${urlimageavatarj4}" alt="nom"><br/>
			<!-- <input type="submit" value="Jouer"/> --><br/><br/>
			
			<c:url value="${gameState.user.get(3).clue.image}"  var="urlimagecluej4"/>
			<img id="cartejoueur4" src="${urlimagecluej4}" alt="carte du joueur"><br/>
			<ul class="joueur">
				<li class="icon">
					<dl>
						<dd class="joueur4">${gameState.user.get(3).username} </dd>
					</dl>
				</li>
			</ul>
		</div>
			
	</section>

</div>
</div>
</body>
</html>