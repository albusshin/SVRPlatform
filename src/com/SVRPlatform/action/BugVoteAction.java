package com.SVRPlatform.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.SolutionVoteService;
import com.opensymphony.xwork2.ActionSupport;

public class BugVoteAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private int bugId;
	private BugVoteService bugVoteService;
	private InputStream inputStream;
	private HttpServletRequest request;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public void setBugVoteService(BugVoteService bugVoteService) {
		this.bugVoteService = bugVoteService;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
	public String voteUp(){
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}
		String message = bugVoteService.voteUp(bugId, nowUser);
		if (message.equals(Constants.SUCCESS))
			inputStream = new ByteArrayInputStream(Constants.SUCCESS.getBytes());
		else if (message.equals(Constants.ALREADYVOTED))
			inputStream = new ByteArrayInputStream(Constants.ALREADYVOTED.getBytes());
		else if (message.equals(Constants.CREDITSNOTENOUGH))
			inputStream = new ByteArrayInputStream(Constants.CREDITSNOTENOUGH.getBytes());
		else if (message.equals(Constants.OWNER))
			inputStream = new ByteArrayInputStream(Constants.OWNER.getBytes());
		else if (message.equals(Constants.DBERROR))
			inputStream = new ByteArrayInputStream(Constants.DBERROR.getBytes());
		return Constants.SUCCESS;
	}
	public String voteDown(){
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}

		String message = bugVoteService.voteDown(bugId, nowUser);
		if (message.equals(Constants.SUCCESS))
			inputStream = new ByteArrayInputStream(Constants.SUCCESS.getBytes());
		else if (message.equals(Constants.ALREADYVOTED))
			inputStream = new ByteArrayInputStream(Constants.ALREADYVOTED.getBytes());
		else if (message.equals(Constants.CREDITSNOTENOUGH))
			inputStream = new ByteArrayInputStream(Constants.CREDITSNOTENOUGH.getBytes());
		else if (message.equals(Constants.OWNER))
			inputStream = new ByteArrayInputStream(Constants.OWNER.getBytes());
		else if (message.equals(Constants.DBERROR))
			inputStream = new ByteArrayInputStream(Constants.DBERROR.getBytes());
		return Constants.SUCCESS;
	}
}
