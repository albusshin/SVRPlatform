package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Map<String, ?> login(String email, String password, boolean rememberme) {
		Map<String, Object> map = new HashMap<>();
		if (email == null || password == null){
			map.put("success", false);
			return map;
		}
		
		email = email.toLowerCase();
		User user = userDAO.getUserByEmail(email);
		if (user == null) {
			map.put("success", false);
			return map;
		}
		
		String psswrd = user.getPassword();
		String encodedPassword = PasswordEncoder.EncoderByMd5(password);
		if (psswrd.compareTo(encodedPassword) == 0){
			map.put("success", true);
			map.put("userID", user.getUserId());
			map.put("credit", user.getCredit());
			map.put("realname", user.getRealName());
			return map;
		}
		
		map.put("success", false);
		return map;
	}
}
