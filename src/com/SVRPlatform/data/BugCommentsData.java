package com.SVRPlatform.data;

import java.util.List;

public class BugCommentsData {
	
	private int bugCount;
	private String bugNumber;
	private List<CommentData> comments;
	

	public int getBugCount() {
		return bugCount;
	}
	public void setBugCount(int bugCount) {
		this.bugCount = bugCount;
	}
	public String getBugNumber() {
		return bugNumber;
	}
	public void setBugNumber(String bugNumber) {
		this.bugNumber = bugNumber;
	}
	public List<CommentData> getComments() {
		return comments;
	}
	public void setComments(List<CommentData> comments) {
		this.comments = comments;
	}
}