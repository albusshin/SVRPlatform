package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayBug extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String strBugNumber;
	private String strBugDigest;
	private String strDate;
	private String strScore;
	private String strUsabilityImpact;
	private String strDataImpact;
	private String strPrivacyImpact;
	private String strAvailabilityImpact;
	private String strFrequency;
	private String strScreenshotPath;
	private String strBugDescription;
	private String strCompany;
	private String strSoftware;
	private String strVersion;
	private String strLanguage;
	private String strBestSolutin;
	private String strOfficialSolution;
	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public String getStrBugDigest() {
		return strBugDigest;
	}
	public String getStrDate() {
		return strDate;
	}
	public String getStrScore() {
		return strScore;
	}
	public String getStrUsabilityImpact() {
		return strUsabilityImpact;
	}
	public String getStrDataImpact() {
		return strDataImpact;
	}
	public String getStrPrivacyImpact() {
		return strPrivacyImpact;
	}
	public String getStrAvailabilityImpact() {
		return strAvailabilityImpact;
	}
	public String getStrFrequency() {
		return strFrequency;
	}
	public String getStrScreenshotPath() {
		return strScreenshotPath;
	}
	public String getStrBugDescription() {
		return strBugDescription;
	}
	public String getStrCompany() {
		return strCompany;
	}
	public String getStrSoftware() {
		return strSoftware;
	}
	public String getStrVersion() {
		return strVersion;
	}
	public String getStrLanguage() {
		return strLanguage;
	}
	public String getStrBestSolutin() {
		return strBestSolutin;
	}
	public String getStrOfficialSolution() {
		return strOfficialSolution;
	}
	
	public String getStrBugNumber() {
		return strBugNumber;
	}
	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
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
