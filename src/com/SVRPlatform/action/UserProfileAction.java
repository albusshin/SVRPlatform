package com.SVRPlatform.action;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.UserData;
import com.SVRPlatform.service.UserProfileService;
import com.opensymphony.xwork2.ActionSupport;

public class UserProfileAction extends ActionSupport implements
		ServletRequestAware, // sign up~ register
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
	String strRegisterDate;
	String strSeen;
	String strMemberFor;
	String strLastSeenDate;
	String strProfileViews;
	String strCredits;
	String strBugUploads;
	String strSolutions;
	String strComments;

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	UserData userData = new UserData();
	UserProfileService userProfileService;

	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public String getStrRealName() {
		return strRealName;
	}

	public void setStrRealName(String strRealName) {
		this.strRealName = strRealName;
	}

	public String getStrWebsite() {
		return strWebsite;
	}

	public void setStrWebsite(String strWebsite) {
		this.strWebsite = strWebsite;
	}

	public String getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrAge() {
		return strAge;
	}

	public void setStrAge(String strAge) {
		this.strAge = strAge;
	}

	public String getStrRegisterDate() {
		return strRegisterDate;
	}

	public void setStrRegisterDate(String strRegisterDate) {
		this.strRegisterDate = strRegisterDate;
	}

	public String getStrSeen() {
		return strSeen;
	}

	public void setStrSeen(String strSeen) {
		this.strSeen = strSeen;
	}

	public String getStrMemberFor() {
		return strMemberFor;
	}

	public void setStrMemberFor(String strMemberFor) {
		this.strMemberFor = strMemberFor;
	}

	public String getStrLastSeenDate() {
		return strLastSeenDate;
	}

	public void setStrLastSeenDate(String strLastSeenDate) {
		this.strLastSeenDate = strLastSeenDate;
	}

	public String getStrProfileViews() {
		return strProfileViews;
	}

	public void setStrProfileViews(String strProfileViews) {
		this.strProfileViews = strProfileViews;
	}

	public String getStrCredits() {
		return strCredits;
	}

	public void setStrCredits(String strCredits) {
		this.strCredits = strCredits;
	}

	public String getStrBugUploads() {
		return strBugUploads;
	}

	public void setStrBugUploads(String strBugUploads) {
		this.strBugUploads = strBugUploads;
	}

	public String getStrSolutions() {
		return strSolutions;
	}

	public void setStrSolutions(String strSolutions) {
		this.strSolutions = strSolutions;
	}

	public String getStrComments() {
		return strComments;
	}

	public void setStrComments(String strComments) {
		this.strComments = strComments;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public String display() {
		System.out.println("strEmail == " + strEmail);
		userData = userProfileService.displayUserProfile(strEmail);
		strWebsite = userData.getWebsite();
		strProfileViews = userData.getProfileViews() + "";
		strAge = userData.getAge() + "";
		strLocation = userData.getLocation();
		strCredits = userData.getCredit() + "";
		strMemberFor = userData.getMemberFor();
		strRegisterDate = userData.getRegisterDate();
		strRealName = userData.getRealName();
		strSeen = userData.getSeen();
		strLastSeenDate = userData.getLastSeenDate();
		strBugUploads = null;
		strSolutions = null;
		strComments = null;
		return Constants.SUCCESS;
	}

	public String submit() {
		Map<String, String> map = userProfileService.submitUserProfile(VerifyUser.getNowUserID(request),
				strWebsite, strLocation, strRealName,
				(Integer.parseInt(strAge)));
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
