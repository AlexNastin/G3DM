package com.global3Dmod.�Dmodels.sort.user;

import java.util.Comparator;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.User;

public class SortedUsersByCountry implements Comparator<User>{
	
	@Override
	public int compare(User obj1, User obj2) {
		String country1 = obj1.getCountry().getTitle();
        String country2 = obj2.getCountry().getTitle();
        return country1.compareTo(country2);
	}

}
