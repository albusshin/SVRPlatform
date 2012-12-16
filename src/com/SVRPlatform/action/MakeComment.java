package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.CommentSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class MakeComment extends ActionSupport implements ServletRequestAware
{
	/*
	 * Get title and text from page,check it is null or not.
	 */
	private static final long serialVersionUID = 8398439497316195283L;
	private String strBugNumber;
	private String strNowPage;
	private String commentssubmittext;
	private String commentssubmittitle;
	private String message;
	private CommentSubmitService commentSubmitService;
	private HttpServletRequest request;
	


	public String getStrNowPage() {
		return strNowPage;
	}
	
	public void setStrNowPage(String strNowPage) {
		this.strNowPage = strNowPage;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
	public void setCommentSubmitService(CommentSubmitService commentSubmitService) {
		this.commentSubmitService = commentSubmitService;
	}

	public String getStrBugNumber() {
		return strBugNumber;
	}
	
	public void setStrBugNumber(String strBugNumber) {
		this.strBugNumber = strBugNumber;
	}
	
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

	public String execute() {
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
		String email = (String) request.getSession().getAttribute("email");
		System.out.println("strBugNumber:"+strBugNumber);
		System.out.println("email: "+email);
		Map<String, String> map = commentSubmitService.commentSubmit(strBugNumber, email, commentssubmittitle, commentssubmittext);
		
		System.out.println("after service");
		if (map.get("status").equals("fail")) {
			message = "There's something wrong with your inputs, please check:\n";
			if ((!map.get("title").equals("OK"))){
				message += "Please input the digest of the bug information";
			}
			if (!(map.get("content").equals("OK"))){
				message += "Please input your description about the bug";
			}
			return Constants.FAIL;
		}
		else {
			strNowPage = "1";
			return Constants.SUCCESS;
		}
	}
}
