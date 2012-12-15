package com.SVRPlatform.action;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class MakeComment extends ActionSupport
{
	/*
	 * Get title and text from page,check it is null or not.
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8398439497316195283L;
	private String strBugNumber;
	public String getStrBugNumber() {
		return strBugNumber;
	}

	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}

	public String commentssubmittext;
	public String commentssubmittitle;
	public String message;
	
	public String getCommentssubmittext() {
		return commentssubmittext;
	}

	public void setCommentssubmittext(String commentssubmittext) {
		this.commentssubmittext = commentssubmittext;
	}

	public String getCommentssubmittitle() {
		return commentssubmittitle;
	}

	public void setCommentssubmittitle(String commentssubmittitle) {
		this.commentssubmittitle = commentssubmittitle;
	}

	public String execute()
	{
		System.out.println( "comment title:" + commentssubmittitle );
		System.out.println( "comment text:" + commentssubmittext );
		
	 /*
	  *   wait for the function supplied by Qingwei to check whether title and text are valid or not.
	  *	 
	  *   message=this.MakeCommentService.makeComment(commentssubmittitle,commentssubmittext); 
	  *   if(message.equal("CommentValid")) return Constants.SUCCESS;
	  *   else return Constants.FAIL;
	  *
	  */		
	    return Constants.SUCCESS;
		
	}
}
