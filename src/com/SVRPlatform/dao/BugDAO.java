package com.SVRPlatform.dao;

import java.util.List;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;

public interface BugDAO extends basicDAO{
	public List<Bug> getByUser(User user);
}
