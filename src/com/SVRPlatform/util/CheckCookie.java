package com.SVRPlatform.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckCookie extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private static final long serialVersionUID = 1L;
	private static LoginService loginService;
	private static HttpServletResponse response;
	private static HttpServletRequest request;
    private static String cookieEmail = null;
    private static String cookiePassword = null;
    private static Cookie[] cookies = null;
    
	public void setLoginService(LoginService loginService) {
		CheckCookie.loginService = loginService;
	}
	


	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		CheckCookie.response=response;
	}

	public static String check(HttpServletRequest req)
	{
		CheckCookie.request=req;
		System.out.println("checking");
		cookies= request.getCookies();	
		System.out.println("getcookie");
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
    		boolean info =loginService.login(cookieEmail, cookiePassword);
    		System.out.println(info);
    		if(!info)
    		{	
    			return "NotAuthenticated";
    		}
    		System.out.println("execute come on");
        	return "LoggedIn";
        }
	}



	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}


	
}



	
    
    
