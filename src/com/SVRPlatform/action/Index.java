package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.SVRPlatform.service.LoginService;
import com.SVRPlatform.util.CheckCookie;
import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private HttpServletRequest request;  
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public String execute()
	{
		System.out.println("InINDEX");
		System.out.println(CheckCookie.check(request,loginService));
		return CheckCookie.check(request,loginService);
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
