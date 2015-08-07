package com.global3Dmod.ÇDmodels.sort.user;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.User;

public class SortedUsersBySurnameDesc implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String surname1 = obj1.getSurname();
        String surname2 = obj2.getSurname();
        return surname2.compareTo(surname1);
	}

}
