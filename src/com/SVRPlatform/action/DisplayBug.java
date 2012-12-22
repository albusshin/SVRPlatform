package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.BugInfoDisplayService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayBug extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String strBestSolution;
	private String strOfficialSolution;
	private BugInfoDisplayService bugInfoDisplayService;
	public void setBugInfoDisplayService(BugInfoDisplayService bugInfoDisplayService) {
		this.bugInfoDisplayService = bugInfoDisplayService;
	}
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
	public String getStrBestSolution() {
		return strBestSolution;
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
		//System.out.println("DisplayBug.java execute()");
		//System.out.println("firstly, the strBugNumber == " + strBugNumber);
		Map<String, String> theMap = bugInfoDisplayService.bugInfoDisplay(strBugNumber);
		if (theMap.get("status").equals("fail")){
			//System.out.println("theMap.get('status') == fail");
			return Constants.FAIL;
		}
		//System.out.println("theMap.get('status') == success");
		strBugDigest = theMap.get("strBugDigest");
		strDate = theMap.get("strDate");
		strScore = theMap.get("strScore");
		strUsabilityImpact = theMap.get("strUsabilityImpact");
		strDataImpact = theMap.get("strDataImpact");
		strPrivacyImpact = theMap.get("strPrivacyImpact");
		strAvailabilityImpact = theMap.get("strAvailabilityImpact");
		strFrequency = theMap.get("strFrequency");
		strScreenshotPath = theMap.get("strScreenshotPath");
		strBugDescription = theMap.get("strBugDescription");
		strCompany = theMap.get("strCompany");
		strSoftware = theMap.get("strSoftware");
		strVersion = theMap.get("strVersion");
		strLanguage = theMap.get("strLanguage");
		strBestSolution = theMap.get("strBestSolution");
		strOfficialSolution = theMap.get("strOfficialSolution");
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
