 package com.SVRPlatform.dao.impl;
 
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;

@Repository("userDAO") @Transactional
public class UserDAOImpl implements UserDAO {
	@Resource
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
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		s.save(user);
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
 
 }
