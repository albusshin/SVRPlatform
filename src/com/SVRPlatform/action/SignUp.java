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

public class SignUp extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegisterService registerService;	
	private String email;
	private String password;
	private List remember;
	private String message;
	private Response res;
	private HttpServletResponse response;  
    private HttpServletRequest request;  
	
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


	public void setRemember(List remember) {
		this.remember = remember;
	}

	public void setregisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public String execute(){
		System.out.println(this.email);
 		System.out.println(this.password);
 		System.out.println(this.remember);
 		res=this.registerService.register(this.email,this.password);
 		if(res.email==Email.email_against_rule) message="email_against_rule";
 		if(res.email==Email.email_exists) message="email_exists";
 		if(res.password==Password.password_against_rule) message=message+"password_against_rule";
 		if(res.password==Password.password_too_short) message=message+"password_too_short";
 		System.out.println(message);
 		
 		if(res.email== Email.email_ok && res.password== Password.password_ok)	
 		{System.out.println("1");
 			if(remember!=null)
 			{
 				System.out.println("2");
 				Cookie cemail = new Cookie("email",this.email) ;
 				Cookie cpassword = new Cookie("password", this.password) ;
 				System.out.println("3");
 				cemail.setMaxAge(60*60*24*7);
 				cpassword.setMaxAge(60*60*24*7);
 				System.out.println("4");
 				response.addCookie(cemail);
 				response.addCookie(cpassword);
 				System.out.println("5");
 				
 			}
 				return SUCCESS;
 		}
 		else    
 			{
 				return "FAIL";
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
