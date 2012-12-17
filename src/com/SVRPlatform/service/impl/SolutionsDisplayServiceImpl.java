package com.SVRPlatform.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.data.BugSolutionsData;
import com.SVRPlatform.data.CommentData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Comment;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.SolutionsDisplayService;

public class SolutionsDisplayServiceImpl implements SolutionsDisplayService {
	private BugDAO bugDAO;
	private SolutionDAO solutionDAO;
	
	public SolutionDAO getSolutionDAO() {
		return solutionDAO;
	}
	
	public void setSolutionDAO(SolutionDAO solutionDAO) {
		this.solutionDAO = solutionDAO;
	}
	
	public BugDAO getBugDAO() {
		return bugDAO;
	}

	public void setBugDAO(BugDAO bugDAO) {
		this.bugDAO = bugDAO;
	}

	public BugSolutionsData solutionsDisplayService(String bugNumber, int pageNumber, int solutionsPerPage) {
		BugSolutionsData bugSolutionsData = new BugSolutionsData();
		
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		Bug bug = (Bug) bugDAO.getByID(bugID);
		int officialSolutionID = bug.getOfficialSolutionId();
		
		int count =  (int) solutionDAO.getCountFromOneBug(bug);

		int firstResult = (pageNumber - 1) * solutionsPerPage;
		if ( >= firstResult) {
			solutionsPerPage += firstResult;
			firstResult = 0;
		}
		List<Solution> solutions = solutionDAO.getByBugId(bug, solutionsPerPage, firstResult);
		List<SolutionData> solutionsData = new LinkedList<SolutionData>();

		ListIterator<Solution> it = solutions.listIterator();
		Solution solution;
		SolutionData solutionData;
		User user;
		while(it.hasNext()) it.next();
		while(it.hasPrevious()) {
			comment = it.previous();
			commentData = new CommentData();
			user = comment.getUser();
			
			commentData.setTitle(comment.getCommentTitle());
			commentData.setContent(comment.getContent());
			commentData.setDatetime(comment.getDatetime().toString());
			commentData.setRealname(user.getRealName());
			commentData.setEmail(user.getEmail());
			commentData.setCredits(user.getCredit());
			commentsData.add(commentData);
		}

		bugCommentsData.setCommentCount(count);
		bugCommentsData.setCommentsData(commentsData);

		return bugCommentsData;
	}

	public SolutionData officialSolutionDisplayService(String bugNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
