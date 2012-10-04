<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  	<title>HATTARI</title>
  	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
  	<script src="<%=request.getContextPath() %>/js/script.js"></script>
</head>
<body>
<% String error = (String)request.getAttribute("error"); %>
<div class="generale">
<header>
		<img src="<%=request.getContextPath() %>/images/hattari.png">
</header>
	
<nav>
	<nav class="form">
		<form action="<%=request.getContextPath() %>/Login" method="post">
			<fieldset id="login">
				<p><label>Username :</label><input type="text" name="username" autofocus required/>
				<label>Password :</label><input type="password" name="password" required />
				<input type="submit" value="Connect"/></p>
				<% if (error != null){ %> <p class="error">Error : <%=error%></p> <%} %>
				
			</fieldset>
			
		</form>
	</nav>
	<nav>
		<a class="register" href="register.jsp">Register</a></li>
	</nav>
</nav>
	<section>
		<div class="corps">
			<h1>R&egrave;gles du jeu</h1>
			
			
			
			
			<p class="text">
			<a href="Hattari.pdf" target="_blank">R&egrave;gles compl&egrave;tes en pdf</a><br/>
			<b>Contexte :</b><br/>
				D&eacute;masquerez-vous le coupable ?

				Une &egrave;ne de crime, trois suspects, une victime, Mais qui est le coupable ? Chaque joueur reçoit un profil Suspect et 5 marqueurs d'accusation. Placez d'abord trois profils Suspect debout et un profil &eacute; (la victime). Le coupable se trouve parmi les trois suspects debout.<br/>
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

