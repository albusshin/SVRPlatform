package com.SVRPlatform.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.SVRPlatform.dao.CommentDAO;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.User;

public class CommentDAOImpl extends BasicCommentAndSolutionDAOImpl implements CommentDAO {

	@Override
	public Object getByID(Serializable ID) {
		// TODO Auto-generated method stub
		Session s = null;
		try{
			s = this.sessionFactory.openSession();
			return s.get(Comment.class, ID);
		} finally {
			if(s != null)
				s.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.SVRPlatform.dao.impl.CommentDAO#getByUserIdAndBugId(com.SVRPlatform.model.User, com.SVRPlatform.model.Bug)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getByUserIdAndBugId(User user, Bug bug, int fetchSize,
			int firstResult){
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
		return (List<Comment>) getByUserOrBugId(Comment.class, fetchSize, firstResult, 1, bug, user);
	}
	
	/* (non-Javadoc)
	 * @see com.SVRPlatform.dao.impl.CommentDAO#getByBugId(com.SVRPlatform.model.Bug, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getByBugId(Bug bug, int fetchSize, int firstResult){
		return getByUserOrBugId(Comment.class, fetchSize, firstResult, 2, bug);
	}
	
	/* (non-Javadoc)
	 * @see com.SVRPlatform.dao.impl.CommentDAO#getByUserId(com.SVRPlatform.model.User, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getByUserId(User user, int fetchSize, int firstResult){
		return getByUserOrBugId(Comment.class, fetchSize, firstResult, 3, user);
	}
	
	
}
