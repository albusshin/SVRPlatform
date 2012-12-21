package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.SVRPlatform.dao.SolutionVoteDAO;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionVote;
import com.SVRPlatform.model.User;

public class SolutionVoteDAOImpl extends BasicDAOImpl implements SolutionVoteDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			return s.get(SolutionVote.class, ID);
		}finally{
			if(s!=null)
				s.close();
		}
	}

	@Override
	public SolutionVote getByUserAndSolution(User user, Solution solution) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(SolutionVote.class);
			c.add(Restrictions.eq("user", user));
			c.add(Restrictions.eq("solution", solution));
			return (SolutionVote) c.uniqueResult();
		}finally{
			if(s!=null)
				s.close();
		}
	}

}
