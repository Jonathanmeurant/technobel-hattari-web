<!doctype html>

<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>HATTARI</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styleplateau.css">
</head>

<body>
<div class="generale">
	<section class="joueursgauche"> 
		<div class="pj1">
			<img id="joueur1" src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom"></br>
			<input type="submit" value="Jouer"/></br></br>
			<img id="cartejoueur1" src="<%=request.getContextPath() %>/images/carte.jpg" alt="carte du joueur"></br>
		</div>
		
	
		<div class="pj2">
			<img id="cartejoueur2" src="<%=request.getContextPath() %>/images/carte.jpg" alt="carte du joueur"></br></br>
			<input type="submit" value="Jouer"/></br>
			<img id="joueur2" src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom"></br>
			
		</div>
	</section>
	
	<section class="plateau">
	<div class="plateau1">
		<div class="pjoueur1">
		<img id="pj1pion1" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj1pion2" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/></br>
		<img id="pj1pion3" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj1pion4" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj1pion5" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		</div>
		<div class="pjoueur2">
		<img id="pj2pion1" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj2pion2" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/></br>
		<img id="pj2pion3" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj2pion4" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj2pion5" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		</div>
		<div class="cartes">
		<img id="victime" src="<%=request.getContextPath() %>/images/victime.jpg" alt="nom"/></br>
		<img id="suspect1" src="<%=request.getContextPath() %>/images/carte.jpg" alt="nom"/>
		<img id="suspect2" src="<%=request.getContextPath() %>/images/carte.jpg" alt="nom"/>
		<img id="suspect3" src="<%=request.getContextPath() %>/images/carte.jpg" alt="nom"/>
		</div>
		<div class="pjoueur3">
		<img id="pj3pion1" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj3pion2" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/></br>
		<img id="pj3pion3" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj3pion4" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj3pion5" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		</div>
		<div class="pjoueur4">
		<img id="pj4pion1" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj4pion2" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/></br>
		<img id="pj4pion3" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj4pion4" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		<img id="pj4pion5" src="<%=request.getContextPath() %>/images/pionbase.png" alt="nom"/>
		</div>
	</div>
	</section>
	
	<section class="joueursdroite">
		<div class="pj3">
			<img id="joueur3" src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom"></br>
			<input type="submit" value="Jouer"/></br></br>
			<img id="cartejoueur3" src="<%=request.getContextPath() %>/images/carte.jpg" alt="carte du joueur"></br>
		</div>
		
	
		<div class="pj4">
			<img id="cartejoueur4" src="<%=request.getContextPath() %>/images/carte.jpg" alt="carte du joueur"></br></br>
			<input type="submit" value="Jouer"/></br>
			<img id="joueur4" src="<%=request.getContextPath() %>/images/imgavabase.jpg" alt="nom"></br>
			
		</div>
	</section>

</div>
</body>
</html>




