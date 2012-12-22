package com.SVRPlatform.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckInterceptor implements Interceptor,ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request; 
	private String emailInSession = null;
	//private Object passwordInSession = null;
	private String cookieEmail = null;
	private String cookieHash = null;
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		//get request in intercepter
		ActionContext actionContext = invocation.getInvocationContext();     
        request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);   
        
        //get email & password in session
		ActionContext act=ActionContext.getContext();
		emailInSession = (String) act.getSession().get("email");
		//passwordInSession = act.getSession().get("password");  
		
		//get email & password in cookie 
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {									
        	for (int i = 0; i < cookies.length; i++) {									
            System.out.println(cookies[i].getName() +"/////");
            System.out.println(cookies[i].getValue() );
        	if (cookies[i].getName().equals("email")) {
        		cookieEmail= cookies[i].getValue();
            }
            if (cookies[i].getName().equals("cookiehash")) {
            	cookieHash = cookies[i].getValue();
            }
          }
        }
		System.out.println("emailInSession="+emailInSession);
		//System.out.println("passwordInSession="+passwordInSession);
		System.out.println("cookieEmail="+cookieEmail);
		System.out.println("cookieHash="+cookieHash);
		
//		if (!emailInSession.equals("tourist") && !passwordInSession.equals("tourist"))
		if (emailInSession != null)
			return invocation.invoke();
		else if(cookieEmail != null && cookieHash != null)
			return invocation.invoke();
		else return"FailToSignIn";
	}


}
