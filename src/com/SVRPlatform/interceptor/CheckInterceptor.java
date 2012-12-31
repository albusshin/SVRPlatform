package com.SVRPlatform.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.Utils.UserHandlers;
import com.SVRPlatform.service.LoginService;
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
	LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

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

		//check whether email & password are valid or not
		
		//get request in intercepter
		ActionContext actionContext = invocation.getInvocationContext();
        request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);  
        //get email & password in session
		ActionContext act=ActionContext.getContext();
		if (emailInSession != null)
			return invocation.invoke();
		//get email & password in cookie 
		HttpServletResponse response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);
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
		//System.out.println("emailInSession="+emailInSession);
		//System.out.println("passwordInSession="+passwordInSession);
		//System.out.println("cookieEmail="+cookieEmail);
		//System.out.println("cookieHash="+cookieHash);
		
//		if (!emailInSession.equals("tourist") && !passwordInSession.equals("tourist"))
		if(cookieEmail != null && cookieHash != null){
			System.out.println("cookieEmail == " + cookieEmail);
			System.out.println("cookieHash == " + cookieHash);
			Map<String, ?> info=this.loginService.cookieLogin(cookieEmail, cookieHash);
			if ((Boolean) info.get("success")){
				request.getSession().setMaxInactiveInterval(60 * 60 * 3);				//Session 3 hours is enough.
				request.getSession().setAttribute("email", cookieEmail);
				request.getSession().setAttribute("userID", (Integer)info.get("userID"));
				request.getSession().setAttribute("credit", (Integer)info.get("credit"));
				request.getSession().setAttribute("realname", (String)info.get("realname"));
				
				System.out.println("cookie login success from CheckInterceptor");
				/**
				 * ¿Óµù¡£
				 */
				cookieEmail = null;
				cookieHash = null;
				emailInSession = null;
				return invocation.invoke();
			}
			else {
				UserHandlers.clearSessionAndCookies(request, response);
				cookieEmail = null;
				cookieHash = null;
				emailInSession = null;
				return "FailToSignIn";
			}
		}
		return invocation.invoke();
	}


}
