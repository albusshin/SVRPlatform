package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.SVRPlatform.dao.BugWatchDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.BugWatch;
import com.SVRPlatform.model.User;

public class BugWatchDAOImpl extends BasicDAOImpl implements BugWatchDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			return s.get(BugWatch.class, ID);
		}finally{
			if(s!=null)
				s.close();
		}
	}

	@Override
	public BugWatch getByUserAndBug(User user, Bug bug) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(BugWatch.class);
			c.add(Restrictions.eq("user", user));
			c.add(Restrictions.eq("bug", bug));
			return (BugWatch) c.uniqueResult();
		}finally{
			if(s!=null)
				s.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BugWatch> getSolutionIdFromSolutionList(List<Bug> bug, User user) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(BugWatch.class);
			c.add(Restrictions.eq("user", user));
			c.add(Restrictions.in("bug", bug.toArray()));
			c.setFetchMode("bug", FetchMode.JOIN);	
			return c.list();
		}finally{
			if(s!=null)
				s.close();
		}
	}

	@Override
	public List<Bug> getByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
