package com.SVRPlatform.dao;

import java.util.Date;
import java.util.List;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;

public interface BugDAO extends basicDAO{
	public List<Bug> getByUser(User user);
	
	public List<Bug> getOrderedBug(Date start, Date end, int orderType);
}
