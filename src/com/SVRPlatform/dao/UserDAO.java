package com.SVRPlatform.dao;

import com.SVRPlatform.model.User;

public interface UserDAO extends basicDAO{
	
	public User getUserByEmail(String email);

}
