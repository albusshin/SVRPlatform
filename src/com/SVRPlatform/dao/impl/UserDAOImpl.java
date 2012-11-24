package com.SVRPlatform.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.model.Users;

@Repository("userDAO") @Transactional
public class UserDAOImpl implements UserDAO {
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public String getPasswordByEmail(String email) {
		// TODO Auto-generated method stub
		return this.getUsersByName(email).getPassword();
	}

	@Override
	public boolean ifEmailExists(String email) {
		// TODO Auto-generated method stub
		return this.getUsersByName(email) != null;
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		s.save(user);
	}
//	protected functions
	protected Users getUsersByName(String email) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try {
			org.hibernate.Criteria c = s.createCriteria(Users.class);
			c.add(Restrictions.eq("email", email));
			return (Users) c.uniqueResult();
		}finally {
			if(s!=null)
				s.close();
		}
	}
	
	protected Users getUsersById(Integer id) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		return (Users) s.get(Users.class, id);
	}

}
