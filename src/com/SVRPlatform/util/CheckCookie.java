package com.SVRPlatform.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;

public class CheckCookie {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static String check(HttpServletRequest request)								//For redirection Check email & password  
	{
		String cookieEmail = null;	
		String cookiePassword = null;
		String sessionEmail = null;
		String sessionPassword = null;
		boolean info = false;
		
		
		System.out.println("checking");
		Cookie[] cookies = request.getCookies();		
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

            sessionEmail = (String) request.getAttribute("email");
            sessionPassword = (String) request.getAttribute("password");
            
            System.out.println(sessionEmail);
            System.out.println(sessionPassword);
            
            if(sessionEmail.equals(cookieEmail) && sessionPassword.equals(cookiePassword))			
            	info=true;
            
    		if(!info)
    		{	
    			return "NotAuthenticated";
    		}
    		System.out.println("execute come on");
        	return "LoggedIn";
        }
	}




	
}



	
    
    
