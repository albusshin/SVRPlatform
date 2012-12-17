package com.SVRPlatform.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.BugSolutionsData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.service.SolutionsDisplayService;
import com.opensymphony.xwork2.ActionSupport;

class DisplaySolutions extends ActionSupport implements ServletRequestAware,
ServletResponseAware {

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
	private int nowPage;
	List<String> contents, datetimes, emails, realnames, creditss, solutionScores;
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
	
	public String execute(){
		SolutionData officialSolution = null;
		System.out.println("DisplaySolutions execute()");
		System.out.println("strBugNumber" + strBugNumber);
		System.out.println("strNowPage == " + strNowPage);
		nowPage = Integer.parseInt(strNowPage);
		if (nowPage == 1){
			officialSolution = solutionsDisplayService.officialSolutionDisplayService(strBugNumber);
		}
		BugSolutionsData theData = solutionsDisplayService.solutionsDisplayService(strBugNumber, nowPage, 5);
		List<SolutionData> solutionData = theData.getSolutionsData();
		contents = new LinkedList<String>();
		creditss = new LinkedList<String>();
		datetimes = new LinkedList<String>();
		emails = new LinkedList<String>();
		realnames = new LinkedList<String>();
		solutionScores = new LinkedList<String>();
		for (SolutionData s: solutionData){
			contents.add(s.getContent());
			creditss.add(s.getCredits()+"");
			datetimes.add(s.getDatetime());
			emails.add(s.getEmail());
			realnames.add(s.getRealname());
			solutionScores.add((s.getUp() - s.getDown())+"");
		}
		strSolutionsAmount = theData.getSolutionCount() + "";
		System.out.println("strSolutionsAmount == " + strSolutionsAmount);
		System.out.println("before return success");

		
		return Constants.SUCCESS;
	}
}
