package com.SVRPlatform.service.impl;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean login(String email, String password) {
		email = email.toLowerCase();
		if (userDAO.getUserByEmail(email) == null) return false;
		String psswrd = this.userDAO.getUserByEmail(email).getPassword();
		if (psswrd.compareTo(password) == 0)
			return true;
		else return false;
	}
}
