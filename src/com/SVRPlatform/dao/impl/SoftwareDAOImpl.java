package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.SVRPlatform.dao.SoftwareDAO;
import com.SVRPlatform.model.Software;

public class SoftwareDAOImpl extends BasicDAOImpl implements SoftwareDAO{

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			return s.get(Software.class, ID);
		} finally {
			if(s != null)
				s.close();
		}
	}

	@Override
	public Software getSoftwareByName(String name) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(Software.class);
			c.add(Restrictions.eq("name", name));
			return (Software) c.uniqueResult();
		}finally {
			if(s != null)
				s.close();
		}
	}
}
