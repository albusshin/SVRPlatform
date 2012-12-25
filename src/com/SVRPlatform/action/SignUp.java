package com.SVRPlatform.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.LoginService;
import com.SVRPlatform.service.RegisterService;
import com.SVRPlatform.service.Response;
import com.SVRPlatform.service.Response.Email;
import com.SVRPlatform.service.Response.Password;
import com.opensymphony.xwork2.ActionSupport;

public class SignUp extends ActionSupport implements ServletRequestAware,		//sign up~ register
		ServletResponseAware {
	public static final String FAIL = "fail";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegisterService registerService;
	private LoginService loginService;
	private String email;
	private String password;
	@SuppressWarnings("rawtypes")
	private List remember;
	private String message;
	private Response res;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private boolean browserHasCookie = false;

	public String getMessage() {
		return message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("rawtypes")
	public void setRemember(List remember) {
		this.remember = remember;
	}

	public void setregisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String execute() {
		//System.out.println(this.email);
		//System.out.println(this.password);
		//System.out.println(this.remember);
		res = this.registerService.register(this.email, this.password);
		if (res.email == Email.email_against_rule)
			message = "Email is not properly filled in. Please refill and retry.<br><br>";
		if (res.email == Email.email_exists)
			message = "This email address is already signed up on SVRPlatform. <br><br>";
		if (res.password == Password.password_against_rule){
			if (message != null)
				message = message + "Your password is too simple to guess. Please include UPPER LETTERS, lower letters and numbers in your password.";
			else
				message = "Your password is too simple to guess. Please include UPPER LETTERS, lower letters and numbers in your password.";
		}
	
		if (res.password == Password.password_too_short){
			if (message != null)
				message = message + "Your password is too short. Please at least include 8 characters.";
			else 
				message = "Your password is too short. Please at least include 8 characters.";
		}
		//System.out.println(message);


		if (res.email == Email.email_ok && res.password == Password.password_ok) {				//register success
			
			request.getSession().setMaxInactiveInterval(60 * 60 * 3);						//Session 3 hours is enough.
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("userID", res.userID);
			request.getSession().setAttribute("credit", res.credit);
			request.getSession().setAttribute("realname", res.realName);
			//System.out.println("session stored");
			
			if(remember != null)
			{

				Map<String, ?> info = this.loginService.login(email, password, true);
				Cookie[] cookies = request.getCookies();
				for (int i = 0; i < cookies.length; i++) {
					//System.out.println(cookies[i].getName());
					if (cookies[i].getName().equals("email")) {										//cookie had email before 
						cookies[i].setValue(this.email);
						response.addCookie(cookies[i]);
						browserHasCookie = true;
					}
					
					if (cookies[i].getName().equals("cookiehash")) {									//cookie had password before 
						cookies[i].setValue((String)info.get("cookiehash"));
						response.addCookie(cookies[i]);
						browserHasCookie = true;
					}
				}
				
				if (browserHasCookie == false) {
					Cookie cemail = new Cookie("email", this.email);			    //cookie do not browserHasCookie email & password before  store email & password in cookie
					Cookie cpassword = new Cookie("cookiehash", (String) info.get("cookiehash"));
					cemail.setMaxAge(60 * 60 * 24 * 15);
					cpassword.setMaxAge(60 * 60 * 24 * 15);
					response.addCookie(cemail);
					response.addCookie(cpassword);
				}
			}

			return SUCCESS;
		} else {
		
			return FAIL;	
			//register failed
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
