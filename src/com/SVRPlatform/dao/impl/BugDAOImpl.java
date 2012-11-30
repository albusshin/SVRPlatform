package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;
@Transactional
public class BugDAOImpl extends BasicDAOImpl implements BugDAO{
	
	public Bug getBugbyBugNmber(String bugNumber){
		Session s = this.sessionFactory.openSession();
		org.hibernate.Criteria c = s.createCriteria(Bug.class);
		c.add(Restrictions.eq("bugNumber", bugNumber));
		return (Bug) c.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public void bugWatched(Bug b, User u){
		Session s = this.sessionFactory.openSession();
		Transaction tx;
		try {
			b.getUsers().add(u);
			tx=s.beginTransaction();
			s.update(b);
			tx.commit();
		}finally {
			if(s!=null)
				s.close();
		}
	}

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Bug.class, ID);
	}

	@Override
	public Serializable add(Object obj) {
		// TODO Auto-generated method stub
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			Bug bug = (Bug)obj;
			Serializable se = s.save(obj);
			String str = bug.getBugNumber() + bug.getBugId();
			bug.setBugNumber(str);
			tx.commit();
			return se;
		} finally {
			if(s != null)
				s.close();
		}
	}

}
