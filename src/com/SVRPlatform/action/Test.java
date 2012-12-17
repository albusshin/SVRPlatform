package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

class Test extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4942570708245884072L;

	public String execute() {
		System.out.println("DisplaySolutions execute()");
		
		return Constants.SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
}
