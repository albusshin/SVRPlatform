package com.SVRPlatform.dao.impl;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public String getPasswordByEmail(String email) {
		// TODO Auto-generated method stub
		return "abc12345";
	}

	@Override
	public boolean ifEmailExists(String email) {
		// TODO Auto-generated method stub
		if (email.compareTo("21250546@qq.com") == 0) return true;
		else return false;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
