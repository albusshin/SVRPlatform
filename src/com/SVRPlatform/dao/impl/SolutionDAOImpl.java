package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;

public class SolutionDAOImpl extends BasicCommentAndSolutionDAOImpl implements SolutionDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		return this.sessionFactory.openSession().get(Solution.class, ID);
	}

	@Override
	public Solution getByUserIdAndBugId(User user, Bug bug) {
		// TODO Auto-generated method stub
		return (Solution) getByUserOrBugId(Solution.class, -1, -1, bug, user).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solution> getByBugId(Bug bug, int fetchSize, int firstResult) {
		// TODO Auto-generated method stub
		return getByUserOrBugId(Solution.class, fetchSize, firstResult, bug);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solution> getByUserId(User user, int fetchSize, int firstResult) {
		// TODO Auto-generated method stub
		return getByUserOrBugId(Solution.class, fetchSize, firstResult, user);
	}

}
