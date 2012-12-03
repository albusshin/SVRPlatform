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
		return sessionFactory.getCurrentSession().get(Software.class, ID);
	}

	@Override
	public Software getSoftwareByName(String name) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		org.hibernate.Criteria c = s.createCriteria(Software.class);
		c.add(Restrictions.eq("name", name));
		return (Software) c.uniqueResult();
	}
}
