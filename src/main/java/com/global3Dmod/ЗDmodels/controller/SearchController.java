package com.global3Dmod.ÇDmodels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.search.PostSearch;

@Controller
public class SearchController {

	@Autowired
	private PostSearch postSearch;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView index( @RequestParam(value = "text", required = false) String text) throws Exception {
		
		System.out.println(text);
		List<Post> cate = postSearch.search(text);
		System.out.println(cate.get(0).toString());
		System.out.println(cate.get(0).getClass());
		System.out.println(cate.size());

		for (Post post : cate) {
			System.out.println(post);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}

}
