package com.SVRPlatform.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyUser {
	public static String getNowUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionEmail = (String) session.getAttribute("email");
		return sessionEmail;
	}
	public static String getNowUserID(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("userID");
		return sessionID;
	}
}
