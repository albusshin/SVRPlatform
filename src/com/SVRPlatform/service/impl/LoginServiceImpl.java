package com.SVRPlatform.service.impl;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean canLogin(String email, String password) {
		email = email.toLowerCase();
		String psswrd = this.userDAO.getPasswordByEmail(email);
		
		if (psswrd.compareTo(password) == 0) {
			return true;
		}
		
		return false;
	}
}
