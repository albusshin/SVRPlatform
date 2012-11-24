package com.SVRPlatform.service.impl;

import java.util.regex.Pattern;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.service.RegisterService;
import com.SVRPlatform.service.Response;

public class RegisterServiceImpl implements RegisterService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Response register(String email, String password) {
		Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Response response = new Response(); 
		email = email.toLowerCase();
		
		if (emailPattern.matcher(email).matches())
			if (userDAO.ifEmailExists(email))
				response.email = Response.Email.email_exists;
			else response.email = Response.Email.email_ok;
		else response.email = Response.Email.email_against_rule;
		
		if (password.length() < 8)
			response.password = Response.Password.password_too_short;
		else if ()
	}
}
