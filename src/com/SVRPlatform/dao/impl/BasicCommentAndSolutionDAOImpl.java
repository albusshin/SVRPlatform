package com.SVRPlatform.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.SVRPlatform.model.BasicCommentAndSolution;

abstract class BasicCommentAndSolutionDAOImpl extends BasicDAOImpl {

	//protected methods
		@SuppressWarnings("rawtypes")
		protected List getByUserOrBugId(Class clazz, int fetchSize, int firstResult, int type, Object... obj){
			Session s = this.sessionFactory.openSession();
			String str = null;
			try{
				org.hibernate.Criteria c = s.createCriteria(clazz);
				for(int i = 0; i<obj.length; i++){
					str = obj[i].getClass().getSimpleName().toLowerCase();
					c.add(Restrictions.eq(str, obj[i]));
				}
				if(fetchSize > 0)
					c.setMaxResults(fetchSize);
				if(firstResult >= 0)
					c.setFirstResult(firstResult);
				@SuppressWarnings("unchecked")
				List<BasicCommentAndSolution> list= c.list();
				switch(type){
				case 1: {
					for(BasicCommentAndSolution bcas : list){
						bcas.getBug();
						bcas.getUser();//initialize Bug and User
					}break;
				}
				case 2:for(BasicCommentAndSolution bcas : list){
						bcas.getBug();//initialize Bug
					}break;
				case 3:for(BasicCommentAndSolution bcas : list){
						bcas.getUser();//initialize User
					}break;
				}
				return c.list();
			} finally{
				str = null;
				if(s!=null)
					s.close();
			}
			
		}
}
