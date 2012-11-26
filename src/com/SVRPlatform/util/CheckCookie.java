package com.SVRPlatform.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.SVRPlatform.service.LoginService;

public class CheckCookie {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static String check(HttpServletRequest request,LoginService loginService)
	{
		String cookieEmail = null;
		String cookiePassword = null;
		Cookie[] cookies = null;	
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
            }
          }
        }
       

        if ((cookieEmail== null)&&(cookiePassword==null)) {
          return "CookieNotFound";
        }
        else
        {
            System.out.println(cookieEmail);
            System.out.println(cookiePassword);
    		boolean info =loginService.login(cookieEmail, cookiePassword);
    		System.out.println("---------------------");
    		System.out.println(info);
    		if(!info)
    		{	
    			return "NotAuthenticated";
    		}
    		System.out.println("execute come on");
        	return "LoggedIn";
        }
	}




	
}



	
    
    
