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