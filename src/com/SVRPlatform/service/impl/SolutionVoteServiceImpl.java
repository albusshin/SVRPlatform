package com.SVRPlatform.service.impl;

import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.SolutionVoteService;

public class SolutionVoteServiceImpl implements SolutionVoteService {
	private SolutionDAO solutionDAO;
	private UserDAO userDAO;
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
	public boolean voteUp(int solutionId, String email) {
		// TODO Auto-generated method stub
		Solution solution = (Solution) solutionDAO.getByID(new Integer(solutionId));
		User user = userDAO.getUserByEmail(email);
		
		return addUpOrDown(solution, user, true);
	}

	@Override
	public boolean voteDown(int solutionId, String email) {
		// TODO Auto-generated method stub
		Solution solution = (Solution) solutionDAO.getByID(new Integer(solutionId));
		User user = userDAO.getUserByEmail(email);
		return addUpOrDown(solution, user, false);
	}
	
	protected boolean addUpOrDown(Solution solution, User user, boolean isUp){
		if(isUp)
			solution.setUp(new Integer(solution.getUp() + 1));
		else
			solution.setDown(new Integer(solution.getDown() + 1));
		solutionDAO.update(solution);
		return true;
	}

}
