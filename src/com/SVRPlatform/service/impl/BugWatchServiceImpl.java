package com.SVRPlatform.service.impl;

import com.SVRPlatform.constants.Constants;
import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.BugWatchService;

public class BugWatchServiceImpl implements BugWatchService {
	private UserDAO userDAO;
	private BugDAO bugDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BugDAO getBugDAO() {
		return bugDAO;
	}

	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}

	@Override
	public String voteUp(int bugId, String email) {
		// TODO Auto-generated method stub
		Bug bug = (Bug) bugDAO.getByID(new Integer(bugId));
		return addUpOrDown(bug, true);
	}

	@Override
	public String voteDown(int bugId, String email) {
		// TODO Auto-generated method stub
		Bug bug = (Bug) bugDAO.getByID(new Integer(bugId));
		return addUpOrDown(bug, false);
	}
	
	protected String addUpOrDown(Bug bug, boolean isUp){
		User u = bug.getUser();
		if(isUp){
			bug.setUp(new Integer(bug.getUp() + 1));
			u.setCredit(u.getCredit() + Constants.BONUSONBUGUPORDOWN);
		}
		else{
			bug.setDown(new Integer(bug.getDown() + 1));
			u.setCredit(u.getCredit() - Constants.BONUSONBUGUPORDOWN);
		}
		bugDAO.update(bug);
		userDAO.update(u);
		return Constants.SUCCESS;
	}
	
	public boolean turnBackUp(Bug bug, boolean isUp){
		User u = bug.getUser();
		if(isUp){
			u.setCredit(u.getCredit() - Constants.BONUSONBUGUPORDOWN);
			bug.setUp(new Integer(bug.getUp() - 1));
		}
		else{
			u.setCredit(u.getCredit() + Constants.BONUSONBUGUPORDOWN);
			bug.setDown(new Integer(bug.getDown() - 1));
		}
		bugDAO.update(bug);
		userDAO.update(u);
		return true;
		
	}

}
