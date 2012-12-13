package com.SVRPlatform.action;

import java.util.List;
import javax.servlet.http.*;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class SignIn extends ActionSupport implements ServletRequestAware,			//sign in~login						
		ServletResponseAware {	
	public static final String FAIL = "fail";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private String password;
	private String message;
	private String email;
	@SuppressWarnings("rawtypes")
	private List remember;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private boolean browserHasCookie;
	private boolean info;	

	public String getMessage() {
		return message;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("rawtypes")
	public void setRemember(List remember) {
		this.remember = remember;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String execute() throws Exception {
		System.out.println("this.email = " + this.email);
		System.out.println("this.password = " + this.password);
		info = this.loginService.login(this.email, this.password);
		System.out.println("this.loginService.login()" + this.info);
		if (!info) {																				//wrong email or password
			message = "Failed to sign in. Please check again and retry.";
			return FAIL;
		} else {																					//valid email and password 								
			request.getSession().setMaxInactiveInterval(60 * 60 * 3);							//Session 3 hours is enough.
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("password", password);	
			
			if(remember != null)																	//remember email and password for 2 weeks
			{
				Cookie[] cookies = request.getCookies();
				for (int i = 0; i < cookies.length; i++) {
					System.out.println(cookies[i].getName());
					if (cookies[i].getName().equals("email")) {										//cookie had email before 
						cookies[i].setValue(this.email);
						response.addCookie(cookies[i]);
						browserHasCookie = true;
					}
					
					if (cookies[i].getName().equals("password")) {									//cookie had password before 
						cookies[i].setValue(this.password);
						response.addCookie(cookies[i]);
						browserHasCookie = true;
					}
				}
				
				if (browserHasCookie == false) {
					Cookie cemail = new Cookie("email", this.email);			    //cookie do not browserHasCookie email & password before  store email & password in cookie
					Cookie cpassword = new Cookie("password", this.password);	
					cemail.setMaxAge(60 * 60 * 24 * 7);
					cpassword.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(cemail);
					response.addCookie(cpassword);
				} 
			}
		}																		
			return SUCCESS;		
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
