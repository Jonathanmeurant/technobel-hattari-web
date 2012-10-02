$(function(){
	validate();
 });
  
function validate(){
	 $("#annonce").validate({
		rules: {
			nom: {
				required: true,
			},
			passe: {
				required: true,
			},
			passeverif: {
				required: true,
				equalTo: "#passe"
			},
			mail: {
				required: true,
				 email: true
			}
			
			
		}
	});
}