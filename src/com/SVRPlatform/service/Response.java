package com.SVRPlatform.service;

public class Response {
	
	public enum Email {email_against_rule, email_exists, email_ok}
	public enum Password {password_against_rule, password_too_short, password_ok}
	
	public Email email;
	public Password password;
}