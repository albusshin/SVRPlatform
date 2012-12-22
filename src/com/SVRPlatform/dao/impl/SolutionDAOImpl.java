package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;

public class SolutionDAOImpl extends BasicCommentAndSolutionDAOImpl implements SolutionDAO {

	@Override
	public Solution getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			Solution sol = (Solution) s.get(Solution.class, ID);
			sol.getUser().getEmail();
			////System.out.println(sol.getUser());
			return sol;
		} finally {
			if(s != null)
				s.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solution> getByUserIdAndBugId(User user, Bug bug, int fetchSize,
			int firstResult) {
		// TODO Auto-generated method stub
		return (List<Solution>) getByUserOrBugId(Solution.class, false, fetchSize, firstResult, 1, bug, user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solution> getByBugId(Bug bug, int fetchSize, int firstResult) {
		// TODO Auto-generated method stub
		//return getByUserOrBugId(Solution.class, false, fetchSize, firstResult, 2, bug);
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(Solution.class);
			int sid = bug.getOfficialSolutionId();
			if(sid > -1){
				c.add(Restrictions.ne("solutionId", new Integer(sid)));
			}
			c.add(Restrictions.eq("bug", bug));
			c.addOrder(Order.desc("points"));
			c.addOrder(Order.desc("up"));
			if(fetchSize > 0)
				c.setMaxResults(fetchSize);
			if(firstResult >= 0)
				c.setFirstResult(firstResult);
			c.setFetchMode("user", FetchMode.JOIN);
			return c.list();
		} finally{
			if(s!=null)
				s.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solution> getByUserId(User user, int fetchSize, int firstResult) {
		// TODO Auto-generated method stub
		return getByUserOrBugId(Solution.class, false, fetchSize, firstResult, 3, user);
	}

	@Override
	public long getCountFromOneBug(Bug bug) {
		// TODO Auto-generated method stub
		long count = ((Long)getByUserOrBugId(Solution.class, true, -1, -1, 2, bug)
				.get(0)).intValue();
		return count;
	}

	@Override
	public long getCountFromOneUser(User user) {
		// TODO Auto-generated method stub
		long count = ((Long)getByUserOrBugId(Solution.class, true, -1, -1, 2, user)
				.get(0)).intValue();
		return count;
	}

}
