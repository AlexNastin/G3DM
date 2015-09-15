package com.global3Dmod.ÇDmodel.service.helper;

import java.util.Date;

public class ServiceHelper {

	public static String generationNumberPost(Date date, String nickName, Integer idCategory, Integer idSubcategory) {
		int random = "global3dmod".hashCode();
		int day = date.getDate();
		int month = date.getMonth() + 1;
		int result = idCategory*idSubcategory*random;
		if(result<0){
			result = result * (-1);
		}
		StringBuilder numberPost = new StringBuilder();
		numberPost.append(month);
		numberPost.append(day);
		numberPost.append(result);
		numberPost.append(" ");
		numberPost.append(nickName);
		return numberPost.toString();
	}

}
