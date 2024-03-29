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
	<li>Bonjour <%=loggedUser.getUsername() %></li>
		<header>
		<img src="<%=request.getContextPath() %>/images/hattari.png">
</header>
		
		
			<table class='topmenu'>
	<TR>
		<TD><a href="accueil.jsp">Accueil</a></TD>
		<TD><a href="register.jsp">Mon compte</a></TD>
	<TD><a href="score.jsp">Score</a></TD>
	<TD><a href="<%=request.getContextPath() %>/Logout">Logout</a></TD>
		
	<td><ul id="nav">
      <li><a href="#">jouer</a>
         <ul>
            <li><a href="<%=request.getContextPath() %>/gameaction?gameAction=joinGame">4 joueurs</a></li>
         </ul>
      </li>
      
      
   </ul></td></TR>
</table>	
<section>
		<div class="corps">
			<h1>R&egrave;gles du jeu</h1>
			
			
			
			
			<p class="text">
			<a href="pdf/Hattari.pdf" target="_blank">R&egrave;gles compl&egrave;tes en pdf</a><br/>
			<b>Contexte :</b><br/>
				D&eacute;masquerez-vous le coupable ?

				Une &egrave;ne de crime, trois suspects, une victime, Mais qui est le coupable ? Chaque joueur re�oit un profil Suspect et 5 marqueurs d'accusation. Placez d'abord trois profils Suspect debout et un profil &eacute; (la victime). Le coupable se trouve parmi les trois suspects debout.<br/>
				Chaque joueur regarde le num&eacute;ro inscrit sur son profil Suspect et sur celui que lui remet son voisin. Les joueurs vont ensuite, chacun &agrave; leur tour, consulter deux profils du centre de la table et placer un marqueur d'accusation sous le coupable pr&eacute;sum&eacute;.
				Les trois profils sont r&eacute;v&eacute;l&eacute;s &agrave; la fin du tour. Le coupable est le suspect de plus forte valeur. Mais si le suspect numero 5 est r&eacute;v&eacute;l&eacute;, le coupable est le suspect de valeur la plus basse. Les marqueurs d'accusation plac&eacute;s sous un innocent retournent a leurs propri&eacute;taires face noire visible. Le dernier joueur ayant pos&eacute; un marqueur sous le mauvais Suspect r&eacute;cup&egrave;re tous les marqueurs de cette pile. La partie s'arr&ecirc;te quand un joueur a devant lui 8 marqueurs ou uniquement des marqueurs face noire.<br/>
				<br/>
				Un jeu tactique et subtil.<br/>
				Un design graphique alliant beaut&eacute; et sobri&eacute;t&eacute;.<br/>
				Bluff et d&eacute;duction n'ont jamais &eacute;t&eacute; aussi bons !<br/>
				<br/>
				<b>But du jeu :</b><br/>
				Trouver le bon meurtrier.<br/>
				<br/>
				<b>Contenu :</b><br/>
				7 profils Suspect num&eacute;rot&eacute;s de 2 &agrave; 8,<br/>
				1 Suspect sans num&eacute;ro,<br/>
				1 jeton 1er Joueur,<br/>
				1 jeton profil inconnu,<br/>
				1 jeton profil &eacute;chang&eacute;,<br/>
				20 marqueurs d'accusation de 4 couleurs (1 face color&eacute;e et 1 noire),<br/>
				Des livrets de r&egrave;gles en 3 langues.<br/>
			</p>
		</div>
	</section>
   
</div>	
		
		

</body>
</html>