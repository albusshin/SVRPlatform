package com.SVRPlatform.service.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.data.BugCommentsData;
import com.SVRPlatform.data.CommentData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.User;
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
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		Bug bug = (Bug) bugDAO.getByID(bugID);
		
		int count =  (int) commentDAO.getCountFromOneBug(bug);
		BugCommentsData bugCommentsData = new BugCommentsData();
		
		int firstResult = count - 1 - pageNumber * (commentsPerPage - 1);
		List<Comment> comments = commentDAO.getByBugId(bug, commentsPerPage, firstResult);
		List<CommentData> commentsData = new LinkedList<CommentData>();
		
		ListIterator<Comment> it = comments.listIterator();
		Comment comment;
		CommentData commentData;
		User user;
		while(it.hasNext()) it.next();
		while(it.hasPrevious()) {
			comment = it.previous();
			commentData = new CommentData();
			user = comment.getUser();
			
			commentData.setTitle(comment.getCommentTitle());
			commentData.setContent(comment.getContent());
			commentData.setDatetime(comment.getDatetime().toString());
			commentData.setRealname(user.getRealName());
			commentData.setEmail(user.getEmail());
			commentData.setCredits(user.getCredit());
			commentsData.add(commentData);
		}

		bugCommentsData.setCommentCount(count);
		bugCommentsData.setCommentsData(commentsData);

		return bugCommentsData;
	}
}
