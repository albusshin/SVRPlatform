package com.SVRPlatform.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.SolutionCommentsData;
import com.SVRPlatform.service.SolutionCommentDisplayService;
import com.SVRPlatform.service.SolutionCommentSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class SolutionComment extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service
	private SolutionCommentSubmitService solutionCommentSubmitService;
	private SolutionCommentDisplayService solutionCommentDisplayService;
	//data
	private SolutionCommentsData solutionCommentsData;
	private String email;
	private int solutionId;
	private String content;
	//for ajax return
	InputStream inputStream;
	

	//getters and setters
	public InputStream getInputStream() {
		return inputStream;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SolutionCommentSubmitService getSolutionCommentSubmitService() {
		return solutionCommentSubmitService;
	}
	public void setSolutionCommentSubmitService(
			SolutionCommentSubmitService solutionCommentSubmitService) {
		this.solutionCommentSubmitService = solutionCommentSubmitService;
	}
	public SolutionCommentDisplayService getSolutionCommentDisplayService() {
		return solutionCommentDisplayService;
	}
	public void setSolutionCommentDisplayService(
			SolutionCommentDisplayService solutionCommentDisplayService) {
		this.solutionCommentDisplayService = solutionCommentDisplayService;
	}
	public SolutionCommentsData getSolutionCommentsData() {
		return solutionCommentsData;
	}
	public void setSolutionCommentsData(SolutionCommentsData solutionCommentsData) {
		this.solutionCommentsData = solutionCommentsData;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	//functions to be executed
	public String displaySolutionComments(){
		this.solutionCommentsData = 
		this.solutionCommentDisplayService.commentsDispalyService(solutionId, 0, 0);
		return Constants.SUCCESS;
	}
	
	public String submitSolutionComment(){
		Map<String, String> map = this.solutionCommentSubmitService.commentSubmit(solutionId, email, content);
		if(map.get("status").equals("success"))
			inputStream = new ByteArrayInputStream(Constants.SUCCESS.getBytes());
		else
			inputStream = new ByteArrayInputStream(Constants.FAIL.getBytes());
		return "submit";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.email = VerifyUser.getNowUser(request);
	}
}
