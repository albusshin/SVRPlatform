package com.SVRPlatform.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.Response;
import com.SVRPlatform.service.RegisterService;
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
	private String email;
	private String password;
	@SuppressWarnings("rawtypes")
	private List remember;
	private String message;
	private Response res;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private boolean have = false;

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

	public String execute() {
		System.out.println(this.email);
		System.out.println(this.password);
		System.out.println(this.remember);
		res = this.registerService.register(this.email, this.password);
		if (res.email == Email.email_against_rule)
			message = "email_against_rule";
		if (res.email == Email.email_exists)
			message = "email_exists";
		if (res.password == Password.password_against_rule)
			message = message + "password_against_rule";
		if (res.password == Password.password_too_short)
			message = message + "password_too_short";
		System.out.println(message);


		if (res.email == Email.email_ok && res.password == Password.password_ok) {				//register success
			
			request.getSession().setMaxInactiveInterval(60 * 60 * 24 * 7);						//store in session
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("password", password);
			System.out.println("session stored");
			
			if(remember != null)
			{
				Cookie[] cookies = request.getCookies();

				for (int i = 0; i < cookies.length; i++) {
					System.out.println(cookies[i].getName());
					if (cookies[i].getName().equals("email")) {										//have email & password in cookie
						cookies[i].setValue(this.email);
						cookies[i].setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(cookies[i]);
						have = true;
					}

					if (cookies[i].getName().equals("password")) {
						cookies[i].setValue(this.password);
						cookies[i].setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(cookies[i]);
						have = true;
					}
				}
				System.out.println(have + "===========");
				if (have == false) {																//no email & password in cookie
					Cookie cemail = new Cookie("email", this.email);
					Cookie cpassword = new Cookie("password", this.password);
					System.out.println(cemail.getValue());
					cemail.setMaxAge(60 * 60 * 24 * 7);
					cpassword.setMaxAge(60 * 60 * 24 * 7);
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
