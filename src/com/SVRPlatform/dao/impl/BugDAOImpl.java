package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;
@Transactional
public class BugDAOImpl extends BasicDAOImpl implements BugDAO{
	
	public Bug getBugbyBugNmber(String bugNumber){
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(Bug.class);
			c.add(Restrictions.eq("bugNumber", bugNumber));
			return (Bug) c.uniqueResult();
		}finally {
			if(s!=null)
				s.close();
		}
	}

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			Bug b = (Bug) s.get(Bug.class, ID);
			if(b==null)
				return b;
			b.getUser().getCredit();
			b.getSoftware().getName();
			return b;
		} finally {
			if(s != null)
				s.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bug> getByUser(User user) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(Bug.class);
			c.add(Restrictions.eq("user", user));
			return c.list();
		}finally {
			if(s!=null)
				s.close();
		}
	}

}
