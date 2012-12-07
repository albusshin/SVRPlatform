package com.SVRPlatform.service;

public interface PasswordRetrieveService {
	/**
	 * @param email
	 * @return "true" for success and "false" for failure
	 */
	public boolean sendCheckingEmail(String email);
}
