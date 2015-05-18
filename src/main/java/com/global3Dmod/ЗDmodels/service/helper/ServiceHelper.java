package com.global3Dmod.ÇDmodels.service.helper;

import java.util.Date;

public class ServiceHelper {

	public static String generationNumberPost(Date date, String nickName) {
		long time = date.getTime();
		StringBuilder numberPost = new StringBuilder();
		numberPost.append(time);
		numberPost.append(nickName);
		return numberPost.toString();
	}

}
