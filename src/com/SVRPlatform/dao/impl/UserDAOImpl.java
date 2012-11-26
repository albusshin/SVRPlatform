 package com.SVRPlatform.dao.impl;
 
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.User;
@Transactional
@Repository("userDAO") 
public class UserDAOImpl implements UserDAO {
	//@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String getPasswordByEmail(String email) {
		// TODO Auto-generated method stub
		User u = this.getUserByName(email);
		return u == null? null : u.getPassword();
	}

	@Override
	public boolean ifEmailExists(String email) {
		// TODO Auto-generated method stub
		return this.getUserByName(email) != null;
	}

	@Override
	public Serializable addUser(User user) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try {
			return s.save(user);
		}finally {
			if(s!=null)
				s.close();
		}
	}
//	protected functions
	protected User getUserByName(String email) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try {
			org.hibernate.Criteria c = s.createCriteria(User.class);
			c.add(Restrictions.eq("email", email));
			return (User) c.uniqueResult();
		}finally {
			if(s!=null)
				s.close();
		}
	}
	
	protected User getUserById(Integer id) {
		// TODO Auto-generated method stub
		/*
		 * do something here;
		 */
		Session s = this.sessionFactory.openSession();
		return (User) s.get(User.class, id);
 	}

	@Override
	public Serializable getSoftwareByName(String softwareName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable addBug(Bug bug) {
		// TODO Auto-generated method stub
		return null;
	}
 
 }
