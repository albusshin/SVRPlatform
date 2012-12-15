package com.SVRPlatform.dao;

import java.util.List;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.User;

public interface CommentDAO extends basicDAO {

	public List<Comment> getByUserIdAndBugId(User user, Bug bug, int fetchSize,
			int firstResult);

	public List<Comment> getByBugId(Bug bug, int fetchSize,
			int firstResult);

	public List<Comment> getByUserId(User user, int fetchSize,
			int firstResult);
	
	public long getCountFromOneBug(Bug bug);
	
	public long getCountFromOneUser(User user);

}