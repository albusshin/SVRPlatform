package com.SVRPlatform.action;

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
	public void setCommentsDisplayService(
			CommentsDisplayService commentsDisplayService) {
		this.commentsDisplayService = commentsDisplayService;
	}
	private String strBugNumber;
	private String strCommentsAmount;
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
		BugCommentsData theData = commentsDisplayService.commentsDispalyService(strBugNumber, 1, 5);
		System.out.println("After theData initialization");
		List<CommentData> commentData = theData.getCommentsData();
		for (CommentData c: commentData){
			contents.add(c.getContent());
			creditss.add(c.getCredits()+"");
			datetimes.add(c.getDatetime());
			emails.add(c.getEmail());
			realnames.add(c.getRealname());
			titles.add(c.getTitle());
		}
		strCommentsAmount = commentData.size() + "";
		return Constants.SUCCESS;
	}

}
