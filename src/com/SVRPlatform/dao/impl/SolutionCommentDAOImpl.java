package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.SVRPlatform.dao.SolutionCommentDAO;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionComment;
import com.SVRPlatform.model.User;

public class SolutionCommentDAOImpl extends BasicCommentAndSolutionDAOImpl
		implements SolutionCommentDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			return s.get(SolutionComment.class, ID);
		} finally {
			if(s != null)
				s.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolutionComment> getByUserAndSolution(User user,
			Solution solution, int fetchSize, int firstResult) {
		// TODO Auto-generated method stub
		return getByObjects(SolutionComment.class, false, fetchSize, firstResult, 1, solution, user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolutionComment> getBySolution(Solution solution,
			int fetchSize, int firstResult) {
		// TODO Auto-generated method stub
		return getByObjects(SolutionComment.class, false, fetchSize, firstResult, 2, solution);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolutionComment> getByUser(User user, int fetchSize,
			int firstResult) {
		// TODO Auto-generated method stub
		return getByObjects(SolutionComment.class, false, fetchSize, firstResult, 4, user);
	}

	@Override
	public long getCountFromOneSolution(Solution solution) {
		// TODO Auto-generated method stub
		long count = ((Long)getByObjects(SolutionComment.class, true, -1, -1, 1, solution)
				.get(0)).intValue();
		return count;
	}

	@Override
	public long getCountFromOneUser(User user) {
		// TODO Auto-generated method stub
		long count = ((Long)getByObjects(SolutionComment.class, true, -1, -1, 1, user)
				.get(0)).intValue();
		return count;
	}

}
