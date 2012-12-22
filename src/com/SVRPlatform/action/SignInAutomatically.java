package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SignInAutomatically extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private HttpServletRequest request; 
	private String email;
	private String cookiehash;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	
	public String execute(){
		//check whether email & password are valid or not
		
		//get email & password in session
		ActionContext act=ActionContext.getContext();
		email= (String) act.getSession().get("email");
		//password = (String) act.getSession().get("password");  
		System.out.println("Email == " + email);
		if (email != null){
			System.out.println("Signinauto.");
			return "SignInAtomatically";
		}
		
//		if (email.equals("tourist") || password.equals("tourist")){                 //BUGGY STATEMENT.
//		if (email == null || password == null){
		else{
			//get email & password in cookie 	
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {									
//	        	for (int i = 0; i < cookies.length; i++) {				
//	        	if (cookies[i].getName().equals("email")) {
//	        		email= cookies[i].getValue();
//	            }
//	            if (cookies[i].getName().equals("password")) {
//	                password = cookies[i].getValue();
//	            }
				for (Cookie cookie:cookies){
					if (cookie.getName().equals("email")){
						email = cookie.getValue();
					}
					if (cookie.getName().equals("cookiehash")){
						cookiehash = cookie.getValue();
					}
				}
	        }
		}
		Map<String, ?> info=this.loginService.cookieLogin(email, cookiehash);
		if((Boolean)info.get("success")){
			return "SignInAtomatically";
		}
		else {
			return "FailToSignIn";
		}
	}




}
