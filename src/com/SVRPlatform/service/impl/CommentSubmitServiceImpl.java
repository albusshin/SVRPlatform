package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.service.CommentSubmitService;

public class CommentSubmitServiceImpl implements CommentSubmitService {
	private CommentDAO commentDAO;
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	@Override
	public Map<String, String> commentSubmit(String title, String content) {
		Map<String, String> map = new HashMap<String, String>();
		Comment comment = new Comment();
		
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
			
		}
		else map.put("status", "fail");
		
		return map;
	}
}