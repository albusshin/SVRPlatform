package com.SVRPlatform.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.SVRPlatform.dao.SolutionCommentDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.data.SolutionCommentData;
import com.SVRPlatform.data.SolutionCommentsData;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionComment;
import com.SVRPlatform.service.SolutionCommentDisplayService;

public class SolutionCommentDisplayServiceImpl implements
		SolutionCommentDisplayService {
	private UserDAO userDAO;
	private SolutionDAO solutionDAO;
	private SolutionCommentDAO solutionCommentDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public SolutionDAO getSolutionDAO() {
		return solutionDAO;
	}
	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}
	public SolutionCommentDAO getSolutionCommentDAO() {
		return solutionCommentDAO;
	}
	public void setSolutionCommentDAO(SolutionCommentDAO solutionCommentDAO) {
		this.solutionCommentDAO = solutionCommentDAO;
	}
	
	@Override
	public SolutionCommentsData commentsDispalyService(int solutionId,
			int pageNumber, int commentsPerPage) {
		Solution solution = (Solution) solutionDAO.getByID(new Integer(solutionId));
		
		List<SolutionComment> solutionComments = solutionCommentDAO.getBySolution(solution, -1, -1);
		SolutionCommentsData solutionCommentsData = new SolutionCommentsData();
		List<SolutionCommentData> list = new ArrayList<SolutionCommentData>();
		solutionCommentsData.setSolutionCommetCount(solutionComments.size());
		for(SolutionComment sc: solutionComments){
			SolutionCommentData scd = new SolutionCommentData();
			scd.setContent(sc.getContent());
			scd.setSolutionCommentID(sc.getId());
			scd.setCredits(sc.getUser().getCredit());
			scd.setEmail(sc.getUser().getEmail());
			scd.setRealname(sc.getUser().getRealName());
			list.add(scd);
		}
		solutionCommentsData.setSolutionCommentsData(list);
		return solutionCommentsData;
	}

}
