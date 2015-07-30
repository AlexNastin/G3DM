package com.global3Dmod.ÇDmodels.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.validator.RegExCollection;
import com.global3Dmod.ÇDmodels.form.validator.RegExName;
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

	@Autowired
	private RegExCollection collectionRegEx;

	@RequestMapping(value = "/forgotPassword.html", method = RequestMethod.GET)
	public ModelAndView forgotPassword(Locale locale, Model model)
			throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("login/forgot_password");
		return modelAndView;
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(HttpServletRequest request,
			@RequestParam("email") String userEmail, Locale locale)
			throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("login/forgot_password");

		Pattern pattern = collectionRegEx
				.getRegExPattern(RegExName.REGEX_EMAIL);
		Matcher matcher = pattern.matcher(userEmail.toLowerCase());
		if (matcher.matches()) {
			User user = designerService.getUser(userEmail);
			if (user == null) {
				String message = messages.getMessage(
						"email.message.resetPasswordNotUser", null, locale);
				modelAndView.addObject("message", message);
				return modelAndView;
			}
			String token = UUID.randomUUID().toString();
			boolean isChange = guestService.createPasswordResetTokenForUser(
					user, token);
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
				String message = messages.getMessage(
						"email.message.resetPasswordEmailSend", null, locale);
				modelAndView.addObject("message", message);
				return modelAndView;
			}
			String message = messages.getMessage(
					"email.message.resetPasswordEmail", null, locale);
			modelAndView.addObject("message", message);
			return modelAndView;
		} else {
			String message = messages.getMessage(
					"email.message.resetPasswordNotUser", null, locale);
			modelAndView.addObject("message", message);
			return modelAndView;
		}
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
	public ModelAndView showChangePasswordPage(Locale locale, Model model,
			@RequestParam("id") int id, @RequestParam("token") String token)
			throws ServiceException {
		Pattern pattern = collectionRegEx.getRegExPattern(RegExName.REGEX_UUID);
		Matcher matcher = pattern.matcher(token);
		ModelAndView modelAndView = new ModelAndView("login/signin");
		boolean isValid = matcher.matches();
		if (isValid) {
			PasswordResetToken passwordResetToken = guestService
					.getPasswordResetToken(token);
			if (passwordResetToken == null
					|| passwordResetToken.getUser_idUser() != id) {
				String message = messages.getMessage(
						"email.message.invalidToken", null, locale);
				modelAndView.addObject("message", message);
				return modelAndView;
			}

			Calendar cal = Calendar.getInstance();
			if ((passwordResetToken.getExpiryDate().getTime() - cal.getTime()
					.getTime()) <= 0) {
				String message = messages.getMessage("email.message.expired",
						null, locale);
				modelAndView.addObject("message", message);
				return modelAndView;
			}
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_GUEST"));
			User user = guestService.getUser(passwordResetToken
					.getUser_idUser());
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					user, null, grantedAuths);
			SecurityContextHolder.getContext()
					.setAuthentication(authentication);
			modelAndView.setViewName("redirect:/updatePassword");
		}
		String message = messages.getMessage("email.message.invalidToken",
				null, locale);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/savePassword", method = RequestMethod.POST)
	public ModelAndView saveNewPassword(Locale locale, Model model,
			@RequestParam("password") String password) throws ServiceException {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		guestService.updateForgotPassword(user, password);
		ModelAndView modelAndView = new ModelAndView("login/signin");
		String message = messages.getMessage(
				"email.message.resetpaswordsuccessful", null, locale);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
