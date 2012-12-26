package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.UserData;
import com.SVRPlatform.service.UserProfileService;
import com.opensymphony.xwork2.ActionSupport;

public class UserProfileDisplayAction extends ActionSupport implements ServletRequestAware,		//sign up~ register
ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5674802494631808956L;
	HttpServletResponse response;
	HttpServletRequest request;
	String strRealName;
	String strEmail;
	String strWebsite;
	String strLocation;
	String strAge;
	String strDate;
	String strSeen;
	String strRoughlySeen;
	String strProfileViews;
	String strCredits;
	String strBugUploads;
	String strSolutions;
	String strComments;
	UserData userData = new UserData();
	UserProfileService userProfileService;
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStrRealName() {
		return strRealName;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public String getStrWebsite() {
		return strWebsite;
	}

	public String getStrLocation() {
		return strLocation;
	}

	public String getStrAge() {
		return strAge;
	}

	public String getStrDate() {
		return strDate;
	}

	public String getStrSeen() {
		return strSeen;
	}

	public String getStrRoughlySeen() {
		return strRoughlySeen;
	}

	public String getStrProfileViews() {
		return strProfileViews;
	}

	public String getStrCredits() {
		return strCredits;
	}

	public String getStrBugUploads() {
		return strBugUploads;
	}

	public String getStrSolutions() {
		return strSolutions;
	}

	public String getStrComments() {
		return strComments;
	}

	public String execute(){
		return Constants.SUCCESS;
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

}
