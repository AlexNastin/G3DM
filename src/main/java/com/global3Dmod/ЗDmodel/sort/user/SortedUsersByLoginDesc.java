package com.global3Dmod.�Dmodel.sort.user;

import java.util.Comparator;

import com.global3Dmod.�Dmodel.domain.User;

public class SortedUsersByLoginDesc implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String login1 = obj1.getLogin();
        String login2 = obj2.getLogin();
        return login2.compareTo(login1);
	}

}
