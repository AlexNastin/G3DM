package com.global3Dmod.ÇDmodel.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodel.form.SupportForm;
import com.global3Dmod.ÇDmodel.property.PropertyManagerG3DM;
import com.global3Dmod.ÇDmodel.property.PropertyNameG3DM;

@Controller
public class SupportController {

	@Autowired
	private PropertyManagerG3DM propertyManager;

	@Autowired
	private MessageSource messages;

	@Autowired
	private MailSender mailSender;

	@RequestMapping(value = "/supportEmailSend", method = RequestMethod.POST)
	public ModelAndView signupAddUser(SupportForm supportForml, Locale locale) {

		String ourEmail = propertyManager
				.getValue(PropertyNameG3DM.EMAIL_GLOBAL3DMOD);
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(ourEmail);
		email.setSubject("Support G3DM from: " + supportForml.getEmail());
		email.setFrom(supportForml.getEmail());
		email.setText(supportForml.getTextSupport());
		ModelAndView modelAndView = new ModelAndView("others/support");
		mailSender.send(email);
		String message = messages.getMessage("support.email.send", null, locale);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		return modelAndView;
	}

}
