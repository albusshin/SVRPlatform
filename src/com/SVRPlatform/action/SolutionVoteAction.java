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
		if (solutionVoteService.voteUp(solutionId, nowUser))
			inputStream = new ByteArrayInputStream(Constants.SUCCESS.getBytes());
	
		else
			inputStream = new ByteArrayInputStream(Constants.FAIL.getBytes());
		return Constants.SUCCESS;
	}
	public String voteDown(){
		String nowUser = VerifyUser.getNowUser(request);
		if (nowUser == null){
			return Constants.NOTSIGNEDIN;
		}

		if (solutionVoteService.voteDown(solutionId, nowUser))
			inputStream = new ByteArrayInputStream(Constants.SUCCESS.getBytes());
	
		else
			inputStream = new ByteArrayInputStream(Constants.FAIL.getBytes());
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
