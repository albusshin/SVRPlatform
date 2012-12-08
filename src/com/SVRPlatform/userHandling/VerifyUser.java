package com.SVRPlatform.userHandling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyUser {
	String email;
	public String verify(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionEmail = (String) session.getAttribute("email");
		String sessionPassword = (String) session.getAttribute("password");
//		if ()
		return null;
	}
}
