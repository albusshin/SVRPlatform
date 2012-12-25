package com.SVRPlatform.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.SolutionSubmitService;

public class SolutionSubmitServiceImpl implements SolutionSubmitService {
	private SolutionDAO solutionDAO;
	private BugDAO bugDAO;
	private UserDAO userDAO;
	
	public SolutionDAO getSolutionDAO() {
		return solutionDAO;
	}

	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}

	public BugDAO getBugDAO() {
		return bugDAO;
	}

	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Map<String, String> solutionSubmit(String bugNumber, String email,
			String content) {
		// TODO Auto-generated method stub
		
		//to store the information to be returned
		Map<String, String> map = new HashMap<String, String>();
		
		//check if bug information is complete
				
				if (content.compareTo("") == 0) 
					map.put("content", "empty");
				else if (content.length() > 5000) 
					map.put("content", "tooLong");
				else map.put("content", "OK");
				
				if (map.get("content").equals("OK")) {
					

					int bugID = Integer.parseInt(bugNumber.split("-")[2]);
					Bug bug = (Bug) bugDAO.getByID(bugID);
					User user = userDAO.getUserByEmail(email);
					if(solutionDAO.getByUserIdAndBugId(user, bug, -1, -1).size() != 0){
						map.put("content", "alreadySubmit");
						map.put("status", "fail");
						return map;
					}
					Solution solution = new Solution();
					solution.setBug(bug);
					//solution.setCommentTitle(title);
					solution.setContent(content);
					solution.setDatetime(new Date());
					solution.setUser(user);
					solution.setUp(new Integer(0));
					solution.setDown(new Integer(0));
					
					solutionDAO.add(solution);
					map.put("status", "success");
				}
				else map.put("status", "fail");
				
				return map;
	}

	@Override
	public Map<String, String> solutionEdit(String bugNumber, String email,
			String content) {
		Map<String, String> map = new HashMap<String, String>();
		
		//check if bug information is complete
				
				if (content.compareTo("") == 0) 
					map.put("content", "empty");
				else if (content.length() > 5000) 
					map.put("content", "tooLong");
				else map.put("content", "OK");
				
				if (map.get("content").equals("OK")) {

					int bugID = Integer.parseInt(bugNumber.split("-")[2]);
					Bug bug = (Bug) bugDAO.getByID(bugID);
					User user = userDAO.getUserByEmail(email);
					List<Solution> solutions = solutionDAO.getByUserIdAndBugId(user, bug, -1, -1);
				
					if(solutions.size() == 0){
						map.put("content", "doesnotExist");
						map.put("status", "fail");
						return map;
					}
					Solution solution = solutions.get(0);
					solution.setContent(content);
					solution.setDatetime(new Date());
					
					solutionDAO.update(solution);
					map.put("status", "success");
				}
				else map.put("status", "fail");
				
				return map;
	}

}
