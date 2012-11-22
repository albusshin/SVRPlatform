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
		// TODO Auto-generated method stub
		String pass = this.userDAO.getPasswordByUsername(username);
		System.out.println(pass+" "+password);
		try {
		System.out.println(pass.compareTo(password));
		
			if(pass.compareTo(password)==0)
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return false;
	}

}
