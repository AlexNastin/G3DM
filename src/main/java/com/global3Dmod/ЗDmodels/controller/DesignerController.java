package com.global3Dmod.ÇDmodels.controller;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.service.IDesignerService;

@Controller
public class DesignerController {
	
	@Autowired
	private IDesignerService designerService;

//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	public String handleUpload(@RequestParam("description") String description,
//			@RequestParam("file") MultipartFile file) throws Exception{
//		if (!file.isEmpty()) {
//			System.out.println("File uploaded.");
//			System.out.println("Description: " + description);
//
//			String orgName = file.getOriginalFilename();
//
//			final String PREFIX = this.getClass().getResource("/").getPath();
////			C:\Java\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\G3DM\resources\files
//			System.out.println(PREFIX);
//			// Êàê çàäàòü ïóòü íå æåñòêî???
//			String filePlaceToUpload = "C:/Java/workspasdasdasdasdasdasdace/G3DM/src/main/webapp/resources/files/";
//			String filePath = filePlaceToUpload + orgName;
//			File dest = new File(filePath);
//
//			
//				file.transferTo(dest);
//			
//			return "main";
//		} else {
//			return "test";
//		}
//	}
	
	@RequestMapping(value = "/addPostDB", method = RequestMethod.POST)
	public ModelAndView addPostDB(PostForm postForm, Locale locale, Model model) throws Exception {
			System.out.println(postForm.getFirstPhotoModelFilePath());
			System.out.println(postForm.getCategory_idCategory());
			designerService.addPost(postForm);
			ModelAndView modelAndView2 = new ModelAndView("redirect:/index");
			return modelAndView2;
		}
	
	@RequestMapping(value = "/getStringMVC", method = RequestMethod.GET)
	public String addPostDB() throws Exception {
			
			return "AAAABBBBBCCCCC";
		}

}
