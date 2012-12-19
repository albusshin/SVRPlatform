package com.SVRPlatform.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.CommentSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class MakeComment extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 8398439497316195283L;
	private String strBugNumber;
	private String strNowPage;
	private String commentssubmittext;
	private String commentssubmittitle;
	private String message;
	private String strStat;
	private CommentSubmitService commentSubmitService;
	private HttpServletRequest request;
	

	public String getStrStat() {
		return strStat;
	}
	public void setStrStat(String strStat) {
		this.strStat = strStat;
	}

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
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}
		strNowPage = "1";
		String email = (String) request.getSession().getAttribute("email");
		Map<String, String> map = commentSubmitService.commentSubmit(strBugNumber, email, commentssubmittitle, commentssubmittext);
		if (map.get("status").equals("fail")) {
			message = "There's something wrong with your inputs, please check:\n";
			if ((!map.get("title").equals("OK"))){
				message += "Please input the digest of the comment. ";
			}
			if (!(map.get("content").equals("OK"))){
				message += "Please input your description about the comment. ";
			}
			strStat = "wrong";
			return Constants.FAIL;
		}
		else {
			return Constants.SUCCESS;
		}
	}
}