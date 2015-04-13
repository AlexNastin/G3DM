package com.global3Dmod.ЗDmodels.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DesignerController {
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	  public String handleUpload(@RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
	    if (!file.isEmpty()) {
	      System.out.println("File uploaded.");
	      System.out.println("Description: " + description);
	      String orgName = file.getOriginalFilename();
//	      Как задать путь не жестко???
	      String filePlaceToUpload = "C:/Users/User/git/G3DM/src/main/webapp/resources/images/modelImages/";
	      String filePath = filePlaceToUpload + orgName;
	      File dest = new File(filePath);
	      
	        try {
	            file.transferTo(dest);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       return "main";
	    } else {
	       return "test";
	    }
	  }

}
