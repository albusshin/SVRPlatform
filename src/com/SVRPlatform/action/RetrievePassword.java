package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.PasswordRetrieveService;
import com.opensymphony.xwork2.ActionSupport;

public class RetrievePassword extends ActionSupport implements
		ServletRequestAware, // sign in~login
		ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3583001188704482138L;
	public static final String FAIL = "fail";
	final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	// private HttpServletResponse response;
	// private HttpServletRequest request;
	private PasswordRetrieveService passwordretrieveservice;

	public void setPasswordretrieveservice(
			PasswordRetrieveService passwordretrieveservice) {
		this.passwordretrieveservice = passwordretrieveservice;
	}

	String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String execute() {

		if (passwordretrieveservice.sendCheckingEmail(email)) {
			return SUCCESS;
		}
		return FAIL;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		// this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// this.request = request;
	}
}
