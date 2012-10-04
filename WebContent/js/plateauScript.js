$(function() {
	$(".pjoueur1>div").draggable({ revert : 'invalid' });
	$(".pjoueur2>div").draggable({ revert : 'invalid' });
	$(".pjoueur3>div").draggable({ revert : 'invalid' });
	$(".pjoueur4>div").draggable({ revert : 'invalid' });
	$(".cartes>section").droppable();
});
