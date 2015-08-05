package com.global3Dmod.�Dmodels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OthersController {

	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ModelAndView jobs() {
		ModelAndView modelAndView = new ModelAndView("others/jobs");
		return modelAndView;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("others/about_us");
		return modelAndView;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("others/contact");
		return modelAndView;
	}

	@RequestMapping(value = "/fileConversions", method = RequestMethod.GET)
	public ModelAndView fileConversions() {
		ModelAndView modelAndView = new ModelAndView("others/fileConversions");
		return modelAndView;
	}

	@RequestMapping(value = "/howItWorksDesigner", method = RequestMethod.GET)
	public ModelAndView howItWorksDesigner() {
		ModelAndView modelAndView = new ModelAndView(
				"others/howItWorksDesigner");
		return modelAndView;
	}

	@RequestMapping(value = "/howItWorksUser", method = RequestMethod.GET)
	public ModelAndView howItWorksUser() {
		ModelAndView modelAndView = new ModelAndView("others/howItWorksUser");
		return modelAndView;
	}

	@RequestMapping(value = "/license", method = RequestMethod.GET)
	public ModelAndView license() {
		ModelAndView modelAndView = new ModelAndView("others/license");
		return modelAndView;
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public ModelAndView help() {
		ModelAndView modelAndView = new ModelAndView("others/help");
		return modelAndView;
	}

	@RequestMapping(value = "/mission", method = RequestMethod.GET)
	public ModelAndView ourMission() {
		ModelAndView modelAndView = new ModelAndView("others/ourMission");
		return modelAndView;
	}

	@RequestMapping(value = "/safety", method = RequestMethod.GET)
	public ModelAndView safety() {
		ModelAndView modelAndView = new ModelAndView("others/safety");
		return modelAndView;
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public ModelAndView team() {
		ModelAndView modelAndView = new ModelAndView("others/team");
		return modelAndView;
	}

	@RequestMapping(value = "/we", method = RequestMethod.GET)
	public ModelAndView whyWe() {
		ModelAndView modelAndView = new ModelAndView("others/whyWe");
		return modelAndView;
	}

	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public ModelAndView policy() {
		ModelAndView modelAndView = new ModelAndView("others/policy");
		return modelAndView;
	}

	@RequestMapping(value = "/support", method = RequestMethod.GET)
	public ModelAndView support() {
		ModelAndView modelAndView = new ModelAndView("others/support");
		return modelAndView;
	}
	
	@RequestMapping(value = "/aboutUserSignup", method = RequestMethod.GET)
	public ModelAndView aboutUserSignup() {
		ModelAndView modelAndView = new ModelAndView("others/aboutUserSignup");
		return modelAndView;
	}
	
	@RequestMapping(value = "/aboutDesignerSignup", method = RequestMethod.GET)
	public ModelAndView aboutDesignerSignup() {
		ModelAndView modelAndView = new ModelAndView("others/aboutDesignerSignup");
		return modelAndView;
	}
}
