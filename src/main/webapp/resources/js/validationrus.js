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
	    	  regexp: '^[a-zA-Z0-9\ \'-\_\.]{2,16}$',
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
	equalTo: 'Пароли не совпадают',
	required: 'Это поле обязательное.'
		},
    password: {
    	regexp: 'Пароль должен содержать одну заглавную, одну строчную латинские буквы и одну цифру.',	
    	rangelength: 'Длина должна быть от 8 до 32 символов.',
    	required: 'Это поле обязательное.'
    },
    login: {
    	email: 'Неверный формат email',
    	required: 'Это поле обязательное.'
    },
    j_username:{
    	email: 'Неверный формат email',
    	required: 'Это поле обязательное.'
    },
    j_password: {
    	regexp: 'Пароль должен содержать одну заглавную, одну строчную латинские буквы и одну цифру.',	
    	rangelength: 'Длина должна быть от 8 до 32 символов.',
    	required: 'Это поле обязательное.'
    },
    nickName:{
    	regexp: 'Только латинские символы',
    	rangelength: 'Длина должна быть от 8 до 16 символов.',
    	required: 'Это поле обязательное.'
    },
    name: {
    	regexp: 'Длина должна быть от 1 до 50 символов. Только латинские буквы.'
    },
    surname: {
    	regexp: 'Длина должна быть от 1 до 50 символов. Только латинские буквы.'
    },
    title: {
    	regexp: 'Длина должна быть от 1 до 16 символов. Только латинские символы.',
    	required: 'Это поле обязательное.'
    },
    description: {
    	regexp: 'Длина должна быть от 2 до 300 символов. Только латинские символы.',
    	required: 'Это поле обязательное.'
    },
    instruction: {
    	regexp: 'Длина должна быть от 2 до 1500 символов. Только латинские символы.',
    	required: 'Это поле обязательное.'
    },
    technologiesId: {
    	required: 'Выберите технологию.'
    },
    category_idCategory: {
    	required: 'Выберите категорию.'
    },
    subcategory_idSubcategory: {
    	required: 'Выберите подкатегорию.'
    },
    model: {
    	accept: 'Расширение файла должно быть: .stl .zip or .rar'
    },
    firstPhoto: {
    	accept: 'Расширение изображения должно быть: .jpg, .jpeg and .png'
    },
    avatar: {
    	accept: 'Расширение изображения должно быть: .jpg, .jpeg and .png'
    },
    advertisementPhoto: {
    	accept: 'Расширение изображения должно быть: .jpg, .jpeg and .png'
    },
    text: {
    	regexp: 'Длина должна быть от 2 до 300 символов. Только латинские символы.',
    	required: 'Сообщение не может быть пустым.'	
    },
    textSupport: {
    	rangelength: 'Длина должна быть от 2 до 300 символов.',
    	required: 'Сообщение не может быть пустым.'
    },
    comment: {
    	rangelength: 'Длина должна быть от 2 до 300 символов.',
    	required: 'Комментарий не можеты быть пустым.'
    },
    dateBirth: {
    	date: 'Неверный формат. Дата должна соответствовать yyyy-mm-dd.'
    },
    client: {
    	rangelength: 'Длина должна быть от 1 до 50.'
    },
    expirationDate: {
    	date: 'Неверный формат. Дата должна соответствовать yyyy-mm-dd.'
    }
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
