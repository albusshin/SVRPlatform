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
	private HttpServletRequest request;  
	private String cookieEmail = null;	
	private String cookiePassword = null;
	private LoginService loginService;

	
	public String execute()
	{
		System.out.println("In Index");				
		
    	request.getSession().setMaxInactiveInterval(60 * 60 * 24 * 7);			//store in new session as tourist ,modify later 
		request.getSession().setAttribute("email", "tourist");
		request.getSession().setAttribute("password", "tourist");
		
		Cookie[] cookies = request.getCookies();		
		System.out.println("getcookie");
        if (cookies != null) {												//get email and password in cookie 
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
       

        if ((cookieEmail== null)&&(cookiePassword==null)) {											//cookie does not exist ~ tourist
        	return "CookieNotFound"; 
        }
        else							
        {																//cookie exists
            System.out.println(cookieEmail);
            System.out.println(cookiePassword);
            boolean info = this.loginService.login(cookieEmail, cookiePassword); 
            if(!info)
    		{	
            	return "NotAuthenticated"; 								//Invalid email and password,	need login
            }
            else{
            	request.getSession().setAttribute("email", cookieEmail);
            	request.getSession().setAttribute("password", cookiePassword);
            	return "LoggedIn";											//Valid email and password
            }
	
        }
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}


	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
