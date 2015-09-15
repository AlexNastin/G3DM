package com.global3Dmod.ÇDmodel.sort.user;

import java.util.Comparator;

import com.global3Dmod.ÇDmodel.domain.User;

public class SortedUsersByCountryDesc implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String country1 = obj1.getCountry().getTitle();
        String country2 = obj2.getCountry().getTitle();
        return country2.compareTo(country1);
	}

}
