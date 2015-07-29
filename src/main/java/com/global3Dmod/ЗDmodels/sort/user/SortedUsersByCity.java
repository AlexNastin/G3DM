package com.global3Dmod.�Dmodels.sort.user;

import java.util.Comparator;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.User;

public class SortedUsersByCity implements Comparator<User>{
	
	@Override
	public int compare(User obj1, User obj2) {
		String city1 = obj1.getCity().getTitle();
        String city2 = obj2.getCity().getTitle();
        return city1.compareTo(city2);
	}

}
