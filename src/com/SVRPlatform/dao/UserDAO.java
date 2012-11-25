package com.SVRPlatform.dao;

import java.io.Serializable;

import com.SVRPlatform.model.User;

public interface UserDAO {
	
	public String getPasswordByEmail(String email);
	
	public boolean ifEmailExists(String email);
	
	public Serializable addUser(User user);
}
