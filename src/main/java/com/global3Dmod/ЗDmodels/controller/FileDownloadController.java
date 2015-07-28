package com.global3Dmod.ÇDmodels.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileDownloadController {

	/**
	 * Size of a byte buffer to read/write file
	 */
	private static final int BUFFER_SIZE = 4096;

	/**
	 * Path of the file to be downloaded, relative to application's directory
	 */
	private String filePath = "D:/java.pdf";
	
	 /**
     * Method for handling file download request from client
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("START DOUNLAD");
    	  ServletContext context = request.getServletContext();
          String appPath = context.getRealPath("");
          System.out.println("appPath = " + appPath);
   
          // construct the complete absolute path of the file
          String fullPath = appPath + filePath;      
          File downloadFile = new File(fullPath);
          FileInputStream inputStream = new FileInputStream(downloadFile);
           
          // get MIME type of the file
          String mimeType = context.getMimeType(fullPath);
          if (mimeType == null) {
              // set to binary type if MIME mapping not found
              mimeType = "application/octet-stream";
          }
          System.out.println("MIME type: " + mimeType);
   
          // set content attributes for the response
          response.setContentType(mimeType);
          response.setContentLength((int) downloadFile.length());
   
          // set headers for the response
          String headerKey = "Content-Disposition";
          String headerValue = String.format("attachment; filename=\"%s\"",
                  downloadFile.getName());
          response.setHeader(headerKey, headerValue);
   
          // get output stream of the response
          OutputStream outStream = response.getOutputStream();
   
          byte[] buffer = new byte[BUFFER_SIZE];
          int bytesRead = -1;
   
          // write bytes read from the input stream into the output stream
          while ((bytesRead = inputStream.read(buffer)) != -1) {
              outStream.write(buffer, 0, bytesRead);
          }
   
          inputStream.close();
          outStream.close();
   
      }

}
