package com.global3Dmod.ÇDmodel.sort.user;

import java.util.Comparator;

import com.global3Dmod.ÇDmodel.domain.User;

public class SortedUsersByDateRegistrationDesc implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String date1 = obj1.getRegistrationDate();
        String date2 = obj2.getRegistrationDate();
        return date1.compareTo(date2);
	}

}
