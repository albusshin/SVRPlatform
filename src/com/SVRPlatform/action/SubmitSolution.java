package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.SolutionSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitSolution extends ActionSupport implements ServletRequestAware
{
	/*
	 * Get solution text from page,check it is null or not.
	 */   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strBugNumber;
	private String strNowPage;
	private String solutionssubmittext;
	private String strStat;
	private SolutionSubmitService solutionSubmitService;
	private HttpServletRequest request;
	private String message;
	
	public String getStrBugNumber() {
		return strBugNumber;
	}

	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}

	public String getStrNowPage() {
		return strNowPage;
	}

	public void setStrNowPage(String strNowPage) {
		this.strNowPage = strNowPage;
	}

	public String getSolutionssubmittext() {
		return solutionssubmittext;
	}

	public void setSolutionssubmittext(String solutionssubmittext) {
		this.solutionssubmittext = solutionssubmittext;
	}

	public String getStrStat() {
		return strStat;
	}

	public void setStrStat(String strStat) {
		this.strStat = strStat;
	}

	public SolutionSubmitService getSolutionSubmitService() {
		return solutionSubmitService;
	}

	public void setSolutionSubmitService(SolutionSubmitService solutionSubmitService) {
		this.solutionSubmitService = solutionSubmitService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute(){
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}
		strNowPage = "1";
		String email = (String) request.getSession().getAttribute("email");
		Map<String, String> map = solutionSubmitService.solutionSubmit(strBugNumber, email, solutionssubmittext);
		if (map.get("status").equals("fail")) {
			message = "There's something wrong with your inputs, please check:\n";
			
			if (!(map.get("content").equals("OK"))){
				message += "Please input your description about the bug. ";
			}
			strStat = "wrong";
			return Constants.FAIL;
		}
		else {
			return Constants.SUCCESS;
		}
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}	
}
