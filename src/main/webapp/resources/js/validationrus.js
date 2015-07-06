/**
 * Created by Philip Fursov on 29.03.2015.
 * version 1.0
 */

$(document).ready(function(){

	// Validate
	// http://bassistance.de/jquery-plugins/jquery-plugin-validation/
	// http://docs.jquery.com/Plugins/Validation/
	// http://docs.jquery.com/Plugins/Validation/validate#toptions

		$('#contact-form').validate({
	    rules: {
	    	nickName: {
	        minlength: 3,
	        required: true
	      },
	      login: {
	        required: true,
	        email: true
	      },
	      lastname: {
	      	minlength: 2,
	        required: true
	      },
	      telephone: {
	        minlength: 8,
	        required: true,
	        digits:true
	      },
	      password: {
	      minlength: 6,
	      required: true
	      },
	      j_username: {
		        required: true,
		        email: true
	      },
	      j_password: {
	      minlength: 6,
	      required: true  
	      },
	      confirmPassword: {
	      equalTo: "#password",
	      required: true 	  
	      }		  
},
messages:  {
	confirmPassword: {equalTo: 'Пароли не совпадают', required: 'Поле пустое'},
	nickName: {required: 'Поле пустое', minlength: 'Не мене 3 символов'},
	login: {required: 'Поле пустое', email: 'Некорректный email'},
	password: {minlength: 'Не менее 6 символов', required: 'Поле пустое'},
	j_username: {required: 'Поле пустое', email: 'Некорректный email'},
	j_password: {minlength:'Не менее 6 символов', required: 'Поле пустое'}
},	

			highlight: function(element) {
				$(element).closest('.control-group').removeClass('success').addClass('error');
			},
			success: function(element) {
				element
				.text('Успешно').addClass('valid')
				.closest('.control-group').removeClass('error').addClass('success');
			}
	  });
		

}); // end document.ready