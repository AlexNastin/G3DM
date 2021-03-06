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
	$.validator.addMethod('filesize', function(value, element, param) {
	    // param = size (en bytes) 
	    // element = element to validate (<input>)
	    // value = value of the element (file name)
	    return this.optional(element) || (element.files[0].size <= param) 
	});
	$.validator.addMethod("aFunction",
		    function(value, element) {
		        if (value == "0")
		            return false;
		        else
		            return true;
		    },
		    "Please select a value");
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
	    	 regexp: '^[A-Za-z\-_]{1,50}$'
	      },
	      surname: {
	    	 regexp: '^[A-Za-z\-_]{1,50}$'
	      },
	      nickName: {
	    	  regexp: '^[a-zA-Z0-9]+$',
	    	  required: true,
	    	  rangelength: [3, 16] 
	      },
	      title: {
	    	  regexp: '^[a-zA-Z0-9\ \'-\_\.]{1,50}$',
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
	    	  accept: "stl,zip,rar",
	    	  required: true,
	    	  filesize: 104857600
	      },
	      modelUpdate: {
	    	  accept: "stl,zip,rar",
	    	  filesize: 104857600
	      },
	      firstPhoto: {
	    	  accept: "jpg,png,jpeg",
	    	  required: true,
	    	  filesize: 3145728
	      },
	      firstPhotoUpdate: {
	    	  accept: "jpg,png,jpeg",
	    	  filesize: 3145728
	      },
	      comment: {
	    	  required: true,
	    	  rangelength: [1, 300] 
	      },
	      avatar: {
	    	  accept: "jpg,png,jpeg",
	    	  filesize: 3145728
	      },
	      dateBirth: {
	    	  date: true
	      },
	      client: { 
	    	  required: true,
	    	  rangelength: [3, 16],
	          regexp: '^[A-Za-z ]+$'
	      },
	      expirationDate: {
	    	  required: true,
	    	  date: true
	      },
	      advertisementPhoto: {
	    	  accept: "jpg,png,jpeg",
	    	  filesize: 3145728,
	    	  required: true
	      },
	      email: {
	    	  required: true,
	    	  email: true
	      },
	      textSupport: {
	    	  required: true,
	    	  rangelength: [1, 300]
	      },
	      role_idRole: {
	    	  required: true
	      },
	      subcategory_idSubcategory: {
	      	  aFunction: true
	      },
	      nameModerator: {
	    	  regexp: '^[A-Za-z\-_]{1,50}$',
	    	  required: true
	      },
	      surnameModerator: {
	    	  regexp: '^[A-Za-z\-_]{1,50}$',
	    	  required: true
	      }
},
messages:  {
	confirmPassword: {
	equalTo: 'Пароли не совпадают',
	required: 'Это поле обязательное.'
		},
	email: {
	  required: 'Это поле обязательное.',
   	  email: 'Неверный формат email'
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
    	rangelength: 'Длина должна быть от 3 до 16 символов.',
    	required: 'Это поле обязательное.'
    },
    name: {
    	regexp: 'Длина должна быть от 0 до 50 символов. Только латинские символы.'
    },
    surname: {
    	regexp: 'Длина должна быть от 0 до 50 символов. Только латинские символы.'
    },
    title: {
    	regexp: 'Длина должна быть от 1 до 50 символов. Только латинские символы.',
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
    	aFunction: 'Выберите подкатегорию.'
    },
    model: {
    	accept: 'Расширение файла должно быть .stl, .zip или .rar',
    	required: 'Пожалуйста, выберите файл.',
    	filesize: 'Максимальный размер файла - 100Мб'
    },
    modelUpdate:{
    	accept: 'Расширение файла должно быть .stl, .zip или .rar',
    	filesize: 'Максимальный размер файла - 100Мб'
    },
    firstPhoto: {
    	accept: 'Расширение изображения должно быть .jpg, .jpeg или .png',
    	required: 'Пожалуйста, выберите изображение.',
    	filesize: 'Максимальный размер изображения - 3Мб'
    },
    firstPhotoUpdate: {
    	accept: 'Расширение изображения должно быть .jpg, .jpeg или .png',
    	filesize: 'Максимальный размер изображения - 3Мб'
    },
    avatar: {
    	accept: 'Расширение изображения должно быть .jpg, .jpeg или .png',
    	filesize: 'Максимальный размер изображения - 3Мб'
    },
    advertisementPhoto: {
    	accept: 'Расширение изображения должно быть .jpg, .jpeg или .png',
    	filesize: 'Максимальный размер изображения - 3Мб',
    	required: 'Пожалуйста, выберите изображение.'
    },
    text: {
    	regexp: 'Длина должна быть от 1 до 300 символов. Только латинские символы.',
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
    	date: 'Неверный формат даты. Верный формат гггг-мм-дд'
    },
    client: {
    	rangelength: 'Длина должна быть от 3 до 16.',
    	required: 'Это поле обязательное.',
        regexp: 'Только латинские символы.'
    },
    expirationDate: {
    	date: 'Неверный формат даты. Верный формат гггг-мм-дд',
    	required: 'Это поле обязательное.'
    },
    role_idRole: {
    	required: 'Пожалуйста, выберите роль'
    },
    nameModerator: {
    	regexp: 'Длина должна быть от 1 до 50 символов. Только латинские символы.',
    	required: 'Это поле обязательное.'
    },
    surnameModerator: {
    	regexp: 'Длина должна быть от 1 до 50 символов. Только латинские символы.',
    	required: 'Это поле обязательное.'
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
