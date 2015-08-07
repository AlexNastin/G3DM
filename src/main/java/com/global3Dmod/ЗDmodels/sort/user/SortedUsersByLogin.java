package com.global3Dmod.�Dmodels.sort.user;

import java.util.Comparator;

import com.global3Dmod.�Dmodels.domain.User;

public class SortedUsersByLogin implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String login1 = obj1.getLogin();
        String login2 = obj2.getLogin();
        return login1.compareTo(login2);
	}

}
