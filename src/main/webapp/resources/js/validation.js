/**
 * Created by Philip Fursov on 29.03.2015.
 * version 1.0
 */

$(document).ready(function(){

	// Validate
	// http://bassistance.de/jquery-plugins/jquery-plugin-validation/
	// http://docs.jquery.com/Plugins/Validation/
	// http://docs.jquery.com/Plugins/Validation/validate#toptions
	$.validator.addMethod(
	        "regexp",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "Please check your input."
	);
	
		$('#contact-form, #comment-form, #add-post-form, #rejectMessageForm').validate({
			
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
	      regexp: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
	      required: true
	      },
	      j_username: {
		        required: true,
		        email: true
	      },
	      j_password: {
	      regexp: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
	      required: true  
	      },
	      text: {
	      required: true,
	      regexp: '^[\x00-\x7F]{2,300}$'
	      },
	      confirmPassword: {
	      equalTo: "#password",
	      required: true 	  
	      },
	      name: {
	    	 regexp: '^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\/<>?:;|=.,]{1,50}$'
	      },
	      surname: {
	    	 regexp: '^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\/<>?:;|=.,]{1,50}$'
	      },
	      nickName: {
	    	  regexp: '^[a-zA-Z]+$'
	      },
	      title: {
	    	  regexp: '^[a-zA-Z0-9\ \'-]{2,16}$',
	    	  required: true
	      },
	      description: {
	    	  regexp: '^[\x00-\x7F]{2,300}$',
	    	  required: true
	      },
	      instruction: {
	    	  regexp: '^[\x00-\x7F]{2,1500}$',
	    	  required: true  
	      },
	      category_idCategory: {
	    	  required: true
	      },
	      subcategory_idSubcategory: {
	    	  required: true 	    	 
	      },
	      technologiesId:{
	    	  required: true
	      },
	      model: {
	    	  accept: "stl"
	      },
	      firstPhoto: {
	    	  accept: "jpg,png,jpeg,gif"
	      }
},
messages:  {
	confirmPassword: {
	equalTo: 'The passwords do not match.'
		},
    password: {
    	rangelength: 'At least 8 characters, but no more than 32.'	
    },
    j_password: {
    	rangelength: 'Please check your input.'	
    },
    technologiesId: {
    	required: 'Please select technology.'
    },
    category_idCategory: {
    	required: 'Please select cetegory.'
    },
    subcategory_idSubcategory: {
    	required: 'Please select subcategory.'
    },
    
},	

			highlight: function(element) {
				$(element).closest('.control-group').removeClass('success').addClass('error');
			},
			success: function(element) {
				element
				.text('Success').addClass('valid')
				.closest('.control-group').removeClass('error').addClass('success');
			}
	  });
		

}); // end document.ready
