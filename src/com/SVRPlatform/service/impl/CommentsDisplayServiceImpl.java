package com.SVRPlatform.service.impl;

import java.util.List;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.data.BugCommentsData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.service.CommentsDisplayService;

public class CommentsDisplayServiceImpl implements CommentsDisplayService {
	private CommentDAO commentDAO;
	private BugDAO bugDAO;
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	
	@Override
	public BugCommentsData commentsDispalyService(String bugNumber, int pageNumber, int commentsPerPage) {
		BugCommentsData bugCommentsData = new BugCommentsData();
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		Bug bug = (Bug) bugDAO.getByID(bugID);
		int firstResult = (pageNumber-1) * commentsPerPage + 1;
		
		List<Comment> comments = commentDAO.getByBugId(bug, commentsPerPage, firstResult);
		
		//bugCommentsData.setCommentCount(commentCount);
		

		return null;
	}

}
