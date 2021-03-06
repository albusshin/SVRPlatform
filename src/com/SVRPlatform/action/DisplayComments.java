package com.SVRPlatform.action;

import java.util.List;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.BugCommentsData;
import com.SVRPlatform.data.CommentData;
import com.SVRPlatform.service.CommentsDisplayService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayComments extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentsDisplayService commentsDisplayService;
	private String strBugNumber;
	private String strCommentsAmount;
	private String strNowPage;
	private String strStat;
	List<CommentData> commentData;

	public List<CommentData> getCommentData() {
		return commentData;
	}

	public void setCommentData(List<CommentData> commentData) {
		this.commentData = commentData;
	}

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

	public String execute() {
		//System.out.println("DisplayComments execute()");
		//System.out.println("strBugNumber" + strBugNumber);
		//System.out.println("strNowPage == " + strNowPage);
		nowPage = Integer.parseInt(strNowPage);
		if (nowPage < 1) return "error";
		BugCommentsData theData = commentsDisplayService
				.commentsDispalyService(strBugNumber, nowPage, 5);
		commentData = theData.getCommentsData();
		strCommentsAmount = theData.getCommentCount() + "";
		//System.out.println("strCommentsAmount == " + strCommentsAmount);
		//System.out.println("before return success");

		return Constants.SUCCESS;
	}

}
