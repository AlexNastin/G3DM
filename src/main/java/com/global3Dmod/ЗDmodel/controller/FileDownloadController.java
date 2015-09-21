package com.global3Dmod.ÇDmodel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.global3Dmod.ÇDmodel.exception.ServiceException;
import com.global3Dmod.ÇDmodel.property.PropertyManagerG3DM;
import com.global3Dmod.ÇDmodel.property.PropertyNameG3DM;
import com.global3Dmod.ÇDmodel.service.IGuestService;

@Controller
public class FileDownloadController {

	private short countDownload = 0;

	@Autowired
	private IGuestService guestService;
	
	@Autowired
	private PropertyManagerG3DM propertyManager;

	/**
	 * Size of a byte buffer to read/write file
	 */
	private final int BUFFER_SIZE = 8096;

	private final String HEADER_KEY = "Content-Disposition";

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("id") int idFile)
			throws ServiceException, IOException {
		increment();
		boolean isLimit = isLimit();
		if (isLimit) {
			guestService.updateCountDownload(idFile, countDownload);
			zeroing();
		}
		
		String fullPath = guestService.getFileFullPath(idFile);

		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(HEADER_KEY, headerValue);

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			inputStream.close();
			outStream.close();
		}

	}

	private void increment() {
		countDownload++;
	}

	private boolean isLimit() {
		short limit = Short.parseShort(propertyManager
				.getValue(PropertyNameG3DM.LIMIT_DOWNLOAD));
		boolean isLimit = false;
		if (countDownload >= limit) {
			isLimit = true;
		}
		return isLimit;
	}

	private void zeroing() {
		countDownload = 0;
	}
}
