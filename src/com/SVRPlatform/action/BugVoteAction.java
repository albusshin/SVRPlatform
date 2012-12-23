package com.SVRPlatform.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.BugWatchService;
import com.opensymphony.xwork2.ActionSupport;

public class BugVoteAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String bugNumber;
	private BugWatchService bugWatchService;
	private InputStream inputStream;
	private HttpServletRequest request;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setBugNumber(String bugNumber) {
		this.bugNumber = bugNumber;
	}

	public void setBugWatchService(BugWatchService bugWatchService) {
		this.bugWatchService = bugWatchService;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
	public String voteUp(){
		System.out.println("bug vote up: "+bugNumber);
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		String message = bugWatchService.voteUp(bugID, nowUser);
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

		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		String message = bugWatchService.voteDown(bugID, nowUser);
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
