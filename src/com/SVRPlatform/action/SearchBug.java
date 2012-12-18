package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class SearchBug extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	String strBugNumber;
	public String getStrBugNumber() {
		return strBugNumber;
	}

	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public String execute(){
		System.out.println("Search Bug Execute");
		System.out.println("Now StrbugNumber == " + strBugNumber);
		return Constants.SUCCESS;
	}
}
