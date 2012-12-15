package com.SVRPlatform.service.impl;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.data.BugCommentsData;
import com.SVRPlatform.service.CommentsDisplayService;

public class CommentsDisplayServiceImpl implements CommentsDisplayService {
	private CommentDAO commentDAO;
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	@Override
	public BugCommentsData commentsDispalyService(String bugNumber) {
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		

		return null;
	}

}
