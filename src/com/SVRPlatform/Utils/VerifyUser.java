package com.SVRPlatform.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyUser {
	public static String getNowUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionEmail = (String) session.getAttribute("email");
		return sessionEmail;
	}
	public static int getNowUserID(HttpServletRequest request){
		HttpSession session = request.getSession();
		int sessionID;
		try{
			sessionID = (Integer) session.getAttribute("userID");
			return sessionID;
		}
		catch (NullPointerException e){
			return -1;
		}
	}
	public static String getNowUserRealname(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionRealname = (String) session.getAttribute("realname");
		return sessionRealname;
	}
}
