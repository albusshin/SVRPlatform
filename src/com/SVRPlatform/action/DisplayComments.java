package com.SVRPlatform.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.BugCommentsData;
import com.SVRPlatform.data.CommentData;
import com.SVRPlatform.service.CommentsDisplayService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayComments extends ActionSupport implements ServletRequestAware,
ServletResponseAware {
	/**
	 * 
	 */
	private CommentsDisplayService commentsDisplayService;
	private String strBugNumber;
	private String strCommentsAmount;
	private String strNowPage;
	private String strStat;
	

	public void setCommentsDisplayService(
			CommentsDisplayService commentsDisplayService) {
		this.commentsDisplayService = commentsDisplayService;
	}
	
	public String getStrStat() {
		return strStat;
	}

	public void setStrStat(String strStat) {
		this.strStat = strStat;
	}
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStrNowPage() {
		return strNowPage;
	}

	public void setStrNowPage(String strNowPage) {
		this.strNowPage = strNowPage;
	}
	private int nowPage;
	public String getStrCommentsAmount() {
		return strCommentsAmount;
	}

	public String getStrBugNumber() {
		return strBugNumber;
	}

	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}
	private static final long serialVersionUID = 7189405925477674686L;
	private HttpServletResponse response;
	private HttpServletRequest request;
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
	List<String> contents, datetimes, emails, realnames, titles, creditss;
	public List<String> getContents() {
		return contents;
	}

	public List<String> getDatetimes() {
		return datetimes;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<String> getRealnames() {
		return realnames;
	}

	public List<String> getTitles() {
		return titles;
	}

	public List<String> getCreditss() {
		return creditss;
	}

	public String execute(){
		System.out.println("DisplayComments execute()");
		System.out.println("strBugNumber" + strBugNumber);
		System.out.println("strNowPage == " + strNowPage);
		nowPage = Integer.parseInt(strNowPage);
		BugCommentsData theData = commentsDisplayService.commentsDispalyService(strBugNumber, nowPage, 5);
		List<CommentData> commentData = theData.getCommentsData();
		contents = new LinkedList<String>();
		creditss = new LinkedList<String>();
		datetimes = new LinkedList<String>();
		emails = new LinkedList<String>();
		realnames = new LinkedList<String>();
		titles = new LinkedList<String>();
		for (CommentData c: commentData){
			contents.add(c.getContent());
			creditss.add(c.getCredits()+"");
			datetimes.add(c.getDatetime());
			emails.add(c.getEmail());
			realnames.add(c.getRealname());
			titles.add(c.getTitle());
		}
		strCommentsAmount = theData.getCommentCount() + "";
		System.out.println("strCommentsAmount == " + strCommentsAmount);
		System.out.println("before return success");

		
		return Constants.SUCCESS;
	}

}
