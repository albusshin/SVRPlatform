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
	public BugCommentsData commentsDispalyService(String bugNumber, int pageNumber, int commentsPerPage) {
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		
		
		//List<Comment> comments = commentDAO.getByBugId(bugID, commentsPer, firstResult)

		return null;
	}

}
