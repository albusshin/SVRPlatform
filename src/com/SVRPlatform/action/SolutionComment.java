package com.SVRPlatform.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.SVRPlatform.Utils.VerifyUser;
import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.data.SolutionCommentsData;
import com.SVRPlatform.service.SolutionCommentDisplayService;
import com.SVRPlatform.service.SolutionCommentSubmitService;
import com.opensymphony.xwork2.ActionSupport;

public class SolutionComment extends ActionSupport implements ServletRequestAware{

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
	
	//getters and setters
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
		/*//test input
		this.solutionId = 11;
		//test input end
*/		this.solutionCommentsData = 
		this.solutionCommentDisplayService.commentsDispalyService(solutionId, 0, 0);
		return Constants.SUCCESS;
	}
	
	public String submitSolutionComment(){
		System.out.println("now in submit solution comment method..");
		System.out.println("solutionId: "+solutionId);
		System.out.println("email: "+email);
		System.out.println("content: "+content);
		this.solutionCommentSubmitService.commentSubmit(solutionId, email, content);
		
		return Constants.SUCCESS;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.email = VerifyUser.getNowUser(arg0);
	}
	

}
