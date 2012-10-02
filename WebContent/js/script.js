$(function(){
	validate();
 });
  
function validate(){
	 $("#annonce").validate({
		rules: {
			username: {
				required: true,
			},
			password: {
				required: true,
			},
			checkPassword: {
				required: true,
				equalTo: "#password"
			},
			email: {
				required: true,
				 email: true
			}
			
			
		}
	});
}

jQuery.extend(Jquery.validator.messages, {
	required: " Ce champ est requis ! " ,
	email: " L'eMail entré est invalide ! ",
	equalTo: " Ce champ doit avoir la même valeur que le précédent ! "	
});