package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.PasswordRetrieveService;
import com.SVRPlatform.service.Response;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPassword extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String password;
	public static final String FAIL = "fail";
	public static final String PASSWORD_TOO_SHORT = "passwordTooShort";
	public static final String PASSWORD_AGAINST_RULE = "passwordAgainstRule";
	private HttpServletRequest request;
	private PasswordRetrieveService passwordRetrieveService;


	public void setPasswordRetrieveService(
			PasswordRetrieveService passwordRetrieveService) {
		this.passwordRetrieveService = passwordRetrieveService;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	String email;
	public String execute() {
		HttpSession session = request.getSession();
		email = (String) session.getAttribute("email");
		System.out.println("this.email = " + this.email);
		Response theResponse = passwordRetrieveService.updatePassword(email, password);
		System.out.println("after updatePassword");
		
		if (theResponse.password == Response.Password.password_ok){
			System.out.println("before return success");
			return SUCCESS;
		}
		else if (theResponse.password == Response.Password.password_too_short){
			System.out.println("password too short");
			return PASSWORD_TOO_SHORT;
		}
		else if (theResponse.password == Response.Password.password_against_rule){
			System.out.println("password against rule");
			return PASSWORD_AGAINST_RULE;
		}
		return FAIL;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

}
