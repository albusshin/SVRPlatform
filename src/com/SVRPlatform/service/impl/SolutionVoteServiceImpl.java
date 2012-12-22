package com.SVRPlatform.service.impl;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Solution;
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
	public String voteUp(int solutionId, String email) {
		// TODO Auto-generated method stub
		System.out.println("servcie:"+email);
		Solution solution = (Solution) solutionDAO.getByID(new Integer(solutionId));
		
		return addUpOrDown(solution, true);
	}

	@Override
	public String voteDown(int solutionId, String email) {
		// TODO Auto-generated method stub
		System.out.println("servcie:"+email);
		Solution solution = (Solution) solutionDAO.getByID(new Integer(solutionId));
		return addUpOrDown(solution, false);
	}
	
	protected String addUpOrDown(Solution solution, boolean isUp){
		if(isUp)
			solution.setUp(new Integer(solution.getUp() + 1));
		else
			solution.setDown(new Integer(solution.getDown() + 1));
		solutionDAO.update(solution);
		return Constants.SUCCESS;
	}
	
	public boolean turnBackUp(Solution solution, boolean isUp){
		if(isUp)
			solution.setUp(new Integer(solution.getUp() - 1));
		else
			solution.setDown(new Integer(solution.getDown() - 1));
		solutionDAO.update(solution);
		return true;
		
	}

}
