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
	email: " L'eMail entr� est invalide ! ",
	equalTo: " Ce champ doit avoir la m�me valeur que le pr�c�dent ! "	
});