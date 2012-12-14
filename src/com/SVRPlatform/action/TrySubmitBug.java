package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.SVRPlatform.Utils.*;
import com.SVRPlatform.constants.*;

public class TrySubmitBug extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6564202418176511129L;
	HttpServletRequest request;
	HttpServletResponse response;
	public String execute() {
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.FAIL;
		}
		return Constants.SUCCESS;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

}
