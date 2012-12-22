package com.SVRPlatform.service;

import java.util.Map;

public interface LoginService {
	
	public Map<String, ?> login(String email, String password);
}