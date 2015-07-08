package com.global3Dmod.�Dmodels.sort.comment;

import java.util.Comparator;
import java.util.Date;

import com.global3Dmod.�Dmodels.domain.Comment;
import com.global3Dmod.�Dmodels.domain.Post;

public class SortedCommentsByDate implements Comparator<Comment>{

	@Override
	public int compare(Comment obj1, Comment obj2) {
		Date date1 = obj1.getDateTime();
        Date date2 = obj2.getDateTime();
        return date2.compareTo(date1);
	}

}
