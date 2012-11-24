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
    private boolean have;
    
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
 			
 				
 				 Cookie[] cookies = request.getCookies();
			       
				  for (int i = 0; i < cookies.length; i++) {
				        System.out.println("sb");
			            System.out.println(cookies[i].getName());
			        	if (cookies[i].getName().equals("email")) {
			        		cookies[i].setValue(this.email);
			        		response.addCookie(cookies[i]);
 			        		if(remember!=null)
 	 		 		 		{
 	 			        		cookies[i].setMaxAge(60*60*24*7);
 	 				 				
 	 		 		 		}
 	 		 			    else
 	 		 			    {
 	 		 			    	cookies[i].setMaxAge(-1);
 	 		 			    }
 			        		have=true;
			        	}
			            
			            
			        	if (cookies[i].getName().equals("password")) {
			        	cookies[i].setValue(this.password);
			        	response.addCookie(cookies[i]);
			        		if(remember!=null)
	 		 		 		{
	 			        		cookies[i].setMaxAge(60*60*24*7);
	 				 				
	 		 		 		}
	 		 			    else
	 		 			    {
	 		 			    	cookies[i].setMaxAge(-1);
	 		 			    }
			        	}
			        	
 			}
				  if (have==false){
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
		 				if(remember!=null)
 		 		 		{
		 					cemail.setMaxAge(60*60*24*7);
		 					cpassword.setMaxAge(60*60*24*7);
 				 				
 		 		 		}
 		 			    else
 		 			    {
 		 			    	cemail.setMaxAge(-1);
 		 			    	cpassword.setMaxAge(-1);
 		 			    }
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
