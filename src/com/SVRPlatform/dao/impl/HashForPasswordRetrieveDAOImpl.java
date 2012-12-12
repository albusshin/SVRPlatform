package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.SVRPlatform.dao.HashForPasswordRetrieveDAO;
import com.SVRPlatform.model.HashForPasswordRetrieve;

public class HashForPasswordRetrieveDAOImpl extends BasicDAOImpl implements
		HashForPasswordRetrieveDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			return s.get(HashForPasswordRetrieve.class, ID);
		} finally {
			if(s!=null)
				s.close();
		}
	}
	
	public HashForPasswordRetrieve getByHashValue(String hashValue){
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(HashForPasswordRetrieve.class);
			c.add(Restrictions.eq("hashValue", hashValue));
			return (HashForPasswordRetrieve) c.uniqueResult();
		} finally{
			if(s!=null)
				s.close();
		}
	}

}
