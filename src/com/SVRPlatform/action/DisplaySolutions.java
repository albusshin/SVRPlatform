package com.SVRPlatform.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.BugSolutionsData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.service.SolutionsDisplayService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplaySolutions extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7183770018450142124L;
	HttpServletRequest request;
	HttpServletResponse response;
	SolutionsDisplayService solutionsDisplayService;
	private String strBugNumber;
	private String strSolutionsAmount;
	private String strNowPage;
	private String strStat;
	private boolean isAlreadyGiven;
	private String strIsAlreadyGiven;
	public String getStrIsAlreadyGiven() {
		return strIsAlreadyGiven;
	}

	public void setStrIsAlreadyGiven(String strIsAlreadyGiven) {
		this.strIsAlreadyGiven = strIsAlreadyGiven;
	}

	public boolean isAlreadyGiven() {
		return isAlreadyGiven;
	}

	public void setAlreadyGiven(boolean isAlreadyGiven) {
		this.isAlreadyGiven = isAlreadyGiven;
	}

	List<SolutionData> solutionData;

	public List<SolutionData> getSolutionData() {
		return solutionData;
	}

	public void setSolutionData(List<SolutionData> solutionData) {
		this.solutionData = solutionData;
	}

	public String getStrStat() {
		return strStat;
	}

	public void setStrStat(String strStat) {
		this.strStat = strStat;
	}

	private int nowPage;

	// List<String> contents, datetimes, emails, realnames, creditss,
	// solutionScores, isBests;

	public String getStrBugNumber() {
		return strBugNumber;
	}

	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}

	public String getStrSolutionsAmount() {
		return strSolutionsAmount;
	}

	public void setStrSolutionsAmount(String strSolutionsAmount) {
		this.strSolutionsAmount = strSolutionsAmount;
	}

	public String getStrNowPage() {
		return strNowPage;
	}

	public void setStrNowPage(String strNowPage) {
		this.strNowPage = strNowPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SolutionsDisplayService getSolutionsDisplayService() {
		return solutionsDisplayService;
	}

	public void setSolutionsDisplayService(
			SolutionsDisplayService solutionsDisplayService) {
		this.solutionsDisplayService = solutionsDisplayService;
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

	public String execute() {
		//System.out.println("DisplaySolutions execute()");
		//System.out.println("strBugNumber" + strBugNumber);
		//System.out.println("strNowPage == " + strNowPage);
		SolutionData officialSolution = null;
		nowPage = Integer.parseInt(strNowPage);
		if (nowPage < 1) return "error";
		int userID = VerifyUser.getNowUserID(request);
		if (nowPage == 1) {
			officialSolution = solutionsDisplayService
					.officialSolutionDisplayService(userID, strBugNumber);
			System.out.println(userID);
			System.out.println(strBugNumber);

			// if no official solution exists
			// 我改变主意了，所以下面这个注释掉。。
			// if (officialSolution == null) {
			// officialSolution = new SolutionData();
			// officialSolution.setBest(false);
			// officialSolution.setContent("Not available.");
			// officialSolution.setCredits(0);
			// officialSolution.setDatetime("");
			// officialSolution.setDown(0);
			// officialSolution.setEmail("");
			// officialSolution.setRealname("");
			// officialSolution.setUp(0);
			// }

		}
		
		BugSolutionsData theData = solutionsDisplayService
				.solutionsDisplayService(userID, strBugNumber, nowPage, 5);
		solutionData = theData.getSolutionsData();
		strSolutionsAmount = theData.getSolutionCount() + "";
		isAlreadyGiven = solutionsDisplayService.ifAlreadyGiven(userID, strBugNumber);
		if (isAlreadyGiven){
			strIsAlreadyGiven = "true";
		}
		else{
			strIsAlreadyGiven = "false";
		}
		//System.out.println("strSolutionsAmount == " + strSolutionsAmount);
		//System.out.println("before return success");
		request.setAttribute("officialSolution", officialSolution);
		if(request.getAttribute("message")==null)
			request.setAttribute("message", null);

		return Constants.SUCCESS;
	}
}
