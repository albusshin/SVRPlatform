package com.SVRPlatform.action;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.SolutionCommentsData;
import com.SVRPlatform.service.SolutionCommentDisplayService;
import com.SVRPlatform.service.SolutionCommentSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class SolutionComment extends ActionSupport {

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
	//getters and setters
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
		//test input
		this.solutionId = 11;
		//test input end
		this.solutionCommentsData = 
		this.solutionCommentDisplayService.commentsDispalyService(solutionId, 0, 0);
		return Constants.SUCCESS;
	}
	
	public String submitSolutionComment(){
		return Constants.SUCCESS;
	}
	

}
