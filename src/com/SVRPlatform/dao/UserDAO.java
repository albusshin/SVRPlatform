package com.SVRPlatform.dao;

import com.SVRPlatform.model.User;

public interface UserDAO {
	
	public String getPasswordByEmail(String email);
	
	public boolean ifEmailExists(String email);
	
	public void addUser(User user);
}
