package com.SVRPlatform.service;

import java.util.Map;

public interface LoginService {
	
	/**
	 * @param email
	 * @param password
	 * @return 	("success", boolean); 
	 * 			("userID", int); 
	 * 			("credit", int); 
	 * 			("realname", String); 
	 */
	public Map<String, ?> login(String email, String password);
}