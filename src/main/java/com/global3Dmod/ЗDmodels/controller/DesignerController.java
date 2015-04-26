package com.global3Dmod.ЗDmodels.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DesignerController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleUpload(@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception{
		if (!file.isEmpty()) {
			System.out.println("File uploaded.");
			System.out.println("Description: " + description);

			String orgName = file.getOriginalFilename();

			final String PREFIX = this.getClass().getResource("/").getPath();
//			C:\Java\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\G3DM\resources\files
			System.out.println(PREFIX);
			// Как задать путь не жестко???
			String filePlaceToUpload = "C:/Java/workspasdasdasdasdasdasdace/G3DM/src/main/webapp/resources/files/";
			String filePath = filePlaceToUpload + orgName;
			File dest = new File(filePath);

			
				file.transferTo(dest);
			
			return "main";
		} else {
			return "test";
		}
	}

}
