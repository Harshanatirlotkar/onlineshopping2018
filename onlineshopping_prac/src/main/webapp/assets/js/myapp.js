$(function(){
//	solving active menu problem

	switch(menu){
	case 'About Us' :
		$('#about').addClass('Active');
		break;
	case 'Contact Us' :		
		$('#contact').addClass('Active');
		break;
	default:
		$('#home').addClass('Active');
	break;
	}




});