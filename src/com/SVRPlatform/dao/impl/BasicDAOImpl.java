package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.SVRPlatform.dao.basicDAO;

public abstract class BasicDAOImpl implements basicDAO{
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Serializable add(Object obj) {
		// TODO Auto-generated method stub
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			Serializable se = s.save(obj);
			tx.commit();
			return se;
		} finally {
			if(s != null)
				s.close();
		}
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			s.update(obj);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			s.delete(obj);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}
	}

}
