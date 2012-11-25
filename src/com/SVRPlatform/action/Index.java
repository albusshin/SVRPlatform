package com.SVRPlatform.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private HttpServletResponse response;  
    private HttpServletRequest request;  
    private String cookieEmail = null;
    private String cookiePassword = null;
	private String message;
    
    public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public String execute()
	{
		System.out.println("ININININ");
		Cookie[] cookies = request.getCookies();	
        if (cookies != null) {
        	
          for (int i = 0; i < cookies.length; i++) {
            System.out.println(cookies[i].getName() +"/////");
            
            System.out.println(cookies[i].getValue() );
        	  if (cookies[i].getName().equals("email")) {
        		  cookieEmail= cookies[i].getValue();
            }
             
        	  if (cookies[i].getName().equals("password")) {
                  cookiePassword = cookies[i].getValue();
                  break;
            }
            
          }
        }
        System.out.println("---------------------");

        if ((cookieEmail== null)&&(cookiePassword==null)) {
          return "CookieNotFound";
        }
        else
        {
    		boolean info = this.loginService.login(cookieEmail, cookiePassword);
    		System.out.println(info);
    		if(!info)
    		{	
    			message = "failed";
    			return "NotAuthenticated";
    		}
    		System.out.println("execute come on");
        	return "LoggedIn";
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
