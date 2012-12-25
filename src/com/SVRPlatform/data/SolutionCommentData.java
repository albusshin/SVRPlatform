package com.SVRPlatform.data;

public class SolutionCommentData {
	private int solutionCommentID;
	private String content;
	private String realname;
	private String email;
	private int credits;
	
	public int getSolutionCommentID() {
		return solutionCommentID;
	}
	public void setSolutionCommentID(int solutionCommentID) {
		this.solutionCommentID = solutionCommentID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
}
