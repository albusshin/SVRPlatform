package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.User;

public class CommentDAOImpl extends BasicCommentAndSolutionDAOImpl implements CommentDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		return this.sessionFactory.openSession().get(Comment.class, ID);
	}
	
	/* (non-Javadoc)
	 * @see com.SVRPlatform.dao.impl.CommentDAO#getByUserIdAndBugId(com.SVRPlatform.model.User, com.SVRPlatform.model.Bug)
	 */
	@Override
	public Comment getByUserIdAndBugId(User user, Bug bug){
//		Session s = this.sessionFactory.openSession();
//		try{
//			org.hibernate.Criteria c = s.createCriteria(Comment.class);
//			c.add(Restrictions.eq("bug", bug));
//			c.add(Restrictions.eq("user", user));
//			return (Comment) c.uniqueResult();
//		}finally {
//			if(s!=null)
//				s.close();
//		}
		return (Comment) getByUserOrBugId(Comment.class, -1, -1, bug, user).get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.SVRPlatform.dao.impl.CommentDAO#getByBugId(com.SVRPlatform.model.Bug, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getByBugId(Bug bug, int fetchSize, int firstResult){
		return getByUserOrBugId(Comment.class, fetchSize, firstResult, bug);
		
	}
	
	/* (non-Javadoc)
	 * @see com.SVRPlatform.dao.impl.CommentDAO#getByUserId(com.SVRPlatform.model.User, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getByUserId(User user, int fetchSize, int firstResult){
		return getByUserOrBugId(Comment.class, fetchSize, firstResult, user);
	}
	
	
}
