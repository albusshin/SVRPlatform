package com.SVRPlatform.action;

import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private LoginService loginService;
	private String username;
	private String password;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginAction() {
		super();
		System.out.println("loginAction");
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String execute() throws Exception{
//		System.out.println(this.username);
//		System.out.println(this.password);
		boolean is = this.loginService.canLogin(this.username, this.password);
		System.out.println(is);
		if(is)
			message = "success";
		else
			message = "failed";
		return SUCCESS;
	}
}
