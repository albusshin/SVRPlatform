package com.SVRPlatform.action;

import java.util.List;
import javax.servlet.http.*;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private String password;
	private String message;
	private String email;
	private List remember;
	private Cookie cookie;
	private HttpServletResponse response;  
    private HttpServletRequest request;  
    
    
	public String getMessage() {
		return message;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String execute() throws Exception{
		
 		System.out.println(this.email);
 		System.out.println(this.password);
 		System.out.println(this.remember);
 		boolean info = this.loginService.login(this.email, this.password);
 		System.out.println(info);
 		if(!info)
 		{	
 			message = "failed";
 			return "FAIL";
 		}
 		else	
 		{
 			if(remember!=null)
 			{
 				Cookie cemail = new Cookie("email",this.email) ;
 				Cookie cpassword = new Cookie("password", this.password) ;
 				cemail.setMaxAge(60*60*24*7);
 				cpassword.setMaxAge(60*60*24*7);
 				response.addCookie(cookie); 			
 			}
 	        return SUCCESS;
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
