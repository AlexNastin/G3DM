package com.global3Dmod.�Dmodels.sort.user;

import java.util.Comparator;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.User;

public class SortedUsersByNickNameDesc implements Comparator<User>{

	@Override
	public int compare(User obj1, User obj2) {
		String nickName1 = obj1.getNickName();
        String nickName2 = obj2.getNickName();
        return nickName2.compareTo(nickName1);
	}

}
