package com.SVRPlatform.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.service.SolutionVoteService;
import com.opensymphony.xwork2.ActionSupport;

public class SolutionVoteAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware{

	HttpServletRequest request;
	HttpServletResponse response;
	int solutionId;
	SolutionVoteService solutionVoteService;
	InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}

	public void setSolutionVoteService(SolutionVoteService solutionVoteService) {
		this.solutionVoteService = solutionVoteService;
	}
	
	public String voteUp(){
		System.out.println("vote up!");
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}
		String message = solutionVoteService.voteUp(solutionId, nowUser);
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
		System.out.println("vote down!");
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}

		String message = solutionVoteService.voteDown(solutionId, nowUser);
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
	

}
