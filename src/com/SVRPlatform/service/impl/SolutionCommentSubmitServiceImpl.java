package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.SVRPlatform.dao.SolutionCommentDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionComment;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.SolutionCommentSubmitService;

public class SolutionCommentSubmitServiceImpl implements
		SolutionCommentSubmitService {
	private SolutionDAO solutionDAO;
	private UserDAO userDAO;
	private SolutionCommentDAO solutionCommentDAO;
	
	public SolutionCommentDAO getSolutionCommentDAO() {
		return solutionCommentDAO;
	}
	public void setSolutionCommentDAO(SolutionCommentDAO solutionCommentDAO) {
		this.solutionCommentDAO = solutionCommentDAO;
	}
	public SolutionDAO getSolutionDAO() {
		return solutionDAO;
	}
	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public Map<String, String> commentSubmit(int solutionId, String email,
			String content) {
		// TODO Auto-generated method stub
		//System.out.println("service:"+solutionId+"_"+email+"_"+content);
		Map<String, String> map = new HashMap<String, String>();
		
		if (content.compareTo("") == 0) 
			map.put("content", "empty");
		else if (content.length() > 5000) 
			map.put("content", "tooLong");
		else map.put("content", "OK");
		try{
			if (map.get("content").equals("OK")) {
				
				User user = userDAO.getUserByEmail(email);
				Solution solution = (Solution) solutionDAO.getByID(new Integer(solutionId));
				if(solution == null)
					throw new Exception("No such solution");
				//System.out.println(solution.getSolutionId());
				SolutionComment solutionComment = new SolutionComment();
				
				solutionComment.setContent(content);
				solutionComment.setSolution(solution);
				solutionComment.setUser(user);
				System.out.println(solutionComment.getSolution().getSolutionId());
				
				solutionCommentDAO.add(solutionComment);
				map.put("status", "success");
				
			} else {
				map.put("status", "failed");
			}
		}catch(Exception e){
			map.put("message", e.getMessage());
			map.put("status", "failed");
		}
		return map;
	}

}
