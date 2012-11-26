package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Software;

public class SoftwareDAOImpl {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Serializable addSoftware(Software software){
		Session s = null;
		Transaction tx;
		try{
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			Serializable se = s.save(software);
			tx.commit();
			return se;
		} finally {
			if(s != null)
				s.close();
		}
	}

}
