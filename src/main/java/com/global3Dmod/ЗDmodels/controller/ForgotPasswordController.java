package com.global3Dmod.ÇDmodels.controller;

import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

import javax.mail.Message;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import com.global3Dmod.ÇDmodels.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IGuestService;

@Controller
public class ForgotPasswordController {

	@Autowired
	private IDesignerService designerService;

	@Autowired
	private IGuestService guestService;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private MessageSource messages;

	@RequestMapping(value = "/forgotPassword.html", method = RequestMethod.GET)
	public ModelAndView forgotPassword(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/forgot_password");
		return modelAndView;
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public GenericResponse resetPassword(HttpServletRequest request,
			@RequestParam("email") String userEmail) throws ServiceException {
		User user = designerService.getUser(userEmail);
		if (user == null) {
			return new GenericResponse(messages.getMessage("email.message.resetPasswordNotUser", null, request.getLocale()));
		}
		String token = UUID.randomUUID().toString();
		boolean isChange = guestService.createPasswordResetTokenForUser(user,
				token);
		if (isChange) {
			StringBuilder appUrl = new StringBuilder();
			appUrl.append("http://");
			appUrl.append(request.getServerName());
			appUrl.append(":");
			appUrl.append(request.getServerPort());
			appUrl.append(request.getContextPath());
			SimpleMailMessage email = constructResetTokenEmail(
					appUrl.toString(), request.getLocale(), token, user);
			mailSender.send(email);
			return new GenericResponse(messages.getMessage("email.message.resetPasswordEmailSend", null, request.getLocale()));
		}
		return new GenericResponse(messages.getMessage("email.message.resetPasswordEmail", null, request.getLocale()));
	}

	private SimpleMailMessage constructResetTokenEmail(String contextPath,
			Locale locale, String token, User user) {
		String message = messages.getMessage("email.message.resetPassword",
				null, locale);
		String messageSubject = messages.getMessage(
				"email.message.resetPasswordSubject", null, locale);

		StringBuilder url = new StringBuilder(contextPath);
		url.append("/changePassword?id=");
		url.append(user.getIdUser());
		url.append("&token=");
		url.append(token);
		StringBuilder text = new StringBuilder(message);
		text.append(" ");
		text.append(url);

		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getLogin());
		email.setSubject(messageSubject);
		email.setText(text.toString());
		return email;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String showChangePasswordPage(
	  Locale locale, Model model, @RequestParam("id") long id, @RequestParam("token") String token) throws ServiceException {
	     System.out.println("PASSWORD CHANGE");
//	    PasswordResetToken passToken = guestService.getPasswordResetToken(token);
//	    User user = passToken.getUser();
//	    if (passToken == null || user.getIdUser() != id) {
//	        String message = messages.getMessage("auth.message.invalidToken", null, locale);
//	        model.addAttribute("message", message);
//	        return "redirect:/login.html?lang=" + locale.getLanguage();
//	    }
//	 
//	    Calendar cal = Calendar.getInstance();
//	    if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
//	        model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
//	        return "redirect:/login.html?lang=" + locale.getLanguage();
//	    }
	 
//	    Authentication auth = new UsernamePasswordAuthenticationToken(
//	      user, null, userDetailsService.loadUserByUsername(user.getEmail()).getAuthorities());
//	    SecurityContextHolder.getContext().setAuthentication(auth);
	 
	    return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
	}
}
