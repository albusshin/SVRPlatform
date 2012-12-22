package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String cookieEmail = null;
	private String cookieHash = null;
	private String emailInSession = null;
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public String execute() {
		HttpSession session = request.getSession();
		emailInSession = (String) session.getAttribute("email");
		if (emailInSession != null) {
			return "LoggedIn";
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) { // get email and password in cookie
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("email")) {
					cookieEmail = cookies[i].getValue();
				}
				if (cookies[i].getName().equals("cookiehash")) {
					cookieHash = cookies[i].getValue();
				}
			}
		}

		if ((cookieEmail == null) && (cookieHash == null)) { // cookie does not
																// exist ~
																// tourist
			return "CookieNotFound";
		} else { // cookie exists
			Map<String, ?> info = this.loginService.cookieLogin(cookieEmail,
					cookieHash);
			if (!(Boolean) info.get("success")) {
				com.SVRPlatform.Utils.UserHandlers.clearSessionAndCookies(
						request, response);
				return "CookieNotFound";
			} else {
				request.getSession().setAttribute("email", cookieEmail);
				request.getSession().setAttribute("userID",
						(Integer) info.get("userID"));
				request.getSession().setAttribute("credit",
						(Integer) info.get("credit"));
				request.getSession().setAttribute("realname",
						(String) info.get("realname"));
				return "LoggedIn"; // Valid email and password
			}

		}
	}

}
