package com.SVRPlatform.service;

public interface PasswordRetrieveService {
	/**
	 * send the hash value to the email
	 * @param email target email address
	 * @return "true" for success and "false" for failure
	 */
	public boolean sendCheckingEmail(String email);
	/**
	 * check the hash value
	 * @param hashValue
	 * @return the email if exist in the HashForPasswordRetrieve table, 
	 * 			otherwise null
	 */
	public String checkHashValue(String hashValue);
	/**
	 * update the password
	 * @param email the user email 
	 * @param newPassword the new password
	 * @return the Response about the info
	 */
	public Response updatePassword(String email, String newPassword);
}
