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
		return this.sessionFactory.openSession().get(HashForPasswordRetrieve.class, ID);
	}
	
	public HashForPasswordRetrieve getByHashValue(String hashValue){
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(HashForPasswordRetrieve.class);
			c.add(Restrictions.eq("hashvalue", hashValue));
			return (HashForPasswordRetrieve) c.uniqueResult();
		} finally{
			if(s!=null)
				s.close();
		}
	}

}
