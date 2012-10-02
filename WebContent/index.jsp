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
<div class="generale">
<header>
		<img src=".images/hattari.png">
</header>
	
<nav>
	<nav class="form">
		<form action="<%=request.getContextPath() %>/Login" method="post">
			<fieldset id="login">
				<legend>Login</legend>
				<p><label>Username :</label><input type="text" name="username" autofocus required/></p>
				<p><label>Password :</label><input type="password" name="password" required /></p>
				<p><input type="submit" value="Connect"/>
			</fieldset>
		</form>
	</nav>
	<nav>
		<a href="register.jsp">Register</a></li>
	</nav>
</nav>
	<section>
		<div class="corps">
			<h1>Règles du jeu</h1>
			
			<p>
			<a href="reglehattari.pdf" target="_blank">Règles complètes en pdf</a><br/>
			<b>Contexte :</b><br/>
				Démasquerez-vous le coupable ?

				Une scène de crime, trois suspects, une victime… Mais qui est le coupable ? Chaque joueur reçoit un profil Suspect et 5 marqueurs d’accusation. Placez d’abord trois profils Suspect debout et un profil couché (la victime). Le coupable se trouve parmi les trois suspects debout.<br/>
				Chaque joueur regarde le numéro inscrit sur son profil Suspect et sur celui que lui remet son voisin. Les joueurs vont ensuite, chacun à leur tour, consulter deux profils du centre de la table et placer un marqueur d’accusation sous le coupable présumé.
				Les trois profils sont révélés à la fin du tour. Le coupable est le suspect de plus forte valeur. Mais si le suspect n°5 est révélé, le coupable est le suspect de valeur la plus basse. Les marqueurs d’accusation placés sous un innocent retournent à leurs propriétaires face noire visible. Le dernier joueur ayant posé un marqueur sous le mauvais Suspect récupère tous les marqueurs de cette pile. La partie s’arrête quand un joueur a devant lui 8 marqueurs ou uniquement des marqueurs face noire.<br/>
				<br/>
				Un jeu tactique et subtil.<br/>
				Un design graphique alliant beauté et sobriété.<br/>
				Bluff et déduction n’ont jamais été aussi bons !<br/>
				<br/>
				<b>But du jeu :</b><br/>
				Trouver le bon meurtrier.<br/>
				<br/>
				<b>Contenu :</b><br/>
				7 profils Suspect numérotés de 2 à 8,<br/>
				1 Suspect sans numéro,<br/>
				1 jeton 1er Joueur,<br/>
				1 jeton profil inconnu,<br/>
				1 jeton profil échangé,<br/>
				20 marqueurs d’accusation de 4 couleurs (1 face colorée et 1 noire),<br/>
				Des livrets de règles en 3 langues.<br/>
			</p>
		</div>
	</section>
</div>
</body>
</html>

