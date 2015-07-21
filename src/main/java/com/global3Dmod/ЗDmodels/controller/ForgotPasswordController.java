package com.global3Dmod.ÇDmodels.controller;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.GenericResponse;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IGuestService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class ForgotPasswordController {

	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	MailSender mailSender;
	
	@RequestMapping(value = "/go/forgotPassword", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/forgot_password");
		return modelAndView;
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public GenericResponse resetPassword(
	  HttpServletRequest request, @RequestParam("email") String userEmail) {
	     System.out.println("Start");
	     System.out.println(userEmail);
	     User user = null;
		try {
			user = designerService.getUser(userEmail);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if (user == null) {
//	        throw new UserNotFoundException();
	    }
	 
	    String token = UUID.randomUUID().toString();
	    try {
			userService.createPasswordResetTokenForUser(user, token);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String appUrl = 
	      "http://" + request.getServerName() + 
	      ":" + request.getServerPort() + 
	      request.getContextPath();
	    SimpleMailMessage email =  constructResetTokenEmail(appUrl, request.getLocale(), token, user);
	    mailSender.send(email);
	 
	    return new GenericResponse("GenericResponse AASADDA");
//	    messages.getMessage("message.resetPasswordEmail", null, request.getLocale())
	}
	
	private SimpleMailMessage constructResetTokenEmail(
			  String contextPath, Locale locale, String token, User user) {
			    String url = contextPath + "/user/changePassword?id=" + user.getIdUser() + "&token=" + token;
//			    String message = messages.getMessage("message.resetPassword", null, locale);
			    SimpleMailMessage email = new SimpleMailMessage();
			    email.setTo(user.getLogin());
			    email.setSubject("Reset Password");
			    email.setText("Update Password" + " rn " + url);
			    email.setFrom("global3dmod@gmail.com");
			    return email;
			}
}
