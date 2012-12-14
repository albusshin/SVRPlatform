package com.SVRPlatform.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private HttpServletResponse response;  
	private String cookieEmail = null;	
	private String cookiePassword = null;
	private String emailInSession = null;
	private String passwordInSession = null;
	private LoginService loginService;
	
	
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
		this.response = arg0;
	}
	

	
	public String execute()
	{
		System.out.println("In Index");	
		HttpSession session = request.getSession();
		emailInSession = (String) session.getAttribute("email");
		passwordInSession = (String) session.getAttribute("password");
		System.out.println("emailInSession == "+emailInSession );	
		System.out.println("passwordInSession == "+passwordInSession );
		boolean sessionCanLogin = this.loginService.login(cookieEmail, cookiePassword);
		if (sessionCanLogin){
			System.out.println("Session can log in");
			return "LoggedIn";
		}
		// ELSE
//		if(emailInSession==null){
//	    	session.setMaxInactiveInterval(60 * 60 * 24 * 7);								//store in new session as tourist ,modify later 
//			session.setAttribute("email", "tourist");
//			session.setAttribute("password", "tourist");
//		}																//Totally uselesssssss code. What the fuck were you possibly thinking.
		Cookie[] cookies = request.getCookies();		
		System.out.println("getcookie");
        if (cookies != null) {																		//get email and password in cookie 
        	System.out.println("cookies is not null");
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
        {																							//cookie exists
            System.out.println("cookieEmail == " + cookieEmail);
            System.out.println("cookiePassword == " + cookiePassword);
            System.out.println("before loginService.login()");
            System.out.println("this.loginService == " + this.loginService);
            boolean cookieCanLogin = this.loginService.login(cookieEmail, cookiePassword); 
            System.out.println("after loginService.login()");
            if(!cookieCanLogin)
    		{
            	com.SVRPlatform.Utils.UserHandlers.clearSessionAndCookies(request, response);
            	//return "NotAuthenticated"; 									//There should be no things such as "Not authenticated".
            	return "CookieNotFound";										//Just return a cookieNotFound is enough.
            }
            else{
            	System.out.println("valid user infomation");
                session.setAttribute("email", cookieEmail);
                session.setAttribute("password", cookiePassword);
                return "LoggedIn";																	//Valid email and password
            }
	
        }
	}


	
}
