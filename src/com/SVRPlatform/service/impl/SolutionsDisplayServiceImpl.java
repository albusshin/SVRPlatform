package com.SVRPlatform.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.SVRPlatform.Utils.HTMLTranscoder;
import com.SVRPlatform.dao.BugDAO;
import com.SVRPlatform.dao.SolutionDAO;
import com.SVRPlatform.dao.SolutionVoteDAO;
import com.SVRPlatform.dao.UserDAO;
import com.SVRPlatform.data.BugSolutionsData;
import com.SVRPlatform.data.SolutionData;
import com.SVRPlatform.model.Bug;
import com.SVRPlatform.model.Solution;
import com.SVRPlatform.model.SolutionVote;
import com.SVRPlatform.model.User;
import com.SVRPlatform.service.SolutionsDisplayService;

public class SolutionsDisplayServiceImpl implements SolutionsDisplayService {
	private BugDAO bugDAO;
	private UserDAO userDAO;
	private SolutionDAO solutionDAO;
	private SolutionVoteDAO solutionVoteDAO;
	
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

	public SolutionVoteDAO getSolutionVoteDAO() {
		return solutionVoteDAO;
	}

	public void setSolutionVoteDAO(SolutionVoteDAO solutionVoteDAO) {
		this.solutionVoteDAO = solutionVoteDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BugSolutionsData solutionsDisplayService(int userID, String bugNumber, int pageNumber, int solutionsPerPage) {
		BugSolutionsData bugSolutionsData = new BugSolutionsData();
		
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		Bug bug = (Bug) bugDAO.getByID(bugID);		
		int count =  (int) solutionDAO.getCountFromOneBug(bug);
		if (bug.getOfficialSolutionId() != -1) count--;

		int firstResult = (pageNumber - 1) * solutionsPerPage;
		int fetchSize = solutionsPerPage;
		if (firstResult + fetchSize > count)
			fetchSize = count - firstResult;
		
		if (bug.getOfficialSolutionId() != -1) count++;
		
		List<Solution> solutions = solutionDAO.getByBugId(bug, fetchSize, firstResult);
		List<SolutionData> solutionsData = new LinkedList<SolutionData>();
		//set bestSolutionID
		if (solutions.size() > 0 && pageNumber == 1) {
			bug.setBestSolutionId(solutions.get(0).getSolutionId());
			bugDAO.update(bug);
		}

		Map<Integer, Integer> voted = new HashMap<Integer, Integer>();
		if (userID != -1) {
			List<SolutionVote> solutionVotes = solutionVoteDAO.getSolutionIdFromSolutionList(solutions, (User)userDAO.getByID(userID));			
			for (int i = 0;i < solutionVotes.size();i++)
				voted.put(solutionVotes.get(i).getSolution().getSolutionId(), solutionVotes.get(i).getVoteFlag());
		}
		
		ListIterator<Solution> it = solutions.listIterator();
		Solution solution;
		SolutionData solutionData;
		User user;
		while(it.hasNext()) {
			solution = it.next();
			solutionData = new SolutionData();
			user = solution.getUser();			

			solutionData.setVotedUp(false);
			solutionData.setVotedDown(false);
			int solutionID = solution.getSolutionId();
			if (voted.containsKey(solutionID)) {
				if (voted.get(solutionID) == 1)
					solutionData.setVotedUp(true);
				else
					solutionData.setVotedDown(true);
			}
				
			solutionData.setSolutionID(solutionID);
			solutionData.setContent(HTMLTranscoder.transcode(solution.getContent()));
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

	public SolutionData officialSolutionDisplayService(int userID, String bugNumber) {
		int bugID = Integer.parseInt(bugNumber.split("-")[2]);
		Bug bug = (Bug) bugDAO.getByID(bugID);
		
		
		if (bug.getOfficialSolutionId() != -1) {
			int officialSolutionID = bug.getOfficialSolutionId();
			SolutionData solutionData = new SolutionData();
			Solution solution = (Solution) solutionDAO.getByID(officialSolutionID);
			User user = solution.getUser();			

			solutionData.setVotedUp(false);
			solutionData.setVotedDown(false);
			if (userID != -1) {
				SolutionVote solutionVote = solutionVoteDAO.getByUserAndSolution((User)userDAO.getByID(userID), solution);
				if (solutionVote != null){
					if (solutionVote.getVoteFlag() == 1)
						solutionData.setVotedUp(true);
					else
						solutionData.setVotedDown(true);
				}
			}
				
			solutionData.setSolutionID(solution.getSolutionId());
			solutionData.setContent(HTMLTranscoder.transcode(solution.getContent()));
			solutionData.setDatetime(solution.getDatetime().toString());
			solutionData.setRealname(user.getRealName());
			solutionData.setEmail(user.getEmail());
			solutionData.setCredits(user.getCredit());
			solutionData.setUp(solution.getUp());
			solutionData.setDown(solution.getDown());
			solutionData.setBest(false);
			
			return solutionData;
		}
		else return null;
	}
}