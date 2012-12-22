package com.SVRPlatform.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyUser {
	String email;
	public static String getNowUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionEmail = (String) session.getAttribute("email");
		if (sessionEmail != null){
			return sessionEmail;
		}
		return null;
	}
}
