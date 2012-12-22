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
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public String execute() {
		HttpSession session = request.getSession();
		//System.out.println("In Index");
		//emailInSession = VerifyUser.getNowUser(request);
		emailInSession = (String) session.getAttribute("email");
		// passwordInSession = (String) session.getAttribute("password");
		// //System.out.println("emailInSession == "+emailInSession );
		// //System.out.println("passwordInSession == "+passwordInSession );
		if (emailInSession != null) {
			//System.out.println("Session can log in");
			return "LoggedIn";
		}
		// ELSE
		// if(emailInSession==null){
		// session.setMaxInactiveInterval(60 * 60 * 24 * 7); //store in new
		// session as tourist ,modify later
		// session.setAttribute("email", "tourist");
		// session.setAttribute("password", "tourist");
		// } //Totally uselesssssss code. What the fuck were you possibly
		// thinking.
		Cookie[] cookies = request.getCookies();
		//System.out.println("getcookie");
		if (cookies != null) { // get email and password in cookie
			//System.out.println("cookies is not null");
			for (int i = 0; i < cookies.length; i++) {
				//System.out.println(cookies[i].getName() + "/////");
				//System.out.println(cookies[i].getValue());
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
			//System.out.println("cookieEmail == " + cookieEmail);
			//System.out.println("cookieHash == " + cookieHash);
			//System.out.println("before loginService.cookieLogin()");
			//System.out.println("this.loginService == " + this.loginService);
			Map<String, ?> info = this.loginService.cookieLogin(cookieEmail,
					cookieHash);
			//System.out.println("after loginService.cookieLogin()");
			if (!(Boolean) info.get("success")) {
				//System.out.println("loginservice cookielogin failed");
				com.SVRPlatform.Utils.UserHandlers.clearSessionAndCookies(
						request, response);
				return "CookieNotFound";
			} else {
				//System.out.println("valid user infomation");
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
