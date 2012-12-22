package com.SVRPlatform.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.Utils.StringEncoder;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Map<String, ?> login(String email, String password, Object... obj) {
		boolean rememberme = false;
		if (obj.length > 0)	rememberme = (boolean) obj[0];
		
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
		String encodedPassword = StringEncoder.EncoderByMd5(password);
		if (psswrd.compareTo(encodedPassword) == 0){
			map.put("success", true);
			map.put("userID", user.getUserId());
			map.put("credit", user.getCredit());
			map.put("realname", user.getRealName());
			if (rememberme) {
				Calendar calendar = Calendar.getInstance();
				
				String hash = StringEncoder.EncoderByMd5(calendar.getTime().toString()+psswrd);
				user.setCookieHash(hash);
				
				calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 15);
				user.setValidDeadline(calendar.getTime());
				userDAO.update(user);
				
				map.put("cookiehash", hash);
			}
			return map;
		}
		
		map.put("success", false);
		return map;
	}

	public Map<String, ?> cookieLogin(String email, String hash) {
		Map<String, Object> map = new HashMap<>();
		
		if (email == null || hash == null){
			map.put("success", false);
			return map;
		}
		
		email = email.toLowerCase();
		User user = userDAO.getUserByEmail(email);
		if (user == null) {
			map.put("success", false);
			return map;
		}
		
		String cookiehash = user.getCookieHash();
		if (cookiehash.compareTo(hash) == 0 && (user.getValidDeadline().getTime() > Calendar.getInstance().getTime().getTime())){
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
