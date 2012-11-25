package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.SVRPlatform.util.CheckCookie;
import com.SVRPlatform.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class ToSubmitBug extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private HttpServletRequest request;  
    public void setLoginService(LoginService loginService) {
	}
	
	public String execute()
	{
		System.out.println(CheckCookie.check(request));
		return CheckCookie.check(request);
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
}

