$(function(){
//	solving active menu problem

	switch(menu){
	case 'About Us' :
		$('#about').addClass('Active');
		break;
	case 'Contact Us' :		
		$('#contact').addClass('Active');
		break;
	case 'All Products' :		
		$('#listProducts').addClass('Active');
		break;	
	default:
		$('#lisProducts').addClass('Active');
		$('#a_'+menu).addClass('Active');
	break;
	}




});