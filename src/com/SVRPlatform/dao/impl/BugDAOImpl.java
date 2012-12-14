package com.SVRPlatform.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.model.Bug;
@Transactional
public class BugDAOImpl extends BasicDAOImpl implements BugDAO{
	
	public Bug getBugbyBugNmber(String bugNumber){
		Session s = this.sessionFactory.openSession();
		try{
			org.hibernate.Criteria c = s.createCriteria(Bug.class);
			c.add(Restrictions.eq("bugNumber", bugNumber));
			return (Bug) c.uniqueResult();
		}finally {
			if(s!=null)
				s.close();
		}
	}

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			return s.get(Bug.class, ID);
		} finally {
			if(s != null)
				s.close();
		}
	}

//	@Override
//	public Serializable add(Object obj) {
//		// TODO Auto-generated method stub
//		Session s = null;
//		Transaction tx;
//		try{
//			s = sessionFactory.openSession();
//			tx = s.beginTransaction();
//			Bug bug = (Bug)obj;
//			Serializable se = s.save(obj);
//			String str = bug.getBugNumber() + "-" 
//							+ String.format("%1$08d", bug.getBugId());
//			bug.setBugNumber(str);
//			tx.commit();
//			return se;
//		} finally {
//			if(s != null)
//				s.close();
//		}
//	}

}
