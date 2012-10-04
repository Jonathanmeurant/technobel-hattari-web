$(function() {
	$(".pjoueur1>div").draggable({ revert : 'invalid' });
	$(".pjoueur2>div").draggable({ revert : 'invalid' });
	$(".pjoueur3>div").draggable({ revert : 'invalid' });
	$(".pjoueur4>div").draggable({ revert : 'invalid' });
	$(".cartes>section").droppable( function(){
		drop: idSuspect = $(this).attr("id").value;
	});
	$(".chipCarte").draggable({ revert : "invalid" });

	
	$(".cartes>img")
    .mouseover(function() { 
        $(this).attr("src", srcCarte);
    })
    .mouseout(function() {
        srcCarte = $(this).attr("src").value;
        var src = $(this).attr("src").replace("../images/carte.jpg");
        $(this).attr("src", src);
    });

});
	var srcCarte ;
	var idSuspect ;