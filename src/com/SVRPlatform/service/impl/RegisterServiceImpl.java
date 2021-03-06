package com.SVRPlatform.service.impl;

import java.util.Date;
import java.util.regex.Pattern;

import com.SVRPlatform.Utils.StringEncoder;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;
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
		Pattern digit = Pattern.compile("\\S*[0-9]+\\S*");
		Pattern letter = Pattern.compile("\\S*[a-zA-Z]+\\S*");
		Response response = new Response(); 
		email = email.toLowerCase();
		
		//check if email is against the rule or exists
		if (emailPattern.matcher(email).matches())
			if (email.length()>100) 
				response.email = Response.Email.email_against_rule;
			else if (userDAO.getUserByEmail(email) != null)
				response.email = Response.Email.email_exists;
			else response.email = Response.Email.email_ok;
		else response.email = Response.Email.email_against_rule;
		
		//check if password is against the rule or exists 
		if (password.length() < 8)
			response.password = Response.Password.password_too_short;
		else if (digit.matcher(password).matches() && letter.matcher(password).matches()) 
			response.password = Response.Password.password_ok;
		else response.password = Response.Password.password_against_rule;
		
		//if both email and password are OK, then register
		if (response.email == Response.Email.email_ok && response.password == Response.Password.password_ok) {
			//encoding the password!
			String encodedPassword = StringEncoder.EncoderByMd5(password);
			User user = new User(encodedPassword, email);
			user.setDate(new Date());
			user.setCredit(0);
			user.setRealName(email.split("@")[0]);
			user.setAge(0);
			user.setSeen(new Date());
			user.setProfileViews(0);
			user.setLocation("");
			user.setWebsite("");
			userDAO.add(user);
			
			response.credit = 0;
			response.realName = user.getRealName();
			response.userID = user.getUserId();
		}
		return response;
	}
}
