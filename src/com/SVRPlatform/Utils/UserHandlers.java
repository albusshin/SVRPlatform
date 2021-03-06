package com.SVRPlatform.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserHandlers {
	public static boolean clearSessionAndCookies(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.removeAttribute("password");
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return false;
		for (Cookie cookie:cookies){
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return true;
	}
}
