package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.SVRPlatform.model.Bug;

public class BugDAOImpl {
	private SessionFactory sessionFactory;
	
	public Serializable addBug(Bug bug){
		Session s = sessionFactory.openSession();
		s.save(bug);
		s.close();
		return bug.getBugId();
	}

}
