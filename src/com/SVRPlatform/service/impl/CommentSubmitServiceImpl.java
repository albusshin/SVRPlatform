package com.SVRPlatform.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.Utils.HTMLTranscoder;
import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.CommentSubmitService;

public class CommentSubmitServiceImpl implements CommentSubmitService {
	private CommentDAO commentDAO;
	private BugDAO bugDAO;
	private UserDAO userDAO;
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public Map<String, String> commentSubmit(String bugNumber, String email, String title, String content) {
		Map<String, String> map = new HashMap<String, String>();
		
		//check if bug information is complete
		if (title.compareTo("") == 0) 
			map.put("title", "empty");
		else if (title.length() > 256) 
			map.put("title", "tooLong");
		else map.put("title", "OK");
		
		if (content.compareTo("") == 0) 
			map.put("content", "empty");
		else if (content.length() > 5000) 
			map.put("content", "tooLong");
		else map.put("content", "OK");
		
		if (map.get("title").equals("OK") && map.get("content").equals("OK")) {
			map.put("status", "success");

			int bugID = Integer.parseInt(bugNumber.split("-")[2]);
			Bug bug = (Bug) bugDAO.getByID(bugID);
			User user = userDAO.getUserByEmail(email);
			Comment comment = new Comment();
			comment.setBug(bug);
			comment.setCommentTitle(HTMLTranscoder.transcode(title));
			comment.setContent(content);
			comment.setDatetime(new Date());
			comment.setUser(user);
			
			commentDAO.add(comment);
		}
		else map.put("status", "fail");
		
		return map;
	}
}