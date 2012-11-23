package com.SVRPlatform.service.impl;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean canLogin(String username, String password) {
		String psswrd = this.userDAO.getPasswordByUsername(username);
		
		if (psswrd.compareTo(password) == 0) {
			return true;
		}
		
		return false;
	}

}
