 package com.SVRPlatform.dao.impl;
 
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.User;
@Transactional
@Repository("userDAO") 
public class UserDAOImpl extends BasicDAOImpl implements UserDAO {
	
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(User.class);
			c.add(Restrictions.eq("email", email));
			return (User) c.uniqueResult();
		} finally {
			if(s != null)
				s.close();
		}
	}

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			return s.get(User.class, ID);
		} finally {
			if(s != null)
				s.close();
		}
	}
 }
