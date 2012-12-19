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

public class DisplaySolutions extends ActionSupport implements ServletRequestAware,
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

	public String getStrStat() {
		return strStat;
	}

	public void setStrStat(String strStat) {
		this.strStat = strStat;
	}

	private int nowPage;
	List<String> contents, datetimes, emails, realnames, creditss,
			solutionScores, isBests;

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

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

	public List<String> getDatetimes() {
		return datetimes;
	}

	public void setDatetimes(List<String> datetimes) {
		this.datetimes = datetimes;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getRealnames() {
		return realnames;
	}

	public void setRealnames(List<String> realnames) {
		this.realnames = realnames;
	}

	public List<String> getCreditss() {
		return creditss;
	}

	public void setCreditss(List<String> creditss) {
		this.creditss = creditss;
	}

	public List<String> getSolutionScores() {
		return solutionScores;
	}

	public void setSolutionScores(List<String> solutionScores) {
		this.solutionScores = solutionScores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SolutionsDisplayService getSolutionsDisplayService() {
		return solutionsDisplayService;
	}

	public List<String> getIsBests() {
		return isBests;
	}

	public void setIsBests(List<String> isBests) {
		this.isBests = isBests;
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
		System.out.println("DisplaySolutions execute()");
		System.out.println("strBugNumber" + strBugNumber);
		System.out.println("strNowPage == " + strNowPage);
		SolutionData officialSolution = null;
		nowPage = Integer.parseInt(strNowPage);
		if (nowPage == 1) {
			officialSolution = solutionsDisplayService
					.officialSolutionDisplayService(strBugNumber);
			
			//if no official solution exists
			if (officialSolution == null) {
				officialSolution = new SolutionData();
				officialSolution.setBest(false);
				officialSolution.setContent("Not available.");
				officialSolution.setCredits(0);
				officialSolution.setDatetime("");
				officialSolution.setDown(0);
				officialSolution.setEmail("");
				officialSolution.setRealname("");
				officialSolution.setUp(0);
			}
			 
		}
		BugSolutionsData theData = solutionsDisplayService
				.solutionsDisplayService(strBugNumber, nowPage, 5);
		List<SolutionData> solutionData = theData.getSolutionsData();
		contents = new LinkedList<String>();
		creditss = new LinkedList<String>();
		datetimes = new LinkedList<String>();
		emails = new LinkedList<String>();
		realnames = new LinkedList<String>();
		solutionScores = new LinkedList<String>();
		isBests = new LinkedList<String>();
		for (SolutionData s : solutionData) {
			contents.add(s.getContent());
			creditss.add(s.getCredits() + "");
			datetimes.add(s.getDatetime());
			emails.add(s.getEmail());
			realnames.add(s.getRealname());
			solutionScores.add((s.getUp() - s.getDown()) + "");
			if (s.isBest()) {
				isBests.add("true");
			} else
				isBests.add("false");
		}
		strSolutionsAmount = theData.getSolutionCount() + "";
		System.out.println("strSolutionsAmount == " + strSolutionsAmount);
		System.out.println("before return success");
		request.setAttribute("officialSolution", officialSolution);

		return Constants.SUCCESS;
	}
}
