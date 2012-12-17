package com.SVRPlatform.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.data.BugSolutionsData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.model.Bug;
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
		
		int count =  (int) solutionDAO.getCountFromOneBug(bug);
		if (bug.getOfficialSolutionId() != -1) count--;

		int firstResult = (pageNumber - 1) * solutionsPerPage;
		int fetchSize = solutionsPerPage;
		if (firstResult + fetchSize > count)
			fetchSize = count - firstResult;
		
		List<Solution> solutions = solutionDAO.getByBugId(bug, fetchSize, firstResult);
		List<SolutionData> solutionsData = new LinkedList<SolutionData>();

		ListIterator<Solution> it = solutions.listIterator();
		Solution solution;
		SolutionData solutionData;
		User user;
		while(it.hasNext()) {
			solution = it.next();
			solutionData = new SolutionData();
			user = solution.getUser();
			
			solutionData.setContent(solution.getContent());
			solutionData.setDatetime(solution.getDatetime().toString());
			solutionData.setRealname(user.getRealName());
			solutionData.setEmail(user.getEmail());
			solutionData.setCredits(user.getCredit());
			solutionData.setUp(solution.getUp());
			solutionData.setDown(solution.getDown());
			solutionData.setBest(false);
			solutionsData.add(solutionData);
		}
		if (pageNumber == 1) 
			solutionsData.get(0).setBest(true);
		
		bugSolutionsData.setSolutionCount(count);
		bugSolutionsData.setSolutionsData(solutionsData);

		return bugSolutionsData;
	}

	public SolutionData officialSolutionDisplayService(String bugNumber) {
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		Bug bug = (Bug) bugDAO.getByID(bugID);
		int officialSolutionID = bug.getOfficialSolutionId();
		SolutionData solutionData = new SolutionData();
		Solution solution = (Solution) solutionDAO.getByID(officialSolutionID);
		User user = solution.getUser();
		
		solutionData.setContent(solution.getContent());
		solutionData.setDatetime(solution.getDatetime().toString());
		solutionData.setRealname(user.getRealName());
		solutionData.setEmail(user.getEmail());
		solutionData.setCredits(user.getCredit());
		solutionData.setUp(solution.getUp());
		solutionData.setDown(solution.getDown());
		solutionData.setBest(false);
		
		return solutionData;
	}
}