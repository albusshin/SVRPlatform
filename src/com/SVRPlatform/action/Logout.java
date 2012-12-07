package com.SVRPlatform.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.tomcat.util.http.Cookies;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport implements ServletRequestAware,			//Logout					
ServletResponseAware{
	
	/**
	 * 
	 */

	private HttpServletResponse response;
	private HttpServletRequest request;
	private static final long serialVersionUID = 1L;

	public String execute()
	{
	
		ActionContext actctx = ActionContext.getContext();
//		actctx.getSession().clear();
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie:cookies){
//			cookie.setMaxAge(0);
//			cookie.setPath("/");
//			response.addCookie(cookie);
//		}
		actctx.getSession().put("email", "tourist");
		actctx.getSession().put("password", "tourist");
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
}
