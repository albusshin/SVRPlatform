package com.SVRPlatform.dao;

import com.SVRPlatform.model.Users;

public interface UserDAO {
	
	public String getPasswordByEmail(String email);
	
	public boolean ifEmailExists(String email);
	
	public void addUser(Users user);
}
