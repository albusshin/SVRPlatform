package com.SVRPlatform.dao;

import java.io.Serializable;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;

public interface UserDAO extends basicDAO{
	
	public String getPasswordByEmail(String email);
	
	public boolean ifEmailExists(String email);
	
	public Serializable getSoftwareByName(String softwareName);
	
	public Serializable getUserByEmail(String email);
	
	public Serializable addUser(User user);
}
