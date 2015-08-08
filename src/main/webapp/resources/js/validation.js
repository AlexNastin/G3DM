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
	
		$('#contact-form, #comment-form, #add-post-form, #rejectMessageForm, #addModeratorForm, #advertisement-form, #support-form').validate({
			
	    rules: {
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
	      rangelength: [8, 32],
	      regexp: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,
	      required: true
	      },
	      j_username: {
		        required: true,
		        email: true
	      },
	      j_password: {
	      rangelength: [8, 32],
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
	    	 regexp: /^[A-Za-z^±!@£$%^&*+§¡€#¢§¶•ªº«\\/<>?:;|=.,]{1,50}$/
	      },
	      surname: {
	    	 regexp: /^[A-Za-z^±!@£$%^&*+§¡€#¢§¶•ªº«\\/<>?:;|=.,]{1,50}$/
	      },
	      nickName: {
	    	  regexp: '^[a-zA-Z0-9]+$',
	    	  required: true,
	    	  rangelength: [3, 16] 
	      },
	      title: {
	    	  regexp: '^[a-zA-Z0-9\ \'-\_\.]{1,16}$',
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
	      technologiesId:{
	    	  required: true
	      },
	      model: {
	    	  accept: "stl,zip,rar"
	      },
	      firstPhoto: {
	    	  accept: "jpg,png,jpeg"
	      },
	      comment: {
	    	  required: true,
	    	  rangelength: [1, 300] 
	      },
	      avatar: {
	    	  accept: "jpg,png,jpeg"
	      },
	      dateBirth: {
	    	  date: true
	      },
	      client: { 
	    	  required: true,
	    	  rangelength: [1, 50]
	      },
	      expirationDate: {
	    	  required: true,
	    	  date: true
	      },
	      advertisementPhoto: {
	    	  accept: "jpg,png,jpeg"
	      },
	      email: {
	    	  required: true,
	    	  email: true
	      },
	      textSupport: {
	    	  required: true,
	    	  rangelength: [1, 300]
	      }
},
messages:  {
	confirmPassword: {
	equalTo: 'The passwords do not match.'
		},
    password: {
    	regexp: 'At least  one character, one upper case character, one digit.',	
    	rangelength: 'Lenght should be from 8 to 32 characters.'
    },
    j_password: {
    	regexp: 'At least  one character, one upper case character, one digit.',
    	rangelength: 'Lenght should be from 8 to 32 characters.'
    },
    nickName:{
    	regexp: 'Latin characters only.',
    	rangelength: 'Lenght should be from 3 to 16 characters.' 
    },
    name: {
    	regexp: 'Lenght should be from 1 to 50 characters. Latin characters only.'
    },
    surname: {
    	regexp: 'Lenght should be from 1 to 50 characters. Latin characters only.'
    },
    title: {
    	regexp: 'Lenght should be from 1 to 16 characters. Latin characters only.'
    },
    description: {
    	regexp: 'Lenght should be from 2 to 300 characters. Latin characters only.'
    },
    instruction: {
    	regexp: 'Lenght should be from 2 to 1500 characters. Latin characters only.'
    },
    technologiesId: {
    	required: 'Please select technology.'
    },
    category_idCategory: {
    	required: 'Please select cetegory.'
    },
    model: {
    	accept: 'Extension should be .stl .zip or .rar'
    },
    firstPhoto: {
    	accept: 'Allowed .jpg, .jpeg and .png images only'
    },
    avatar: {
    	accept: 'Allowed .jpg, .jpeg and .png images only'
    },
    advertisementPhoto: {
    	accept: 'Allowed .jpg, .jpeg and .png images only'
    },
    text: {
    	regexp: 'Lenght should be from 2 to 300 characters. Latin characters only.'
    },
    textSupport: {
    	rangelength: 'Lenght should be from 2 to 300 characters.'
    },
    comment: {
    	rangelength: 'Lenght should be from 2 to 300 characters.',
    	required: 'Comment cannot be empty.'
    },
    dateBirth: {
    	date: 'Wrong format. It should be yyyy-mm-dd'
    },
    client: {
    	rangelength: 'Lenght should be from 1 to 50 characters.'
    },
    expirationDate: {
    	date: 'Wrong format. It should be yyyy-mm-dd'
    }
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
