package com.SVRPlatform.data;

import java.util.List;

public class BugCommentsData {
	
	private int commentCount;
	private List<CommentData> commentsData;

	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public List<CommentData> getCommentsData() {
		return commentsData;
	}
	public void setCommentsData(List<CommentData> commentsData) {
		this.commentsData = commentsData;
	}
}