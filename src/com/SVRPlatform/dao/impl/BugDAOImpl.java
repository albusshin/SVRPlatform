package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;
@Transactional
public class BugDAOImpl {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Serializable addBug(Bug bug){
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			Serializable se = s.save(bug);
			tx.commit();
			return se;
		} finally {
			if(s != null)
				s.close();
		}
	}
	
	public void updateBug(Bug bug){
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			s.update(bug);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}
	}
	
	public void deleteBug(Bug bug){
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			s.delete(bug);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}
	}
	
	public Bug getBugbyId(Integer id){
		Session s = null;
		try{
			//Session ss = sessionFactory.getCurrentSession();
			s = sessionFactory.getCurrentSession();
			Bug b = (Bug) s.get(Bug.class, id);
			Hibernate.initialize(b);
			return b;
		} finally {
//			if(s != null)
//				s.close();
		}
	}
	
	public Bug getBugbyBugNmber(String bugNumber){
		Session s = this.sessionFactory.openSession();
		try {
			org.hibernate.Criteria c = s.createCriteria(Bug.class);
			c.add(Restrictions.eq("bugNumber", bugNumber));
			Bug b = (Bug) c.uniqueResult();
			Hibernate.initialize(b);
			return b;
		}finally {
//			if(s!=null)
//				s.close();
		}
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

}
