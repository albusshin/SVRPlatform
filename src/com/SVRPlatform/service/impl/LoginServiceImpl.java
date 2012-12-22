package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Map<String, Object> login(String email, String password) {
		Map<String, ?> map = new HashMap<>();
		if (email == null || password == null){
			return map;
		}
		email = email.toLowerCase();
		if (userDAO.getUserByEmail(email) == null) return false;
		String psswrd = this.userDAO.getUserByEmail(email).getPassword();
		String encodedPassword = PasswordEncoder.EncoderByMd5(password);
		if (psswrd.compareTo(encodedPassword) == 0)
			return true;
		return false;
		
		//userID credit realname
	}
}
