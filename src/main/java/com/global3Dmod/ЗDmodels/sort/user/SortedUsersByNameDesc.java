package com.global3Dmod.ÇDmodels.sort.user;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.User;

public class SortedUsersByNameDesc implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String name1 = obj1.getName();
        String name2 = obj2.getName();
        return name2.compareTo(name1);
	}

}
