package com.SVRPlatform.data;

import java.util.List;

public class BugCommentsData {
	
	private int commentCount;
	private List<CommentData> comments;

	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public List<CommentData> getComments() {
		return comments;
	}
	public void setComments(List<CommentData> comments) {
		this.comments = comments;
	}
}