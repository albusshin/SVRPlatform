package com.SVRPlatform.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.Response;
import com.SVRPlatform.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class SignUp extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private RegisterService registerService;	
	private String email;
	private String password;
	private List rememberme;
	private String message;
	private Response res;
	private HttpServletResponse response;  
    private HttpServletRequest request;  
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setRememberme(List rememberme) {
		this.rememberme = rememberme;
	}

	public void setregisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public String execute(){
		System.out.println(this.email);
 		System.out.println(this.password);
 		System.out.println(this.rememberme);
 		res=this.registerService.register(this.email,this.password);
 		if(res.Email==email_against_rule) message="email_against_rule";
 		if(res.Email==email_exists) message="email_exists";
 		if(res.Password==password_against_rule) message=message+"password_against_rule";
 		if(res.Password==password_exists) message=message+"password_exists";
 		if(res.Email==email_ok)&&(res.Password==password_ok)	
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
 		else  return "FAIL";
	}
}
