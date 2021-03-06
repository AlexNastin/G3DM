package com.global3Dmod.�Dmodel.sort.user;

import java.util.Comparator;

import com.global3Dmod.�Dmodel.domain.User;

public class SortedUsersBySurname implements Comparator<User>{
	
	@Override
	public int compare(User obj1, User obj2) {
		String surname1 = obj1.getSurname();
        String surname2 = obj2.getSurname();
        return surname1.compareTo(surname2);
	}

}
