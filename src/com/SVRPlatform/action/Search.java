package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	String strNumber;
	public String getStrNumber() {
		return strNumber;
	}

	public void setStrNumber(String strNumber) {
		this.strNumber = strNumber;
	}

	String strBugNumber;
	String strVulnerabilityNumber;
	public String getStrVulnerabilityNumber() {
		return strVulnerabilityNumber;
	}

	public void setStrVulnerabilityNumber(String strVulnerabilityNumber) {
		this.strVulnerabilityNumber = strVulnerabilityNumber;
	}

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
		System.out.println("Search Execute");
		System.out.println("Now StrNumber == " + strNumber);
		System.out.println("strBugNumber.substring(0, 3) == " + strNumber.substring(0, 3));
		if (strNumber.substring(0, 4).equals("SVRB")){
			strBugNumber = strNumber;
			return Constants.BUG;
		}
		else if (strNumber.substring(0, 4).equals("SVRV")){
			strVulnerabilityNumber = strNumber;
			return Constants.VULNERABILITY;
		}
		return Constants.SUCCESS;
	}
}
